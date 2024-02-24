import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en noir et blanc
 */

public class ImageNoirBlanc extends Image{

    /*Cette méthode retourne la couleur prépondérante*/
    public PixelNoirBlanc couleur_preponderante(){
        PixelNoirBlanc[] tabPixel = new PixelNoirBlanc[get_hauteur() * get_largeur()];

        /*Remplissage du tableau de pixel avec les donn/es de la matrice de pixel*/
        int k = 0;

        for (int i = 0; i < getMatrice().length; i++){
            for (int j = 0; j < getMatrice()[i].length; j++){
                tabPixel[k] = (PixelNoirBlanc) getMatrice()[i][j];
                k++;
            }
        }

        int taille = tabPixel.length;
        int max_count = 0;
        PixelNoirBlanc preponderant = new PixelNoirBlanc();

        for (int i = 0; i < taille; i++){
            int count = 0;
            for (int j = 0; j < taille; j++){
                if (tabPixel[i].sont_identiques(tabPixel[j])){
                    count++;
                }
            }

            if (count > max_count){
                max_count = count;
                preponderant = tabPixel[i];
            }
        }

        System.out.print("Pixel préponderant: " + preponderant.get_nuance() + " " + max_count);

        return preponderant;
    }

    /**
     *
     * @param valeur la valeur passer en paramétre doit être possitve ou
     * négative. Si la valeur est positive, l’image devient plus noire,
     * si la valeur est négative, l’image devient plus claire
     *
     */
    public void eclaircir_noicir(int valeur){
        for (short i = 0; i < getMatrice().length; i++){
            for (short j = 0; j < getMatrice()[i].length; j++){
                ((PixelNoirBlanc)getMatrice()[i][j]).eclaircir_noircir(valeur, get_maxValue());
            }
        }
    }

    /*Cette méthode réduit le pixel*/
    public void reduire(){
        int hauteur = get_hauteur();
        int largeur = get_largeur();

        int newHauteur = hauteur / 4;
        int newLargeur = largeur / 4;

        PixelNoirBlanc[][] matriceReduite = new PixelNoirBlanc[newHauteur][newLargeur];

        for (int i = 0; i < newHauteur; i++) {
            for (int j = 0; j < newLargeur; j++) {
                if (getMatrice()[4*i][4*j] instanceof PixelNoirBlanc){
                    matriceReduite[i][j] = ((PixelNoirBlanc) getMatrice()[4*i][4*j]).reduire(((PixelNoirBlanc) getMatrice()[4*i+1][4*j]), ((PixelNoirBlanc) getMatrice()[4*i+2][4*j]), ((PixelNoirBlanc) getMatrice()[4*i+3][4*j]));
                }
            }
        }
    }

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
