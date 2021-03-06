package main.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe principale permettant l'exécution de l'outil
 *
 * @author Ludovic ALLEGAERT
 */

public class Analytics {

    public static void main(String[] args) throws Exception{

        final String SourceFile = "symptoms.txt";

        //Read source file (symptoms.txt) and put in a list
        ISymptomReader readSymptomsFile = new ReadSymptomsFile();
        List<String> symptoms = readSymptomsFile.getSymptomsFromFile(SourceFile);

        //counting symptom ans put in a map
        ISymptomCount countSymptoms = new CountSymptoms();
        Map<String, Integer> symptomsMap = countSymptoms.getSymptomsFromList(symptoms);

        //write result in a file (result.out)
        ISymptomWrite writeOutputFile = new WriteOutputFile();
        writeOutputFile.writeResult(symptomsMap);
    }
}