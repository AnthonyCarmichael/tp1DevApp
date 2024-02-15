public class Pixel {
    protected int _couleur;

    public Pixel()
    {
        _couleur = 0;
    }
    public Pixel(int couleur)
    {
        _couleur = couleur;
    }

    public int get_couleur() {
        return _couleur;
    }
    public void set_couleur(int _couleur) {
        this._couleur = _couleur;
    }
    public void draw() {
    }


}
