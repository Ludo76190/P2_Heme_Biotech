package main.com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptoms implements ISymptomCount {
    /**
     * Compte le nombre d'occurences des symptomes de la liste et crée une map de symptomes
     *
     * @param symptoms
     *
     * @return une map de symptomes/occurences
     *
     * @author Ludovic Allegaert
     */

    @Override
    public Map<String, Integer> getSymptomsFromList(List<String> symptoms) {

        //Utilisation de treemap pour trier la map par ordre alphabétique
        Map<String, Integer> map = new TreeMap<>();

        if (symptoms != null && !symptoms.isEmpty()) {
            Collections.sort(symptoms);
            // Ajoute chaque nouveau symptôme à la map et l'incrémente de +1 si il existe déjà
            for (String symptom : symptoms) {
                if (map.containsKey(symptom)) {
                    map.put(symptom,map.get(symptom) + 1 );
                }
                else {
                    map.put(symptom,1);
                }
            }
        }
        return map;
    }
}