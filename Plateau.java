
import MG2D.*;
import MG2D.geometrie.*;

public class Plateau {

    private Ligne[] tableau;







    // Constructeur par Défaut //

    public Plateau() {

        tableau = new Ligne[1];
        tableau[0] = new Ligne();
    }


    public  Plateau ( int nb_colonne , int nb_ligne) {

        tableau = new Ligne[nb_ligne];
        for ( int i=0 ; i< nb_ligne; i++)  {
            tableau[i] = new Ligne(nb_colonne);
        }
    }



    // Accesseur  //


    public Case getXY ( int x , int y ) {

        return tableau[y].getX(x);
    }


    public void ajoutPion( int numeroLigne , int nombreColonne, int numJoueur ,  boolean cotesGauche) {

        int largeurPlateau = this.tailleLargeur();

    if ( cotesGauche ) {

        tableau[numeroLigne].decalageLigneVersDroite();
        tableau[numeroLigne].setX(0,numJoueur);
    }



    else  {

        tableau[numeroLigne].decalageLigneVersGauche();
        tableau[numeroLigne].setX(nombreColonne - 1 ,numJoueur);

        }

    }




    public String toString() {

        int taille1 = tableau.length;
        int taille2 = tableau[1].getTaille();
        int temp = 0;
        String str = "";


        for ( int i=taille1  - 1 ; i >= 0 ; i--) {

            for ( int j=0 ; j < taille2 ; j++) {

                str += ("|");
                str += (tableau[i].getX(j).getContenu());

            }

            str += ("|\n");

        }

        return str;
    }

    public int tailleLargeur () {
        return tableau[0].getTaille();
    }

    public int tailleHauteur () {
        return tableau.length;
    }




    public int changeJoueur ( int numJoueur) {


        if ( numJoueur != 1 && numJoueur != 2) {

            numJoueur = 1;

        }


        if ( numJoueur == 1) {

            numJoueur = 2;

        }


        else {

            numJoueur = 1;

        }

        return  numJoueur;
    }




}
