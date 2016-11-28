package com.decathlon.app.utils;

import java.util.Comparator;

import com.decathlon.app.domain.CompetitionResultsDTO;

/**
 * Sorts list of contestant of Decathlon competition (i.e.:
 * {@link CompetitionResultsDTO}) by final points, got during the competition
 * (i.e.: {@link CompetitionResultsDTO#getCompetitionResults()} ). (i.e.
 * {@link CompetitionResultsDTO#getCompetitionResults()}).
 * 
 * @author redaz
 */
public class CompetitionResultsSorter implements Comparator<CompetitionResultsDTO> {
    /**
     * Compares two instances of {@link CompetitionResultsDTO} by it's
     * {@link CompetitionResultsDTO#getCompetitionResults()} attribute.
     * 
     * @param dto1 instance of {@link CompetitionResultsDTO} to be compared
     * @param dto2 instance of {@link CompetitionResultsDTO} to be compared
     * @return <ul>
     *         <li><b>{@code -1}</b> if pointDTO1 coordinate x is lower than
     *         pointDTO2 or x coordinates matches, but pointDTO1 coordinate y is
     *         lower than pointDTO2</li>
     *         <li><b>{@code 0}</b> if both pointDTOs coordinate x (or x and y)
     *         values matches</li>
     *         <li><b>{@code 1}</b> if pointDTO1 coordinate x is greater than
     *         pointDTO2 or x coordinates matches, but pointDTO1 coordinate y is
     *         greater than pointDTO2</li>
     *         </ul>
     */
    public int compare(CompetitionResultsDTO dto1, CompetitionResultsDTO dto2) {
        return compareAndReverse(dto1.getCompetitionResults(), dto2.getCompetitionResults());
    }

    /**
     * Compares two integer numbers.
     *
     * @param number1 first number to be compared
     * @param number2 second number to be compared
     * @return <ul>
     * <li><b>{@code -1}</b> if number1 is greater than number2,</li>
     * <li><b>{@code 0}</b> if both numbers are equals,</li>
     * <li><b>{@code 1}</b> if number1 is lower than number2</li>
     * </ul>
     */
    public int compareAndReverse(int number1, int number2) {
        if (number1 < number2) {
            return 1;
        }

        if (number1 > number2) {
            return -1;
        }

        if (number1 == number2) {
            return 0;
        }

        return 0;
    }

}
