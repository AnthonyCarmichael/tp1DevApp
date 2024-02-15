public class Image {
    protected String _type;
    protected short _largeur;
    protected short _hauteur;
    protected int _maxValue;
    protected String _chemin;
    protected Pixel[][] _matrice ;


    public Image() {
        _type = "";
        _largeur = 0;
        _hauteur = 0;
        _maxValue = 0;
        _chemin = "";
        _matrice = new Pixel[0][0];
    }
    public Image(String type, short largeur, short hauteur, int maxValue, String chemin, Pixel[][] matrice) {
        _type = type;
        _largeur = largeur;
        _hauteur = hauteur;
        _maxValue = maxValue;
        _chemin = chemin;
        _matrice = matrice;
    }

    public void lireFichier(String chemin) {
    }
    public void ecrire() {
    }
    public void copier(Image imageCopier){
    }




}
