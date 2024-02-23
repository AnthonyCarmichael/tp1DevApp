public class test {
    public static void main(String[] args){

         Traducteur traducteur = new Traducteur();

        Image image = new Image();
        image = traducteur.lire("image/Sherbrooke_Frontenac_nuit.ppm");
        System.out.println(image);


    }
}
