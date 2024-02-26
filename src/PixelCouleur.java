/**
 * La classe PixelCouleur est la classe enfant de Pixel qui va gérer les pixels des images en couleurs.
 *
 *  @author Anthony Carmichael, Maxime Malette, Richard Dongmo
 *  @version 1.0
 */
public class PixelCouleur extends Pixel{

    /**
     * Attribut privé de la classe
     */
    private int _red;
    private int _green;
    private int _blue;


    @Override
    public String toString(){
        String pixel = get_red() + " " + get_green() + " " + get_blue();

        return pixel;
    }


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
     * @param v Indique de combien le pixel doit être éclaircit ou noircit.
     * @param maxVal Indique au pixel quelle est sa valeur maximale pour qu'il ne la dépasse pas.
     */
    public void eclaircir_noircir(int v, int maxVal){
        if (_red + v >= maxVal){
            _red = maxVal;
        }
        else if (_red + v <= 0) {
            _red = 0;
        }
        else{
            _red = _red + v;
        }
        if (_green + v>=maxVal){
            _green = maxVal;
        }
        else if (_green + v <= 0) {
            _green = 0;
        }
        else{
            _green = _green + v;
        }
        if (_blue + v>=maxVal){
            _blue = maxVal;
        }
        else if (_blue + v <= 0) {
            _blue = 0;
        }
        else{
            _blue = _blue + v;
        }
    }

    /**
     * Permet de vérifier si deux pixels sont identiques
     * @param p C'est le pixel avec lequel on va comparer notre pixel
     * @return La fonction retourne true si les deux pixels sont identiques et false si ils ne le sont pas
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

    /**
     * Permet de renvoyer le nouveau pixel que nous allons vouloir lors de la réduction d'une image
     * @param p1 Un pixel qui va se combiner à notre pixel
     * @param p2 Un pixel qui va se combiner à notre pixel
     * @param p3 Un pixel qui va se combiner à notre pixel
     * @return La fonction retourne le nouveau pixel fusionné
     */
    public PixelCouleur reduire(PixelCouleur p1, PixelCouleur p2, PixelCouleur p3){
        int newRed = (_red + p1.get_red() + p2.get_red() + p3.get_red())/4;
        int newGreen = (_green + p1.get_green() + p2.get_green() + p3.get_green())/4;
        int newBlue = (_blue + p1.get_blue() + p2.get_blue() + p3.get_blue())/4;
        PixelCouleur newPixel = new PixelCouleur(newRed, newGreen, newBlue);
        return newPixel;
    }
}
