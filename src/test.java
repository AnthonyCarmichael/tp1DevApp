public class test {
    public static void main(String[] args){
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // TEST ANTHO
        Traducteur traducteur = new Traducteur();

        Image imageCouleur;
        Image imageNoirBlanc;

        Image image3;
        Image image4;
        Image imageExtraite;
        Image imageExtraiteCouleur;

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
        image4 = traducteur.lire("image/test.pgm");
        System.out.println((imageCouleur).sont_identique(image3)); // Sensé retourner true

        // Test extraire et copier NoirBlanc
        imageNoirBlanc.copier(image4);
        imageExtraite = image4.extraire((short)1,(short)13,(short)5,(short)16);
        imageExtraite.set_chemin("image/testExtraire.pgm");
        imageExtraite.ecrire();

        // Test extraire et copier Couleur
        imageExtraiteCouleur = imageCouleur.extraire((short)25,(short)25,(short)150,(short)225);
        imageExtraiteCouleur.set_chemin("image/testExtraireCouleur.ppm");
        imageExtraiteCouleur.ecrire();
        imageCouleur.copier(imageExtraiteCouleur);

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
