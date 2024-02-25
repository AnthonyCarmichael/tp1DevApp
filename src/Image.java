/**
 * @author Anthony Carmichael, Richard Dongmo, Maxime Malette
 * @version 1.0
 *
 * Cette classe implémente une image.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
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
        _chemin="";
        this.set_matrice(matrice);
    }

    @Override
    public String toString(){
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
    public void set_chemin(String chemin) {
        String[] cheminExtensionParam = chemin.split("\\.");
        if ((cheminExtensionParam[1].equalsIgnoreCase("pgm") ||cheminExtensionParam[1].equalsIgnoreCase("ppm")))
        {
            if (Objects.equals(get_chemin(), ""))
            {
                _chemin=chemin;
            }
            else
            {
                String[] cheminExtension = get_chemin().split("\\.");
                if (cheminExtension[1].equals(cheminExtensionParam[1])){
                    this._chemin = chemin;
                }
                else {
                    System.out.print("Impossible de modifier l'extension du fichier : "+ cheminExtension[1]);
                }
            }
        }
        else {
            System.out.print("Type de fichier incompatible : "+ cheminExtensionParam[1]);
        }
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
        try {
            short cpt =0;
            BufferedWriter writer = new BufferedWriter(new FileWriter(get_chemin()));
            writer.write(get_type()+"\n"+get_largeur()+" "+get_hauteur()+"\n"+get_maxValue()+"\n");

            String[] cheminExtension = get_chemin().split("\\.");
            if (cheminExtension[1].equals("pgm") && this instanceof ImageNoirBlanc) {
                ((ImageNoirBlanc)this).ecrire(writer);
            }
            else if (cheminExtension[1].equals("ppm") && this instanceof ImageCouleur)
            {
                ((ImageCouleur)this).ecrire(writer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copier une image explicite
     * @param i : Correspond a l'image explicite qui sera copier dans l'image implicite
     */
    public void copier(Image i) {
        if (!sont_identique(i)) {
            if (i.getClass() == this.getClass())
            {
                this.set_type(i.get_type());
                this.set_chemin(i.get_chemin());
                this.set_hauteur(i.get_hauteur());
                this.set_largeur(i.get_largeur());
                this.set_maxValue(i.get_maxValue());
                this.set_matrice(i.getMatrice());
            }
            else {
                System.out.print("L'image doit être du même type");
            }
        }
        else {
            System.out.print("Les deux images sont déjà identique");
        }
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

        if(cheminExtension[1].equals("pgm") && this instanceof ImageNoirBlanc) // Si l'image est noir et blanc
        {
            return ((ImageNoirBlanc)this).matrice_identique(image);

        } else if (cheminExtension[1].equals("ppm") && this instanceof ImageCouleur) { // Si l'image est en couleur

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
