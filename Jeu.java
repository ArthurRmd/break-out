import MG2D.*;
import MG2D.geometrie.*;

public class Jeu {

    Jeu game;
    public Plateau parti;
    private InterfaceGraphique graphique;



    public Jeu() {



        int numJoueur = (((int) (Math.random()*100)) % 2 ) + 1;    // Renvoi un nombre aléatoire 1 ou 2 : Permet de choisir aléatoirement un joueur
        int nbColonne = 5;
        int nbLigne = 7;
        int taille = 0;
        int nombreRetourne;


        InterfaceGraphique interfaceGraphique = new InterfaceGraphique();


        nombreRetourne = interfaceGraphique.affichageMenu();

        taille =  ( int) (nombreRetourne / 10000);
        nbColonne = ( nombreRetourne - ( taille * 10000)) / 100;
        nbLigne = ( nombreRetourne - (taille * 10000) - ( nbColonne * 100));


        parti = new Plateau(nbColonne, nbLigne);
        System.out.println(parti.toString());
        interfaceGraphique.lancementPartie(nbLigne,nbColonne, taille, 1, parti);





        while (true) {

            numJoueur = parti.changeJoueur(numJoueur);  // Permet de changer de joueur

            interfaceGraphique.Souris(nbLigne, nbColonne, numJoueur, parti);

           interfaceGraphique.refreshCroix(nbColonne, nbLigne, parti);

            System.out.println(parti.toString());

        }






    }


}
