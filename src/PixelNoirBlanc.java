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
    public void eclaircir_noircir(int v, int maxVal){
        if (_nuance + v >= maxVal){
            _nuance = maxVal;
        }
        else if (_nuance + v <= 0) {
            _nuance = 0;
        }
        else{
            _nuance = _nuance + v;
        }
    }

    /**
     * Permet de vérifier si deux pixels sont identiques
     */
    public boolean sont_identiques(PixelNoirBlanc p){
        if (_nuance == p.get_nuance()){
            return true;
        }
        return false;
    }

    /**
     * Permet d'écrire la valeur d'un pixel dans un fichier
     */
    public void ecrire(){
        System.out.println(_nuance);
    }

    /**
     * Permet de renvoyer le nouveau pixel que nous allons vouloir lors de la réduction d'une image
     */
    public PixelNoirBlanc reduire(PixelNoirBlanc p1, PixelNoirBlanc p2, PixelNoirBlanc p3){
       int newNuance = (_nuance + p1.get_nuance() + p2.get_nuance() + p3.get_nuance())/4;
       System.out.println(newNuance);
       PixelNoirBlanc newPixel = new PixelNoirBlanc(newNuance);
       return newPixel;
    }
}
