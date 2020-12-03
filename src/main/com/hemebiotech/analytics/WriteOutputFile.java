package main.com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteOutputFile implements ISymptomWrite {
    /**
     * sauvegarde dans result.out la map des symptomes/occurences
     *
     * @param symptomsMap
     *
     * @return le fichier result.out avec le nombre se symptomes
     *
     * @author Ludovic.ALLEGAERT
     */

    final String outputFileName = "result.out";

    public void writeResult(Map<String, Integer> symptomsMap) throws IOException {

        //Définition du fichier de sortie
        String fileOutput = System.getProperty("user.home") + System.getProperty("file.separator") + outputFileName;

        // Écriture du fichier
        FileWriter output = new FileWriter(fileOutput);
        if (symptomsMap != null && !symptomsMap.isEmpty()) {
            symptomsMap.forEach((k, v) -> {
                try {
                    //Écrit le résultat et ajoute un saut de ligne
                    output.write(k + "=" + v + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            output.close();
        }
        else {
            try{
                output.write("aucun symptôme n'a été trouvé!");
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            finally {
                output.close();
            }
        }
        System.out.println("le resultat se trouve dans le fichier: " + fileOutput);
    }
}