/**
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * La classe PixelNoirBlanc est la classe enfant de Pixel qui va gérer les pixels des images en noir et blanc.
 */
public class PixelNoirBlanc extends Pixel {
    /**
     * Attribut privé de la classe
     */
    private int _nuance;

    /**
     * Constructeur sans paramètres de la classe
     */
    public PixelNoirBlanc(){
        _nuance = 0;
    }

    /**
     * Constructeur avec paramètres de la classe
     */
    public PixelNoirBlanc(int nuance){
        _nuance = nuance;
    }
    /**
     * Getteurs et setteurs de la classe
     */
    public int get_nuance() {
        return _nuance;
    }

    public void set_nuance(int _nuance) {
        this._nuance = _nuance;
    }
    /**
     * Permet de noircir ou d'éclaircir le pixel
     */
    public void eclaircir_noircir(int v){
        _nuance = _nuance + v;
    }

    /**
     * Permet de vérifier si deux pixels sont identiques
     */
    public boolean sont_identiques(Pixel p){
        return true;
    }

    /**
     * Permet d'écrire la valeur d'un pixel dans un fichier
     */
    public Pixel ecrire(){
        return this;
    }
}
