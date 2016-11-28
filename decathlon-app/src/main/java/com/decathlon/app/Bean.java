package com.decathlon.app;

import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.decathlon.app.domain.CompetitionResultsDTO;
import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.services.CompetitionEvaluationService;
import com.decathlon.app.services.ReaderService;
import com.decathlon.app.utils.CompetitionResultsSorter;
import com.google.common.collect.Lists;

/**
 * Managed bean class.
 *
 * @author redaz
 */
public class Bean {

    private static final Logger LOG = LoggerFactory.getLogger(Bean.class);

    private ReaderService readerService;
    private CompetitionEvaluationService competitionEvaluationService;
    private CompetitionResultsSorter competitionResultsSorter;

    /**
     * List, holding information about each contestant of Decathlon competition
     * and his/her final results.
     * <p>
     * <b>Note:</b> attribute is used to display data in UI.
     */
    private List<CompetitionResultsDTO> competitionResults = Lists.newArrayList();

    /**
     * Initialization method, which is invoked after all necessary properties on
     * the bean have been set.
     * <p>
     * Method calls file reader, constructs {@link PartyDTO} from read input,
     * calls competition results counter and retrieves results.
     */
    public void init() {
        LOG.trace("[init] waiting for user input");

        String path = readerService.readUserInput();
        List<PartyDTO> parties = Lists.newArrayList();

        try {
            parties = readerService.readExternalFile(path);

        } catch (FileNotFoundException e) {
            LOG.error(MessageFormat.format("File {0} not found", path));
            init();
        }

        for (PartyDTO party : parties) {
            CompetitionResultsDTO results = new CompetitionResultsDTO(
                    competitionEvaluationService.evaluateCompetition(party), party);
            competitionResults.add(results);
        }

        Collections.sort(competitionResults, new CompetitionResultsSorter());
        assignPlace();
    }

    /**
     * Assigns place to the contestant.
     */
    public void assignPlace() {
        List<CompetitionResultsDTO> temp = Lists.newArrayList();
        List<CompetitionResultsDTO> results = Lists.newArrayList();
        int place = 1;
        int count = 0;

        while (competitionResults.iterator().hasNext()) {
            CompetitionResultsDTO dto1 = competitionResults.get(0);
            competitionResults.remove(dto1);
            temp.add(dto1);
            count++;

            while(competitionResults.iterator().hasNext()) {
                CompetitionResultsDTO dto2 = competitionResults.get(0);
                if (dto1.getCompetitionResults() == dto2.getCompetitionResults()) {
                    competitionResults.remove(dto2);
                    temp.add(dto2);
                    count++;
                    if (CollectionUtils.isNotEmpty(competitionResults)) {
                        continue;
                    }
                    assignPlace(temp, results, place, count);

                } else {
                    assignPlace(temp, results, place, count);
                    break;
                }
            }
            place = count + 1;
        }
        competitionResults.addAll(results);
    }

    /**
     * Assigns place to the contestant.
     *
     * @param temp list of {@link CompetitionResultsDTO}, who earned the same points
     * @param results final list of {@link CompetitionResultsDTO} with all data prefilled
     * @param place contestant taken place via Decathlon competition
     * @param count number of same points frequency in the Decathlon competition
     */
    protected void assignPlace(List<CompetitionResultsDTO> temp, List<CompetitionResultsDTO> results, int place,
            int count) {
        for (CompetitionResultsDTO dto : temp) {
            dto.setPlace(MessageFormat.format("{0}-{1}", place, count));
        }
        results.addAll(temp);
        temp.clear();
    }

    public CompetitionEvaluationService getCompetitionEvaluationService() {
        return competitionEvaluationService;
    }

    public void setCompetitionEvaluationService(CompetitionEvaluationService competitionEvaluationService) {
        this.competitionEvaluationService = competitionEvaluationService;
    }

    public List<CompetitionResultsDTO> getCompetitionResults() {
        return competitionResults;
    }

    public void setCompetitionResults(List<CompetitionResultsDTO> competitionResults) {
        this.competitionResults = competitionResults;
    }

    public CompetitionResultsSorter getCompetitionResultsSorter() {
        return competitionResultsSorter;
    }

    public void setCompetitionResultsSorter(CompetitionResultsSorter competitionResultsSorter) {
        this.competitionResultsSorter = competitionResultsSorter;
    }

    public ReaderService getReaderService() {
        return readerService;
    }

    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }
}
