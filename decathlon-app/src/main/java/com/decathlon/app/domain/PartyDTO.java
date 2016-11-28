package com.decathlon.app.domain;
/**
 * DTO to carry party information. Party information is combined from:
 * <li>information about party name (instance of {@link PartyNameDTO});</li>
 * <li>information about competition results (instance of {@link ScoresDTO}).</li>
 *
 * @author redaz
 */
public class PartyDTO {
    /**
     * Party name information.
     */
    private PartyNameDTO partyName;
    /**
     * Competition intermediate results, i.e.: points earned on each event.
     */
    private ScoresDTO scores;

    public PartyDTO() { }

    public PartyDTO(PartyNameDTO partyName, ScoresDTO scores) {
        super();
        this.partyName = partyName;
        this.scores = scores;
    }

    public PartyNameDTO getPartyName() {
        return partyName;
    }

    public void setPartyName(PartyNameDTO partyName) {
        this.partyName = partyName;
    }

    public ScoresDTO getScores() {
        return scores;
    }

    public void setScores(ScoresDTO scores) {
        this.scores = scores;
    }
}
