public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image;
        Image image2;
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");
        image2 = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");


        if (image instanceof ImageCouleur)
        {
            System.out.print("Couleur");
            ((ImageCouleur) image).eclaircir_noicir(1);
        }

        System.out.println(image);
        System.out.println(image.sont_identique(image2));
    }
}
