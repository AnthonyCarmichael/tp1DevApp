/**
 * Cette classe sert à tester l'implémentation des images, les sous-classes d'image, les pixels et les sous-classes
 * de pixel. Lorsque ce code est exécuté, des fichiers seront lus et certains seront écrits dans le dossier image.
 *
 * @author Anthony Carmichael, Richard Dongmo, Maxime Malette
 */
public class test {
    public static void main(String[] args){
        // Instanciation des objets
        Traducteur traducteur = new Traducteur();

        Image imageCouleur;
        Image imageNoirBlanc;
        Image image3Couleur;
        Image image4NoirBlanc;
        Image imageExtraite;
        Image imageExtraiteCouleur;

        // Opération Lecture a l'aide d'un traducteur qui retourne la bonne categorie d'image
        imageCouleur = traducteur.lire("image/Sherbrooke_Frontenac_nuit.ppm");
        imageNoirBlanc = traducteur.lire("image/testNoirBlancNonModif.pgm");
        System.out.println("Images initialisées : ");
        System.out.println(imageCouleur);
        System.out.println(imageNoirBlanc);
        System.out.print("\n");


        // Opération sont_identiques: Test lorsque les deux images sont différentes
        System.out.println("TEST Sont_identique (sensé retourner false): ");
        // Affichage des caractéristiques des deux images
        System.out.println(imageCouleur);
        System.out.println(imageNoirBlanc);
        System.out.println((imageCouleur).sont_identique(imageNoirBlanc)); // Sensé retourner false
        System.out.print("\n");

        // Change le chemin pour ne pas écrire sur le fichier d'origine
        imageCouleur.set_chemin("image/testEcriture.ppm");
        // Écriture de l'image en couleur
        imageCouleur.ecrire();

        // Change le chemin pour ne pas écrire sur le fichier d'origine
        imageNoirBlanc.set_chemin("image/testEcriture.pgm");
        // Écriture de l'image en noir et blanc
        imageNoirBlanc.ecrire();

        // Lecture des nouveaux fichiers précédament créés
        image3Couleur = traducteur.lire("image/testEcriture.ppm");
        image4NoirBlanc = traducteur.lire("image/test.pgm");

        System.out.println("Actualisation des images initialisées : ");
        System.out.println(imageCouleur);
        System.out.println(imageNoirBlanc);
        System.out.println(image3Couleur);
        System.out.println(image4NoirBlanc);
        System.out.print("\n");

        // Test sont_identique imageCouleur initial et une autre image qui provient du fichier apres l'écriture
        System.out.println("TEST Sont_identique (sensé retourner true): ");
        System.out.println(imageCouleur);
        System.out.println(image3Couleur);
        System.out.println((imageCouleur).sont_identique(image3Couleur)); // Sensé retourner true
        System.out.print("\n");


        // Test copier deux type différent
        System.out.println("TEST copier Type différent (ne doit pas copier): ");
        System.out.println("Images avant la copie: ");
        System.out.println(imageCouleur);
        System.out.println(image4NoirBlanc);
        imageCouleur.copier(image4NoirBlanc);
        System.out.println("Images après la copie: ");
        System.out.println(imageCouleur);
        System.out.println(image4NoirBlanc);
        System.out.print("\n");

        // Test copier NoirBlanc
        System.out.println("TEST copier noir et blanc: ");
        System.out.println("Images avant la copie ");
        System.out.println(imageNoirBlanc);
        System.out.println(image4NoirBlanc);
        imageNoirBlanc.copier(image4NoirBlanc);
        System.out.println("Images après la copie ");
        System.out.println(imageNoirBlanc);
        System.out.println(image4NoirBlanc);
        System.out.print("\n");

        // Test extraire noir blanc fait un nouveau fichier a partir de la nouvelle image extraite
        imageExtraite = image4NoirBlanc.extraire((short)1,(short)13,(short)5,(short)16);
        imageExtraite.set_chemin("image/testExtraire.pgm");
        imageExtraite.ecrire();

        // Test extraire couleur fait un nouveau fichier a partir de la nouvelle image extraite
        imageExtraiteCouleur = imageCouleur.extraire((short)25,(short)25,(short)150,(short)225);
        imageExtraiteCouleur.set_chemin("image/testExtraireCouleur.ppm");
        imageExtraiteCouleur.ecrire();

        // Test copier couleur
        System.out.println("TEST copier couleur: ");
        System.out.println("Images avant la copie ");
        System.out.println(imageCouleur);
        System.out.println(imageExtraiteCouleur);
        imageCouleur.copier(imageExtraiteCouleur);
        System.out.println("Images après la copie ");
        System.out.println(imageCouleur);
        System.out.println(imageExtraiteCouleur);
        System.out.print("\n");

        ///////////////////////////////////////////////////////////////////////////////////
        // TEST RICHARD
        Image image;
        image = traducteur.lire("image/test.pgm");
        System.out.println(image);
        if (image instanceof ImageNoirBlanc){
            image.set_chemin("image/test_reduire.pgm");
            ((ImageNoirBlanc) image).reduire();
            System.out.println(image);
        }
    }
}
