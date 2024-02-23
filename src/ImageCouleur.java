import java.util.Scanner;

/**
 *
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * cette classe implémente une image en couleur
 */

public class ImageCouleur extends Image{

    /*Cette méthode retourne la couleur prépondérante*/
    public PixelCouleur couleur_preponderante(){
        PixelCouleur[] tabPixel = new PixelCouleur[get_hauteur() * get_largeur()];

        /*Remplissage du tableau de pixel avec les donn/es de la matrice de pixel*/
        int k = 0;

        for (int i = 0; i < getMatrice().length; i++){
            for (int j = 0; j < getMatrice()[i].length; j++){
                tabPixel[k] = (PixelCouleur) getMatrice()[i][j];
                k++;
            }
        }

        int taille = tabPixel.length;
        int max_count = 0;
        PixelCouleur preponderant = new PixelCouleur();

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

        System.out.print("Pixel préponderant: " + preponderant.get_red() + " " + preponderant.get_green() + " " + preponderant.get_blue() + " " + max_count);

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
                System.out.println(x+","+y);
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
}
