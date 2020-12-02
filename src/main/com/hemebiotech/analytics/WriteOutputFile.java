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

    final String OutputFile = "result.out";

    public void writeResult(Map<String, Integer> symptomsMap) throws IOException {

        //Définition du path du fichier de sortie
        String path = System.getProperty("user.home") + System.getProperty("file.separator") + OutputFile;

        // Ecriture du fichier
        FileWriter output = new FileWriter(path);
        if (symptomsMap != null && !symptomsMap.isEmpty()) {
            symptomsMap.forEach((k, v) -> {
                try {
                    output.write(k + "=" + v);
                    output.write(System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            output.close();
        }
        else {
            try{
                output.write("aucun symptome n'a été trouvé!");
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            finally {
                output.close();
            }
        }
        System.out.println("le résultat se trouve dans le fichier: " + path);
    }
}