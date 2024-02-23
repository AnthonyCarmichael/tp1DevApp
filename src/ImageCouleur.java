/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en couleur
 */

public class ImageCouleur extends Image{

    /*private PixelCouleur[][] matriceColeur;


    public ImageCouleur(){

    }*/
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
                ((PixelCouleur)getMatrice()[i][j]).eclaircir_noircir(valeur, get_maxValue());
            }
        }
    }

    /*Cette méthode réduit le pixel*/
    public void reduire(){

    }
}
