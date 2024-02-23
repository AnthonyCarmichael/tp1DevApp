public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image;
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");
        System.out.println(image);
        if (image instanceof ImageNoirBlanc){
            //((ImageCouleur) image).eclaircir_noicir(-98);
            ((ImageNoirBlanc) image).couleur_preponderante();
        }


    }
}
