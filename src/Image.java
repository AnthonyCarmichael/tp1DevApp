/**
 * @author Anthony Carmichael, Richard Dongmo, Maxime Malette
 * @version 1.0
 *
 * Cette classe implémente une image.
 */

public class Image {
    protected String _type;
    protected short _largeur;
    protected short _hauteur;
    protected int _maxValue;
    protected String _chemin;
    protected Pixel[][] _matrice;


    /**
     * Constructeur sans paramètre :
     */
    Image() {
        Pixel[][] matrice = {};
        this.set_type("");
        this.set_largeur((short)0);
        this.set_hauteur((short)0);
        this.set_maxValue(0);
        this.set_chemin("");
        this.set_matrice(matrice);
    }

    /**
     * Constructeur:
     * @param type : Correspond au type du fichier en String : P2 ou P5 pour pgm et P3 ou P6 pour PPM
     * @param largeur : Correspond a la largeur de l'image, doit être un short (limite de 32 767)
     * @param hauteur : Correspond a la hauteur de l'image, doit être un short (limite de 32 767)
     * @param maxValue : Correspond a la valeur maximal du gradiant de possibilité de couleur ou nuance de gris
     * @param chemin : Correspond au chemin du fichier pour l'image en question et doit être un String
     * @param matrice : Correspond a un tableau deux dimension qui sera peuplé de Pixel
     */
    Image(String type, short largeur, short hauteur, int maxValue,String chemin, Pixel[][] matrice) {
        this.set_type(type);
        this.set_largeur(largeur);
        this.set_hauteur(hauteur);
        this.set_maxValue(maxValue);
        this.set_chemin(chemin);
        this.set_matrice(matrice);
    }

    /** Getter and Setter **************************************************************/
    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public short get_largeur() {
        return _largeur;
    }

    public void set_largeur(short _largeur) {
        this._largeur = _largeur;
    }

    public short get_hauteur() {
        return _hauteur;
    }

    public void set_hauteur(short _hauteur) {
        this._hauteur = _hauteur;
    }

    public int get_maxValue() {
        return _maxValue;
    }

    public void set_maxValue(int _maxValue) {
        this._maxValue = _maxValue;
    }

    public String get_chemin() {
        return _chemin;
    }

    public void set_chemin(String _chemin) {
        this._chemin = _chemin;
    }

    public Pixel[][] getMatrice() {
        return _matrice;
    }

    public void set_matrice(Pixel[][] matrice) {
        this._matrice = matrice;
    }
    /*************************************************************************/

    /**
     * Lecture d'un fichier pour peupler la matrice de l'image implicite
     */
    public void lire() {
    }

    /**
     * Écriture dans un fichier pour exporter notre image dans un fichier
     */
    public void ecrire() {
    }

    /**
     * Copier une image explicite
     * @param i : Correspond a l'image explicite qui sera copier dans l'image implicite
     */
    public void copier(Image i) {
    }

    /**
     * Permet d'extraire une partie d'image pour en former une nouvelle image
     * @param l1 : Concerne la ligne dans la matrice du pixel coin haut/gauche de la partie a extraire
     * @param col1 : Concerne la colone dans la matrice du pixel coin haut/gauche de la partie a extraire
     * @param l2 : Concerne la ligne dans la matrice du pixel coin bas/droite de la partie a extraire
     * @param col2 : Concerne la colone dans la matrice du pixel coin bas/droite de la partie a extraire
     */
    public Image extraire(short l1, short col1, short l2, short col2 ) {
        Image newImage = new Image();
        return newImage;
    }

    /**
     * Verification si l'image implicite et explicite sont identique
     * @param i : Correspond a l'image explicite qui sera comparée
     */
    public boolean sont_identique(Image i) {
        return true;
    }

    /**
     * Permet la rotation de l'image en changeant l'indexation des pixels
     */
    public void pivoter90() {
    }

}
