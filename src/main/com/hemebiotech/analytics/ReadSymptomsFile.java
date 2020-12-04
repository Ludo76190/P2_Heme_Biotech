package main.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomsFile implements ISymptomReader {
    /**
     * lecture du fichier symptoms.txt et crée une liste de symptomes
     *
     * @param fileName
     *
     * @return la liste de symptomes
     *
     * @author Ludovic Allegaert
     */

    public List<String> getSymptomsFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        // initialise le bufferedreader pour pouvoir le clore dans le finally
        BufferedReader br=null;

        if (fileName != null) {
            try {
                br = new BufferedReader(new FileReader(fileName));
                String line;
                // Ajoute chaque ligne dans la liste
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    //Test si le fichier a bien été ouvert
                    if (br != null) {
                        br.close();
                    }
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return result;
    }
}