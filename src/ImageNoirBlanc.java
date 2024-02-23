/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en noir et blanc
 */

public class ImageNoirBlanc extends Image{

    /*Cette méthode retourne la couleur prépondérante*/
    public Pixel couleur_preponderante(){
        Pixel preponderant = new Pixel();

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
        short n = 0, m = 0;
        int moyBlue = 0, moyRed = 0, moyGreen = 0;

        PixelCouleur[][] mat = new PixelCouleur[_hauteur][_largeur];
        PixelCouleur[][] matR = new PixelCouleur[_hauteur/2][_largeur/2];

        for (short i = n; i < n + 2; i++){
            for (short j = m; j < m + 2; j++){
                moyBlue = moyBlue + mat[n][m].get_blue();
                moyRed = moyRed + mat[n][m].get_red();
                moyGreen = moyGreen + mat[n][m].get_green();
            }
        }

    }
}
