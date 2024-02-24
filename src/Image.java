/**
 * @author Anthony Carmichael, Richard Dongmo, Maxime Malette
 * @version 1.0
 *
 * Cette classe implémente une image.
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files


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

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00$");
        return "Type: " +_type +" | Chemin: " + _chemin + " | Hauteur: " + _hauteur + " | Largeur: " + _largeur + " | MaxVal: " + get_maxValue();
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

    /** Getteur du type d'image **/
    public String get_type() {
        return _type;
    }

    /** Setteur du type d'image **/
    public void set_type(String _type) {
        this._type = _type;
    }

    /** Getteur largeur de l'image **/
    public short get_largeur() {
        return _largeur;
    }

    /** Setteur de la largeur de l'image **/
    public void set_largeur(short _largeur) {
        this._largeur = _largeur;
    }

    /** Getteur hauteur de l'image **/
    public short get_hauteur() {
        return _hauteur;
    }

    /** Setteur de la hauteur de l'image **/
    public void set_hauteur(short _hauteur) {
        this._hauteur = _hauteur;
    }

    /** Getteur de la valeur maximal du gradiant de valeur **/
    public int get_maxValue() {
        return _maxValue;
    }

    /** Setteur de la valeur maximal du gradiant de valeur **/
    public void set_maxValue(int _maxValue) {
        this._maxValue = _maxValue;
    }

    /** Getteur du chemin de l'image **/
    public String get_chemin() {
        return _chemin;
    }

    /** Setteur du chemin de l'image **/
    public void set_chemin(String _chemin) {
        this._chemin = _chemin;
    }

    /** Getteur de la matrice de pixel **/
    public Pixel[][] getMatrice() {
        return _matrice;
    }

    /** Setteur de la matrice de pixel **/
    public void set_matrice(Pixel[][] matrice) {
        this._matrice = matrice;
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
     * @param image : Correspond a l'image explicite qui sera comparée
     */
    public boolean sont_identique(Image image) {
        if (!this.get_type().equals(image.get_type()))
            return false;
        else if (this.get_largeur() != image.get_largeur()) {
            return false;
        } else if (this.get_hauteur() != image.get_hauteur()) {
            return false;
        } else if (this.get_maxValue() != image.get_maxValue()) {
            return false;
        } /*else if (!this.get_chemin().equals(image.get_chemin())) {
            return false;
        }
        Peut-être la même image sans forcément avoir le même chemin */

        String[] cheminExtension = get_chemin().split("\\.");
        System.out.println(cheminExtension[1]);

        if(cheminExtension[1].equals("pgm")) // Si l'image est noir et blanc
        {
            return ((ImageNoirBlanc)this).matrice_identique(image);

        } else if (cheminExtension[1].equals("ppm")) { // Si l'image est en couleur

            return ((ImageCouleur)this).matrice_identique(image);
        }
        else {
            System.out.print("Erreur");
            return false;
        }
    }

    /**
     * Permet la rotation de l'image en changeant l'indexation des pixels
     */
    public void pivoter90() {
        Pixel[][] newMat = new Pixel[_hauteur][_largeur];

        for (int i = 0; i < _largeur; i++) {
            for (int j = 0; j < _hauteur; j++) {
                newMat[j][_largeur - i - 1] = _matrice[i][j];
            }
        }

        _matrice = newMat;
        short temp =_largeur;
        _largeur = _hauteur;
        _hauteur = temp;
    }


}
