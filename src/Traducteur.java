import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Cette classe sert à l'implémentation des images, il renvoi un objet d'une sous-classe créé a partir d'une lecture
 * de fichier
 *
 * @author Anthony Carmichael
 */
public class Traducteur {
    public Image lire(String path) {
        try {
            File fichier = new File(path);
            Scanner scannerLecture = new Scanner(fichier);

            String[] cheminExtension = path.split("\\.");

            if(cheminExtension[1].equals("pgm")) // Si l'image est noir et blanc
            {
                ImageNoirBlanc image = new ImageNoirBlanc();
                image.lire(scannerLecture,path);
                scannerLecture.close();
                return image;

            } else if (cheminExtension[1].equals("ppm")) { // Si l'image est en couleur
                ImageCouleur image = new ImageCouleur();
                image.lire(scannerLecture,path);
                scannerLecture.close();
                return image;
            }
            else {
                System.out.println(path+" ERREUR: Ce fichier n'est pas conforme");
                scannerLecture.close();
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERREUR Fichier: "+path+" est inexistant!");
            //e.printStackTrace(); A revoir
            return null;
        }
    }
}
