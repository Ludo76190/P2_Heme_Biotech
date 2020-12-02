package main.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * 	count symptoms from the list and store them to a map
 */

public interface ISymptomCount {
    /**
     * Compte les symptomes depuis la liste et les ajoute à une map
     *
     * @param symptoms
     *
     * @return une map du nombre de chaque symptome
     *
     * @author Ludovic ALLEGAERT
     */
    Map<String, Integer> getSymptomsFromList(List<String> symptoms);
}