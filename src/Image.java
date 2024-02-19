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

    // Getteur/Setteur **************************************************************//
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
    //*************************************************************************//

    public void lire(String f) {
    }

    public void ecrire() {
    }

    public void copier(Image i) {
    }

    public void extraire(short l1, short col1, short l2, short col2 ) {
    }

    public void sont_identique(Image i) {
    }
    public void pivoter90() {
    }

}
