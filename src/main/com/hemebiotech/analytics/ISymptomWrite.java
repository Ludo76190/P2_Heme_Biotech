package main.com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWrite {
    /**
     * Ecrit la map de symptomes dans le fichier result.out
     *
     * @param symptomsMap
     *
     * @throws IOException
     *
     * @return un fichier avec le nombre de chaque symptomes
     *
     * @author Ludovic ALLEGAERT
     */

    void writeResult(Map<String, Integer> symptomsMap) throws IOException;
}