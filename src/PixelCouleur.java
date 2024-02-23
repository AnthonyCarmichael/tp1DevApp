/**
 * @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 * @version 1.0
 *
 * La classe PixelCouleur est la classe enfant de Pixel qui va gérer les pixels des images en couleurs.
 */
public class PixelCouleur extends Pixel{

    /**
     * Attribut privé de la classe
     */
    private int _red;
    private int _green;
    private int _blue;



    /**
     * Constructeur sans paramètres de la classe
     */
    public PixelCouleur(){
        _red = 0;
        _green = 0;
        _blue = 0;
    }

    /**
     * Constructeur avec paramètres de la classe
     */
    public PixelCouleur(int r, int g, int b){
        _red = r;
        _green = g;
        _blue = b;
    }

    /**
     * Getteurs et setteurs de la classe
     */
    public int get_blue() {
        return _blue;
    }

    public void set_blue(int _blue) {
        this._blue = _blue;
    }

    public int get_green() {
        return _green;
    }

    public void set_green(int _green) {
        this._green = _green;
    }

    public int get_red() {
        return _red;
    }

    public void set_red(int _red) {
        this._red = _red;
    }

    /**
     * Permet de setter la valeur de tous les paramètres en même temps
     */
    public void setCouleur(int r, int g, int b){
        _red = r;
        _green = g;
        _blue = b;
    }

    /**
     * Permet de noircir ou d'éclaircir le pixel
     */
    public void eclaircir_noircir(int v, int maxVal){
        if (_red + v >= maxVal){
            _red = maxVal;
        }
        else{
            _red = _red + v;
        }
        if (_green + v>=maxVal){
            _green = maxVal;
        }
        else{
            _green = _green + v;
        }
        if (_blue + v>=maxVal){
            _blue = maxVal;
        }
        else{
            _blue = _blue + v;
        }
    }

    /**
     * Permet de vérifier si deux pixels sont identiques
     */
    public boolean sont_identiques(PixelCouleur p){
        if (_red == p.get_red() && _blue == p.get_blue() && _green == p.get_green()){
            return true;
        }
        return false;
    }

    /**
     * Permet d'écrire la valeur d'un pixel dans un fichier
     */
    public void ecrire(){
        System.out.println(_red + " " + _green + " " + _blue);
    }

    public Pixel reduire(PixelCouleur p1, PixelCouleur p2, PixelCouleur p3){
        int newRed = (_red + p1.get_red() + p2.get_red() + p3.get_red())/4;
        int newGreen = (_green + p1.get_green() + p2.get_green() + p3.get_green())/4;
        int newBlue = (_blue + p1.get_blue() + p2.get_blue() + p3.get_blue())/4;
        PixelCouleur newPixel = new PixelCouleur(newRed, newGreen, newBlue);
        return newPixel;
    }
}
