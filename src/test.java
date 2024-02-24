public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image;
        Image image2;
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");
        image2 = traducteur.lire("image/testNoirBlancNonModif.pgm");

        System.out.println((image).sont_identique(image2));
    }
}
