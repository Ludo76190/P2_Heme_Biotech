package main.com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

public interface ISymptomReader {
    /**
     * Ajoute les symptoms dans une liste depuis un fichier
     *
     * @param fileName
     *
     * @return une liste de symptomes
     *
     * @throws IOException
     *
     * @author Ludovic ALLEGAERT
     */

    List<String> getSymptomsFromFile(String fileName) throws IOException;
}