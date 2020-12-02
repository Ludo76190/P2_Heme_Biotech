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
        ReadSymptomsFile readSymptomsFile = new ReadSymptomsFile();
        List<String> symptoms = readSymptomsFile.getSymptomsFromFile(SourceFile);
    }
}