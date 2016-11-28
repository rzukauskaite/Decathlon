package com.decathlon.app.services.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.services.impl.ReaderServiceImpl;

/**
 * Unit tests for {@link ReaderServiceImpl}.
 *
 * @author redaz
 */
public class ReaderServiceImplTest {

    private static final String FILE_PATH = "D:/workspace [GitHub]/Decathlon/decathlon-app/src/test/resources";
    private static final String FILE_NAME = "Decathlon_input.txt";
    private static final String ABSOLUTE_PATH = "D:/workspace [GitHub]/Decathlon/decathlon-app/src/test/resources/Decathlon_input.txt";

    private ReaderServiceImpl service;

    @Before
    public void setUp() {
        service = new ReaderServiceImpl();
        service.setPath(FILE_PATH);
    }

    @Test
    public void shouldReadLocalFile() throws FileNotFoundException {
        // when
        List<PartyDTO> parties = service.readLocalFile(FILE_NAME);

        // then
        assertThat("File should not be empty", parties, notNullValue());
        assertThat("Incorrect records quantity retrieved", parties.size(), equalTo(4));
        /*
         * Long jump, High jump and Pole vault values are converted to
         * centimeters, i.e.: 5.00 to centimeters will be 5*100 = 500
         *
         * Long run value converted to seconds, i.e.: 5.25.72 to seconds will be
         * 5*60 + 25.72 = 325.72
         */
        assertParty(parties.get(0), "Siim Susi", 12.61, 500, 9.22, 150, 60.39, 16.43, 21.60, 260, 35.81, 325.72);
        assertParty(parties.get(1), "Beata Kana", 13.04, 453, 7.79, 155, 64.72, 18.74, 24.20, 240, 28.20, 410.76);
        assertParty(parties.get(2), "Jaana Lind", 13.75, 484, 10.12, 150, 68.44, 19.18, 30.85, 280, 33.88, 382.75);
        assertParty(parties.get(3), "Anti Loop", 13.43, 435, 8.64, 150, 66.06, 19.05, 24.89, 220, 33.48, 411.01);
    }

    @Test
    public void shouldReadExternalFile() throws FileNotFoundException {
        // when
        List<PartyDTO> parties = service.readExternalFile(ABSOLUTE_PATH);

        // then
        assertThat("File should not be empty", parties, notNullValue());
        assertThat("Incorrect records quantity retrieved", parties.size(), equalTo(4));
        /*
         * Long jump, High jump and Pole vault values are converted to
         * centimeters, i.e.: 5.00 to centimeters will be 5*100 = 500
         *
         * Long run value converted to seconds, i.e.: 5.25.72 to seconds will be
         * 5*60 + 25.72 = 325.72
         */
        assertParty(parties.get(0), "Siim Susi", 12.61, 500, 9.22, 150, 60.39, 16.43, 21.60, 260, 35.81, 325.72);
        assertParty(parties.get(1), "Beata Kana", 13.04, 453, 7.79, 155, 64.72, 18.74, 24.20, 240, 28.20, 410.76);
        assertParty(parties.get(2), "Jaana Lind", 13.75, 484, 10.12, 150, 68.44, 19.18, 30.85, 280, 33.88, 382.75);
        assertParty(parties.get(3), "Anti Loop", 13.43, 435, 8.64, 150, 66.06, 19.05, 24.89, 220, 33.48, 411.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFileNameNull() throws FileNotFoundException {
        // when
        service.readLocalFile(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAbsolutePathNull() throws FileNotFoundException {
        // when
        service.readExternalFile(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenLocalFileDoesNotExist() throws FileNotFoundException {
        // when
        service.readLocalFile("someFileNameWhichDoesNotExist");
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenExternalFileDoesNotExist() throws FileNotFoundException {
        // when
        service.readExternalFile("someFileNameWhichDoesNotExist");
    }

    /**
     * Asserts if correct party name and scores values are extracted from file.
     */
    private void assertParty(PartyDTO partyDTO, String nameDisplayValue, double shortRun, double longJump,
            double shotPut, double highJump, double middleRun, double shortRunHurdles, double discusThrow,
            double poleVault, double javelinThrow, double longRun) {
        assertThat("Incorrect name display value", partyDTO.getPartyName().getDisplayName(), equalTo(nameDisplayValue));
        assertThat("Incorrect 100 metres distance value", partyDTO.getScores().getShortRun(), equalTo(shortRun));
        assertThat("Incorrect long jump value", partyDTO.getScores().getLongJump(), equalTo(longJump));
        assertThat("Incorrect shot put value", partyDTO.getScores().getShotPut(), equalTo(shotPut));
        assertThat("Incorrect high jump value", partyDTO.getScores().getHighJump(), equalTo(highJump));
        assertThat("Incorrect 400 metres distance value", partyDTO.getScores().getMiddleRun(), equalTo(middleRun));
        assertThat("Incorrect hurdles distance value", partyDTO.getScores().getShortRunHurdles(), equalTo(shortRunHurdles));
        assertThat("Incorrect discus throw value", partyDTO.getScores().getDiscusThrow(), equalTo(discusThrow));
        assertThat("Incorrect pole vault value", partyDTO.getScores().getPoleVault(), equalTo(poleVault));
        assertThat("Incorrect javelin throw value", partyDTO.getScores().getJavelinThrow(), equalTo(javelinThrow));
        assertThat("Incorrect 1500 metres distance display value", partyDTO.getScores().getLongRun(), equalTo(longRun));
    }
}
