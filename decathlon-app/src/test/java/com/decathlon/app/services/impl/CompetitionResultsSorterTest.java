package com.decathlon.app.services.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.app.domain.CompetitionResultsDTO;
import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.domain.PartyNameDTO;
import com.decathlon.app.domain.ScoresDTO;
import com.decathlon.app.utils.CompetitionResultsSorter;
import com.google.common.collect.Lists;

/**
 * Unit tests for {@link CompetitionResultsSorter}.
 *
 * @author redaz
 */
public class CompetitionResultsSorterTest {

    private CompetitionResultsSorter service;

    @Before
    public void setUp() {
        service = new CompetitionResultsSorter();
    }

    @Test
    public void shouldInit() throws FileNotFoundException {
        // given
        CompetitionResultsDTO dto1 = createCompetitionResultDTO(10, "1st party");
        CompetitionResultsDTO dto2 = createCompetitionResultDTO(12, "2nd party");
        CompetitionResultsDTO dto3 = createCompetitionResultDTO(9, "3rd party");
        CompetitionResultsDTO dto4 = createCompetitionResultDTO(12, "4th party");
        CompetitionResultsDTO dto5 = createCompetitionResultDTO(9, "5th party");
        CompetitionResultsDTO dto6 = createCompetitionResultDTO(9, "6th party");
        List<CompetitionResultsDTO> parties = Lists.newArrayList(dto1, dto2, dto3, dto4, dto5, dto6);

        // when
        Collections.sort(parties, service);

        // then
        assertThat("Contestant of Decathlon competition list should not be empty", parties, notNullValue());
        assertThat("6 contestants should be retrieved", parties.size(), equalTo(6));

        assertThat("Incorrect contestant results retrieved", parties.get(0).getCompetitionResults(), equalTo(12));
        assertThat("Incorrect contestant name retrieved", parties.get(0).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("2nd party"));

        assertThat("Incorrect contestant results retrieved", parties.get(1).getCompetitionResults(), equalTo(12));
        assertThat("Incorrect contestant name retrieved", parties.get(1).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("4th party"));

        assertThat("Incorrect contestant results retrieved", parties.get(2).getCompetitionResults(), equalTo(10));
        assertThat("Incorrect contestant name retrieved", parties.get(2).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("1st party"));

        assertThat("Incorrect contestant results retrieved", parties.get(3).getCompetitionResults(), equalTo(9));
        assertThat("Incorrect contestant name retrieved", parties.get(3).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("3rd party"));

        assertThat("Incorrect contestant results retrieved", parties.get(4).getCompetitionResults(), equalTo(9));
        assertThat("Incorrect contestant name retrieved", parties.get(4).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("5th party"));

        assertThat("Incorrect contestant results retrieved", parties.get(5).getCompetitionResults(), equalTo(9));
        assertThat("Incorrect contestant name retrieved", parties.get(5).getPartyDTO().getPartyName().getDisplayName(),
                equalTo("6th party"));
    }

    /**
     * Creates instance of {@link CompetitionResultsDTO} with prefilled party
     * name information.
     */
    protected CompetitionResultsDTO createCompetitionResultDTO(int points, String partyName) {
        return new CompetitionResultsDTO(points, new PartyDTO(new PartyNameDTO(partyName), new ScoresDTO()));
    }
}
