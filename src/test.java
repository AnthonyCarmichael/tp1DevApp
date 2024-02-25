public class test {
    public static void main(String[] args){
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // TEST ANTHO
        Traducteur traducteur = new Traducteur();

        Image imageCouleur;
        Image imageNoirBlanc;

        Image image3;

        imageCouleur = traducteur.lire("image/Sherbrooke_Frontenac_nuit.ppm");
        imageNoirBlanc = traducteur.lire("image/testNoirBlancNonModif.pgm");

        System.out.println(imageCouleur);
        System.out.println(imageNoirBlanc);

        System.out.println((imageCouleur).sont_identique(imageNoirBlanc)); // Sensé retourner false

        imageCouleur.set_chemin("image/testEcriture.ppm");
        imageCouleur.ecrire();

        imageNoirBlanc.set_chemin("image/testEcriture.pgm");
        imageNoirBlanc.ecrire();

        image3 = traducteur.lire("image/testEcriture.ppm");
        System.out.println((imageCouleur).sont_identique(image3)); // Sensé retourner true


        ///////////////////////////////////////////////////////////////////////////////////
        // TEST RICHARD
        Image image;
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");
        System.out.println(image);
        if (image instanceof ImageNoirBlanc){
            //((ImageCouleur) image).eclaircir_noicir(-98);
            ((ImageNoirBlanc) image).couleur_preponderante();
        }

    }
}
