public class test {
    public static void main(String[] args){

        Traducteur traducteur = new Traducteur();

        Image imageCouleur;
        Image imageNoirBlanc;

        Image image3;
        Image image4;


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

        imageNoirBlanc.copier(image4);
        image4.extraire((short)1,(short)13,(short)5,(short)16);
        image4.set_chemin("image/testExtraire.pgm");
        //imageCouleur.pivoter90();
        image4.ecrire();

    }
}
