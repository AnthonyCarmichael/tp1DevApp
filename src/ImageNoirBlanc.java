import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en noir et blanc
 */

public class ImageNoirBlanc extends Image{

    /**
     *
     * Cette méthode retourne le pixel ayant la couleur prépondérante
     * @return
     */
    public PixelNoirBlanc couleur_preponderante(){
        HashMap<String, Integer> dict = new HashMap<String, Integer>();

        dict.put(((PixelNoirBlanc) getMatrice()[0][0]).toString(), 0);
        for (int i = 0; i < get_hauteur(); i++){
            for (int j = 0; j < get_largeur(); j++){
                if (!dict.containsKey(((PixelNoirBlanc) getMatrice()[i][j]).toString())){
                    dict.put(((PixelNoirBlanc) getMatrice()[i][j]).toString(), 1);
                }
                else{
                    dict.put(((PixelNoirBlanc) getMatrice()[i][j]).toString(), dict.get(((PixelNoirBlanc) getMatrice()[i][j]).toString()) + 1);
                }
            }
        }

        String  dictKey = Collections.max(dict.entrySet(), Map.Entry.comparingByValue()).getKey();

        String[] rgb = dictKey.split(" ");

        PixelNoirBlanc preponderant = new PixelNoirBlanc(parseInt(rgb[0]));

        System.out.print("Pixel préponderant: " + preponderant);

        return preponderant;
    }

    /**
     *
     * Cette fonction permet d'éclaircir ou noircir une image noirblanc
     * en fonction de la variable passée en paramétre. Si la valeur est
     * positive, l’image devient plus noire, si la valeur est négative,
     * l’image devient plus claire
     * @param valeur
     */
    public void eclaircir_noicir(int valeur){
        for (short i = 0; i < getMatrice().length; i++){
            for (short j = 0; j < getMatrice()[i].length; j++){
                ((PixelNoirBlanc)getMatrice()[i][j]).eclaircir_noircir(valeur, get_maxValue());
            }
        }
    }

    /**
     *
     * Cette méthode réduit la matrice de pixel de l'image noirblanc
     */
    public void reduire(){
        set_hauteur((short) (get_hauteur()/2));
        set_largeur((short) (get_largeur()/2));

        PixelNoirBlanc[][] matriceReduite = new PixelNoirBlanc[get_hauteur()][get_largeur()];

        for (int i = 0; i < get_hauteur(); i++) {
            for (int j = 0; j < get_largeur(); j++) {
                matriceReduite[i][j] = ((PixelNoirBlanc) getMatrice()[2*i][2*j]).reduire(((PixelNoirBlanc) getMatrice()[2*i][2*j+1]), ((PixelNoirBlanc) getMatrice()[2*i+1][2*j]), ((PixelNoirBlanc) getMatrice()[2*i+1][2*j+1]));
            }
        }

        set_matrice(matriceReduite);
    }

    /**
     *
     * Cette méthode permet d'effectuer la lecture d'une image noirblanc
     * @param scannerLecture
     * @param path
     */
    public void lire(Scanner scannerLecture, String path){
        this.set_chemin(path);
        this.set_type(scannerLecture.next());
        this.set_largeur(scannerLecture.nextShort());
        this.set_hauteur(scannerLecture.nextShort());
        this.set_maxValue(scannerLecture.nextInt());

        if (this.get_type().equalsIgnoreCase("p2") || this.get_type().equalsIgnoreCase("p5"))
        {
            PixelNoirBlanc[][] tabPixel = new PixelNoirBlanc[this.get_hauteur()][this.get_largeur()];
            int x = 0;
            int y = 0;
            while (scannerLecture.hasNextInt()) {

                PixelNoirBlanc pixTemp = new PixelNoirBlanc(scannerLecture.nextInt());
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
     * Cette méthode permet de savoir si deux image noirblanc sont identique
     * @param image
     * @return
     */
    public boolean matrice_identique(Image image) {
        for (int i = 0; i < get_hauteur(); i++){
            for (int j = 0 ; j < get_largeur(); j++) {
                if (!((PixelNoirBlanc)this.getMatrice()[i][j]).sont_identiques(((PixelNoirBlanc)(image.getMatrice())[i][j]))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     *
     * Cette méthode permet d'écrire une image noirblanc
     * @param writer
     * @throws IOException
     */
    public void ecrire(BufferedWriter writer) throws IOException {
        short cpt =0;
        for (int i = 0; i < get_hauteur(); i++) {
            for (int j = 0; j < get_largeur(); j++) {
                writer.write(((PixelNoirBlanc) getMatrice()[i][j]).get_nuance() + " ");
                cpt++;
                if (cpt == 21) {
                    writer.write("\n");
                    cpt = 0;
                }
            }
        }
    }
}
