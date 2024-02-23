import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class traducteur {
    public Image lire(String path) {
        try {
            File fichier = new File(path);
            //Scanner scannerLecture = new Scanner(fichier);

            String[] cheminExtension = path.split(".");
            System.out.println(cheminExtension[1]);
            set_chemin(path);
            set_type(scannerLecture.next(" "));
            set_largeur(scannerLecture.nextShort());
            set_hauteur(scannerLecture.nextShort());

            PixelNoirBlanc[][] tabPixel = new PixelNoirBlanc[_hauteur][_largeur];
            int x = 0;
            int y = 0;
            while (scannerLecture.hasNextInt()) {

                PixelNoirBlanc pixTemp = new PixelNoirBlanc(scannerLecture.nextInt());
                tabPixel[x][y] = pixTemp;
                x++;
                if (y == _largeur)
                {
                    x=0;
                    y++;
                }

            }
            //System.out.println(Arrays.toString(tabPixel));
            scannerLecture.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace(); A revoir
        }
    }
}
