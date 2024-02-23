import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Traducteur {
    public Image lire(String path) {
        try {
            File fichier = new File(path);
            Scanner scannerLecture = new Scanner(fichier);

            String[] cheminExtension = path.split("\\.");
            System.out.println(cheminExtension[1]);

            if(cheminExtension[1].equals("pgm")) // Si l'image est noir et blanc
            {
                ImageNoirBlanc image = new ImageNoirBlanc();
                image.lire(scannerLecture,path);
                return image;

            } else if (cheminExtension[1].equals("ppm")) { // Si l'image est en couleur
                ImageCouleur image = new ImageCouleur();
                image.lire(scannerLecture,path);
                return image;
            }
            else {
                System.out.println(path+" ERREUR: Ce fichier n'est pas conforme");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace(); A revoir
            return null;
        }
    }
}
