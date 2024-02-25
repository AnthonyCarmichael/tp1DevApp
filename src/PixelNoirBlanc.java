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
     * @param v Indique de combien le pixel doit être éclaircit ou noircit.
     * @param maxVal Indique au pixel quelle est sa valeur maximale pour qu'il ne la dépasse pas.
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
     * @param p C'est le pixel avec lequel on va comparer notre pixel
     * @return La fonction retourne true si les deux pixels sont identiques et false si ils ne le sont pas
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
     * @param p1 Un pixel qui va se combiner à notre pixel
     * @param p2 Un pixel qui va se combiner à notre pixel
     * @param p3 Un pixel qui va se combiner à notre pixel
     * @return La fonction retourne le nouveau pixel fusionné
     */
    public PixelNoirBlanc reduire(PixelNoirBlanc p1, PixelNoirBlanc p2, PixelNoirBlanc p3){
       int newNuance = (_nuance + p1.get_nuance() + p2.get_nuance() + p3.get_nuance())/4;
       System.out.println(newNuance);
       PixelNoirBlanc newPixel = new PixelNoirBlanc(newNuance);
       return newPixel;
    }
}
