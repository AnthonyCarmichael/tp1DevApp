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
                image.set_chemin(path);
                image.set_type(scannerLecture.next());
                image.set_largeur(scannerLecture.nextShort());
                image.set_hauteur(scannerLecture.nextShort());
                image.set_maxValue(scannerLecture.nextInt());

                System.out.println(image);
                if (image.get_type().equalsIgnoreCase("p2") || image.get_type().equalsIgnoreCase("p5"))
                {
                    PixelNoirBlanc[][] tabPixel = new PixelNoirBlanc[image.get_hauteur()][image.get_largeur()];
                    int x = 0;
                    int y = 0;
                    while (scannerLecture.hasNextInt()) {

                        PixelNoirBlanc pixTemp = new PixelNoirBlanc(scannerLecture.nextInt());
                        System.out.println(x+","+y);
                        tabPixel[y][x] = pixTemp;
                        x++;
                        if (x == image.get_largeur())
                        {
                            x=0;
                            y++;
                        }
                    }
                    image.set_matrice(tabPixel);

                    //System.out.println(Arrays.toString(tabPixel));
                    scannerLecture.close();
                    return image;
                }
                else {
                    System.out.println("ERREUR: Le fichier "+path+" ne correspond pas au bon type : "+image.get_type());
                    return null;
                }
            } else if (cheminExtension[1].equals("ppm")) { // Si l'image est en couleur
                ImageCouleur image = new ImageCouleur();
                image.set_chemin(path);
                image.set_type(scannerLecture.next());
                image.set_largeur(scannerLecture.nextShort());
                image.set_hauteur(scannerLecture.nextShort());
                image.set_maxValue(scannerLecture.nextInt());

                if (image.get_type().equalsIgnoreCase("p3") || image.get_type().equalsIgnoreCase("p6"))
                {
                    PixelCouleur[][] tabPixel = new PixelCouleur[image.get_hauteur()][image.get_largeur()];
                    int x = 0;
                    int y = 0;
                    while (scannerLecture.hasNextInt()) {

                        int r = scannerLecture.nextInt();
                        int g = scannerLecture.nextInt();
                        int b = scannerLecture.nextInt();

                        PixelCouleur pixTemp = new PixelCouleur(r,g,b);
                        System.out.println(x+","+y);
                        tabPixel[y][x] = pixTemp;
                        x++;
                        if (x == image.get_largeur())
                        {
                            x=0;
                            y++;
                        }
                    }
                    image.set_matrice(tabPixel);

                    //System.out.println(Arrays.toString(tabPixel));
                    scannerLecture.close();
                    return image;
                }
                else {
                    System.out.println("ERREUR: Le fichier "+path+" ne correspond pas au bon type : "+image.get_type());
                    return null;
                }

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
