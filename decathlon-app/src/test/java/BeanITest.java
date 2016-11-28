import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.app.Bean;
import com.decathlon.app.domain.CompetitionResultsDTO;
import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.services.ReaderService;
import com.decathlon.app.services.ScoresCounterService;
import com.decathlon.app.services.impl.CompetitionEvaluationServiceImpl;
import com.decathlon.app.services.impl.ReaderServiceImpl;
import com.decathlon.app.services.impl.ScoresCounterServiceImpl;
import com.decathlon.app.utils.CompetitionResultsSorter;
/**
 * ITests for {@link Bean}.
 *
 * @author redaz
 */
public class BeanITest {

    private Bean bean;
    private CompetitionResultsSorter competitionResultsSorter;
    private CompetitionEvaluationServiceImpl competitionEvaluationService;
    private ReaderService readerService;
    private ScoresCounterService scoresCounterService;

    @Before
    public void setUp() {
        bean = new Bean();
        competitionResultsSorter = new CompetitionResultsSorter();
        competitionEvaluationService = new CompetitionEvaluationServiceImpl();
        readerService = new ReaderServiceImpl();
        scoresCounterService = new ScoresCounterServiceImpl();

        competitionEvaluationService.setScoresCounterService(scoresCounterService);

        bean.setCompetitionResultsSorter(competitionResultsSorter);
        bean.setCompetitionEvaluationService(competitionEvaluationService);
        bean.setReaderService(readerService);
    }

    @Test
    public void shouldAssignPlace() throws FileNotFoundException {
        // given
        List<PartyDTO> parties = readerService.readExternalFile(
                "d:/workspace [GitHub]/Decathlon/decathlon-app/src/main/resources/Decathlon_input.txt");
        for (PartyDTO party : parties) {
            CompetitionResultsDTO results = new CompetitionResultsDTO(
                    competitionEvaluationService.evaluateCompetition(party), party);
            bean.getCompetitionResults().add(results);
        }
        Collections.sort(bean.getCompetitionResults(), competitionResultsSorter);

        // when
        bean.assignPlace();

        // then
        assertThat("Competition results list should not be empty", bean.getCompetitionResults(), notNullValue());
        assertThat("9 contestant should be retrieved", bean.getCompetitionResults().size(), equalTo(9));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(0).getCompetitionResults(), equalTo(4200));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(0).getPlace(),
                equalTo("1-2"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(0).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Siim Susi"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(1).getCompetitionResults(), equalTo(4200));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(1).getPlace(),
                equalTo("1-2"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(1).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Siim Susi2"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(2).getCompetitionResults(), equalTo(3494));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(2).getPlace(),
                equalTo("3-4"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(2).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Jaana Lind"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(3).getCompetitionResults(), equalTo(3494));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(3).getPlace(),
                equalTo("3-4"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(3).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Jaana Lind2"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(4).getCompetitionResults(), equalTo(3199));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(4).getPlace(),
                equalTo("5-6"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(4).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Beata Kana"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(5).getCompetitionResults(), equalTo(3199));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(5).getPlace(),
                equalTo("5-6"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(5).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Beata Kana2"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(6).getCompetitionResults(), equalTo(3099));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(6).getPlace(),
                equalTo("7-9"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(6).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Anti Loop"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(7).getCompetitionResults(), equalTo(3099));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(7).getPlace(),
                equalTo("7-9"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(7).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Anti Loop2"));

        assertThat("Incorrect competition results retrieved",
                bean.getCompetitionResults().get(8).getCompetitionResults(), equalTo(3099));
        assertThat("Incorrect competition place retrieved", bean.getCompetitionResults().get(8).getPlace(),
                equalTo("7-9"));
        assertThat("Incorrect contestant name retrieved",
                bean.getCompetitionResults().get(8).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("Anti Loop3"));
    }
}
