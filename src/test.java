public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image = new Image();
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.pgm");
        System.out.println(image);
        if (image instanceof ImageNoirBlanc){
            ((ImageNoirBlanc) image).eclaircir_noicir(-98);
        }

    }
}
