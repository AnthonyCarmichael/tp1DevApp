import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en couleur
 */

public class ImageCouleur extends Image{

    /**
     *
     * Cette méthode retourne le pixel ayant la couleur prépondérante
     * @return
     */
    public PixelCouleur couleur_preponderante(){
        HashMap<String, Integer> dict = new HashMap<String, Integer>();

        dict.put(((PixelCouleur) getMatrice()[0][0]).toString(), 0);
        for (int i = 0; i < get_hauteur(); i++){
            for (int j = 0; j < get_largeur(); j++){
                if (!dict.containsKey(((PixelCouleur) getMatrice()[i][j]).toString())){
                    dict.put(((PixelCouleur) getMatrice()[i][j]).toString(), 1);
                }
                else{
                    dict.put(((PixelCouleur) getMatrice()[i][j]).toString(), dict.get(((PixelCouleur) getMatrice()[i][j]).toString()) + 1);
                }
            }
        }

        String  dictKey = Collections.max(dict.entrySet(), Map.Entry.comparingByValue()).getKey();

        String[] rgb = dictKey.split(" ");

        PixelCouleur preponderant = new PixelCouleur(parseInt(rgb[0]), parseInt(rgb[1]), parseInt(rgb[2]));

        System.out.print("Pixel préponderant: " + preponderant);

        return preponderant;
    }

    /**
     *
     * Cette fonction permet d'éclaircir ou noircir une image en couleur
     * en fonction de la variable passée en paramétre. Si la valeur est
     * positive, l’image devient plus noire, si la valeur est négative,
     * l’image devient plus claire
     * @param valeur
     */
    public void eclaircir_noicir(int valeur){
        for (short i = 0; i < getMatrice().length; i++){
            for (short j = 0; j < getMatrice()[i].length; j++){
                ((PixelCouleur)getMatrice()[i][j]).eclaircir_noircir(valeur, get_maxValue());
            }
        }
    }

    /**
     *
     * Cette méthode réduit la matrice de pixel de l'image de couleur
     */
    public void reduire(){

        set_hauteur((short) (get_hauteur()/2));
        set_largeur((short) (get_largeur()/2));

        PixelCouleur[][] matriceReduite = new PixelCouleur[get_hauteur()][get_largeur()];

        for (int i = 0; i < get_hauteur(); i++) {
            for (int j = 0; j < get_largeur(); j++) {
                matriceReduite[i][j] = ((PixelCouleur) getMatrice()[2*i][2*j]).reduire(((PixelCouleur) getMatrice()[2*i][2*j+1]), ((PixelCouleur) getMatrice()[2*i+1][2*j]), ((PixelCouleur) getMatrice()[2*i+1][2*j+1]));
            }
        }

        set_matrice(matriceReduite);
    }

    /**
     *
     * Cette méthode permet d'effectuer la lecture d'une image de couleur
     * @param scannerLecture
     * @param path
     */
    public void lire(Scanner scannerLecture, String path){
        this.set_chemin(path);
        this.set_type(scannerLecture.next());
        this.set_largeur(scannerLecture.nextShort());
        this.set_hauteur(scannerLecture.nextShort());
        this.set_maxValue(scannerLecture.nextInt());

        if (this.get_type().equalsIgnoreCase("p3") || this.get_type().equalsIgnoreCase("p6"))
        {
            PixelCouleur[][] tabPixel = new PixelCouleur[this.get_hauteur()][this.get_largeur()];
            int x = 0;
            int y = 0;
            while (scannerLecture.hasNextInt()) {

                int r = scannerLecture.nextInt();
                int g = scannerLecture.nextInt();
                int b = scannerLecture.nextInt();

                PixelCouleur pixTemp = new PixelCouleur(r,g,b);
                tabPixel[y][x] = pixTemp;
                x++;
                if (x == this.get_largeur())
                {
                    x=0;
                    y++;
                }
            }
            this.set_matrice(tabPixel);

            //System.out.println(Arrays.toString(tabPixel));
            scannerLecture.close();
        }
        else {
            System.out.println("ERREUR: Le fichier "+path+" ne correspond pas au bon type : "+this.get_type());
        }
    }

    /**
     *
     * Cette méthode permet de savoir si deux image de couleur sont identique
     * @param image
     * @return
     */
    public boolean matrice_identique(Image image) {
        for (int i = 0; i < get_hauteur(); i++){
            for (int j = 0 ; j < get_largeur(); j++) {
                if (!((PixelCouleur)this.getMatrice()[i][j]).sont_identiques(((PixelCouleur)(image.getMatrice())[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * Cette méthode permet d'écrire une image de couleur
     * @param writer
     * @throws IOException
     */
    public void ecrire(BufferedWriter writer) throws IOException {
        short cpt = 0;
        for (int i = 0; i < get_hauteur(); i++) {
            for (int j = 0; j < get_largeur(); j++) {
                writer.write(((PixelCouleur) getMatrice()[i][j]).get_red() + " "+((PixelCouleur) getMatrice()[i][j]).get_green() + " " +((PixelCouleur) getMatrice()[i][j]).get_blue()+ " ");
                cpt++;
                if (cpt == 7) {
                    writer.write("\n");
                    cpt = 0;
                }
            }
        }
    }
}