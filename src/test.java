public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image = new Image();
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.ppm");

        if (image instanceof ImageCouleur)
        {
            System.out.print("Couleur");
            ((ImageCouleur) image).eclaircir_noicir(1);
        }

        System.out.println(image);
    }
}
