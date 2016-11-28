package com.decathlon.app.domain;

import java.text.MessageFormat;

/**
 * DTO to carry contestants information.
 *
 * @author redaz
 */
public class CompetitionResultsDTO {
    /**
     * Final points, got on Decathlon competition.
     */
    private int competitionResults;
    /**
     * Contestant information
     */
    private PartyDTO partyDTO;
    /**
     * Place won during Decathlon competition.
     */
    private String place;

    public CompetitionResultsDTO() { }

    public CompetitionResultsDTO(int competitionResults, PartyDTO partyDTO) {
        super();
        this.competitionResults = competitionResults;
        this.partyDTO = partyDTO;
    }

    @Override
    public String toString() {
        return MessageFormat.format("party: {0}, points: {1}, place: {2}", partyDTO.getPartyName().toString(),
                String.valueOf(competitionResults), place);
    }

    public int getCompetitionResults() {
        return competitionResults;
    }

    public void setCompetitionResults(int competitionResults) {
        this.competitionResults = competitionResults;
    }

    public PartyDTO getPartyDTO() {
        return partyDTO;
    }

    public void setPartyDTO(PartyDTO partyDTO) {
        this.partyDTO = partyDTO;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
