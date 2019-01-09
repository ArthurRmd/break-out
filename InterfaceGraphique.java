import MG2D.*;
import MG2D.geometrie.*;
import MG2D.geometrie.Point;
import MG2D.geometrie.Rectangle;


import java.awt.*;



public class InterfaceGraphique {

    private Fenetre f;
    private Fenetre f1;
    private Fenetre fMenu;
    private Clavier clavier;
    private Clavier clavier1;

    private Texture[][] croix;
    private Texture[][] croixHorsJeu;

    private Souris souris1;
    private Souris sourisMenu;

    private Font police;
    private Font petitePolice;
    private Font moyennePolice;
    private Font grandePolice;
    private Texte texte;

    private int taille;

    private Carre CaseVideJeu;


    public InterfaceGraphique() {






        police = new Font("Calibri", Font.BOLD, 40);
        petitePolice = new Font("Calibri", Font.BOLD, 20);
        moyennePolice = new Font("Calibri", Font.BOLD, 25);
        grandePolice = new Font("Calibri", Font.BOLD, 33);





    }



    /*------------------ Méthode Fenetre ------------------------*/

    public int affichageMenu() {




        police = new Font("Calibri", Font.BOLD, 40);
        petitePolice = new Font("Calibri", Font.BOLD, 20);
        moyennePolice = new Font("Calibri", Font.BOLD, 35);
        grandePolice = new Font("Calibri", Font.BOLD, 55);




        f1 = new Fenetre("Break Out", 900, 475);
        clavier1 = f1.getClavier();
        Texte texte2 = new Texte();

        sourisMenu = f1.getSouris();


        texte = new Texte(Couleur.NOIR, "Bienvenue dans le Break Out", police, new Point(f1.getMilieu().getX(), 430));
        f1.ajouter(texte);

        Texte texteJouer = new Texte(Couleur.NOIR, "Jouer", grandePolice, new Point(f1.getMilieu().getX(), 315));
        f1.ajouter(texteJouer);




        Texte texteColonne = new Texte(Couleur.NOIR, "Nombre de Colonne ", petitePolice, new Point(f1.getMilieu().getX() - 300, 195));
        f1.ajouter(texteColonne);

        Texte texteNombreC = new Texte(Couleur.NOIR, "5", police, new Point(f1.getMilieu().getX() - 300, 145));
        f1.ajouter(texteNombreC);

        Texte textePlusc = new Texte(Couleur.NOIR, "+", petitePolice, new Point(f1.getMilieu().getX() - 250, 145));
        f1.ajouter(textePlusc);

        Texte texteMoinsC = new Texte(Couleur.NOIR, "-", police, new Point(f1.getMilieu().getX() - 350, 145));
        f1.ajouter(texteMoinsC);





        Texte texteLigne = new Texte(Couleur.NOIR, "Nombre de Ligne ", petitePolice, new Point(f1.getMilieu().getX() + 300, 195));
        f1.ajouter(texteLigne);

        Texte texteNombreL = new Texte(Couleur.NOIR, "5", police, new Point(f1.getMilieu().getX() + 300, 145));
        f1.ajouter(texteNombreL);

        Texte textePlusL = new Texte(Couleur.NOIR, "+", petitePolice, new Point(f1.getMilieu().getX() + 350, 145));
        f1.ajouter(textePlusL);

        Texte texteMoinsL = new Texte(Couleur.NOIR, "-", police, new Point(f1.getMilieu().getX() + 250, 145));
        f1.ajouter(texteMoinsL);




        Texte textePourcentage= new Texte(Couleur.NOIR, "Taille de chaque case (px) ", petitePolice, new Point(f1.getMilieu().getX() , 195));
        f1.ajouter(textePourcentage);

        Texte texteNombreP = new Texte(Couleur.NOIR, "100", police, new Point(f1.getMilieu().getX() , 145));
        f1.ajouter(texteNombreP);

        Texte textePlusP = new Texte(Couleur.NOIR, "+", petitePolice, new Point(f1.getMilieu().getX() + 75, 145));
        f1.ajouter(textePlusP);

        Texte texteMoinsP = new Texte(Couleur.NOIR, "-", police, new Point(f1.getMilieu().getX() - 75, 145));
        f1.ajouter(texteMoinsP);




        Texte texteBasDePage = new Texte(Couleur.NOIR, "Clique sur les boutons + et - pour changer les paramètres ", petitePolice, new Point(f1.getMilieu().getX(), 60));
        f1.ajouter(texteBasDePage);

        Texte texteBasDePage2 = new Texte(Couleur.NOIR, "Puis  clique sur jouer pour lancer la partie ", petitePolice, new Point(f1.getMilieu().getX(), 25));
        f1.ajouter(texteBasDePage2);


            Point ptSouris = new Point(0,0);
            int positionX = 0;
            int positionY = 0;

            boolean continuer = false;
            boolean clicGauche = false;

            int nombreColonne = 5;
            int nombreLigne = 5;
            int pourcentage = 100;

            int nombreARetourner = 0;

            String chaine  = new String();




            while (!continuer) {

                try {
                    Thread.sleep(50);
                } catch(Exception e) {}



                ptSouris = sourisMenu.getPosition();

                positionX = ptSouris.getX();
                positionY = ptSouris.getY();


            if (sourisMenu.getClicGauche()) {




                if (  315 < positionX && positionX < 560   && 260 < positionY  && positionY < 375 ) {
                    continuer = true;
                }



                if (  75 < positionX && positionX < 125   && 120 < positionY  && positionY < 170 ) {

                  if ( nombreColonne  > 4) {

                      nombreColonne--;
                      chaine = chaine.valueOf(nombreColonne);
                      texteNombreC.setTexte(chaine);
                      f1.rafraichir();
                  }

                }

                if (  175< positionX && positionX < 220   && 120 < positionY  && positionY < 170 ) {

                    if ( nombreColonne < 99) {

                        nombreColonne++;
                        chaine = chaine.valueOf(nombreColonne);
                        texteNombreC.setTexte(chaine);
                        f1.rafraichir();
                    }

                }






                if (  680 < positionX && positionX < 730   && 120 < positionY  && positionY < 170 ) {

                    if ( nombreLigne  > 3) {

                        nombreLigne--;
                        chaine = chaine.valueOf(nombreLigne);
                        texteNombreL.setTexte(chaine);
                        f1.rafraichir();
                    }

                }

                if (  770< positionX && positionX < 830   && 120 < positionY  && positionY < 170 ) {

                    if ( nombreLigne < 99) {

                        nombreLigne++;
                        chaine = chaine.valueOf(nombreLigne);
                        texteNombreL.setTexte(chaine);
                        f1.rafraichir();
                    }

                }






                if (  340 < positionX && positionX < 400   && 120 < positionY  && positionY < 170 ) {

                    if ( pourcentage  > 10) {

                        pourcentage -= 5;
                        chaine = chaine.valueOf(pourcentage);
                        texteNombreP.setTexte(chaine);
                        f1.rafraichir();
                    }

                }


                if (  500< positionX && positionX < 550   && 120 < positionY  && positionY < 170 ) {

                    if ( pourcentage  < 200) {

                        pourcentage += 5;
                        chaine = chaine.valueOf(pourcentage);
                        texteNombreP.setTexte(chaine);
                        f1.rafraichir();
                    }

                }


            }




            }


            nombreARetourner = ( pourcentage * 10000) + (nombreColonne * 100) + nombreLigne;

            f1.fermer();



            return nombreARetourner;



    }


    public void lancementPartie (int nombreLigne , int nombreColonne , int taillePixel , int joueurCommence , Plateau parti ) {


        croix = new Texture[parti.tailleLargeur()][parti.tailleHauteur()];
        croixHorsJeu = new Texture[2][parti.tailleHauteur()];



        taille =  taillePixel;

        f = new Fenetre("Break Out", ( (taille*2)  + ( taille*nombreColonne) ), ( (taille*3)  + ( taille*nombreLigne) ));
        souris1 = f.getSouris();
        Rectangle couleurFond = new Rectangle( Couleur.GRIS_FONCE, new Point( 0 , 0) ,  (taille*2) + ( taille*nombreColonne) ,  (taille*3) + ( taille*nombreLigne)  , true);
        f.ajouter(couleurFond);


        Texture prisonnierRouge = new Texture("img/prisonnierRouge.png", new Point(taille*2 , taille*(nombreLigne+1) - 5), (int)(taille*(1.2)) , (int)(taille*(1.2)) );
        f.ajouter(prisonnierRouge);

        Texture prisonnierBleu = new Texture("img/prisonnierBleu.png", new Point(taille*(nombreColonne-1), taille* ( nombreLigne+1)-5), (int)(taille*(1.2)) , (int)(taille*(1.2))  );
        f.ajouter(prisonnierBleu);



        for (int i = 1 ; i <= nombreColonne ; i++ ) {


            for (int j = 1 ; j <= nombreLigne ; j++ ) {

                Carre carre = new Carre( Couleur.BLANC, new Point(     taille*i , taille*j) , taille , false);
                f.ajouter(carre);


            }

            Texture croix = new Texture("img/sortie.png", new Point(taille*i, 0), taille-2, taille-2);
            f.ajouter(croix);
        }





    }






    /*------------------ Méthode Affichage ------------------------*/

    public void affichageCroix ( int numColonne , int numLigne, int joueur, Plateau parti ) {



        if ( joueur == 1) {

             croix[numColonne-1][numLigne-1] = new Texture("img/croixBleue.png", new Point(numColonne * taille + 1, numLigne * taille + 1), taille - 2, taille - 2);
            f.ajouter(croix[numColonne-1][numLigne-1]);
        }


        else  {

            croix[numColonne-1][numLigne-1] = new Texture("img/croixRouge.png", new Point(numColonne * taille + 1, numLigne * taille + 1), taille - 2, taille - 2);
            f.ajouter(croix[numColonne-1][numLigne-1]);
        }

    }

    public void affichageCroixHorsJeu ( int numLigne , boolean coteGauche , int joueur , Plateau parti) {


        int position = ( parti.tailleLargeur() +1 ) * taille;


        if (coteGauche) {


            if (joueur == 1) {
                croixHorsJeu[0][numLigne-1] = new Texture("img/croixBleue.png", new Point(0, numLigne * taille + 1), taille - 2, taille - 2);
                f.ajouter(croixHorsJeu[0][numLigne-1]);
            }

            else {
                croixHorsJeu[0][numLigne-1] = new Texture("img/croixRouge.png", new Point(0, numLigne * taille + 1), taille - 2, taille - 2);
                f.ajouter(croixHorsJeu[0][numLigne-1]);
            }

        }


        else {

            if (joueur == 1) {
                croixHorsJeu[0][numLigne-1] = new Texture("img/croixBleue.png", new Point((parti.tailleLargeur()+1 ) * taille + 1, numLigne * taille + 1), taille - 2, taille - 2);
                f.ajouter(croixHorsJeu[0][numLigne-1]);
            }

            else {
                croixHorsJeu[0][numLigne-1] = new Texture("img/croixRouge.png", new Point( (parti.tailleLargeur()+1) * taille + 1, numLigne * taille + 1), taille - 2, taille - 2);
                f.ajouter(croixHorsJeu[0][numLigne-1]);
            }

        }

    }


    public void refreshCroix ( int numColonne, int numLigne ,  Plateau parti) {

        for ( int i=0 ; i< numLigne ; i++) {

            for (int j=0 ; j<numColonne ; j++) {



                if ( parti.getXY(j, i).getContenu() == 1) {

                    affichageCroix( j+1, i+1 , 1 , parti);

                }

                else if ( parti.getXY(j,i ).getContenu() == 2) {

                    affichageCroix(j+1 , i+1 , 2 , parti);

                }



            }

        }
    }






    public void effaceCroix (Plateau parti, boolean effaceCroixDansJeu , boolean effaceCroixHorsJeu) {


        if (effaceCroixDansJeu){

            for (int i = 0; i < parti.tailleLargeur() - 1; i++) {

                for (int j = 0; j < parti.tailleHauteur()-1; j++) {

                    f.supprimer(croix[i][j]);

                }
            }

        }


        if (effaceCroixHorsJeu){

            for ( int i = 0 ; i<2; i++) {

                for (int j=0 ; j< parti.tailleHauteur() ; j++) {

                    f.supprimer(croixHorsJeu[i][j]);

                }
            }


        }


    }




    public void Souris(int nbLigne , int nbColonne , int numJoueur  ,Plateau parti) {


        Point positionSouris = new Point (0,0);
        int positionX = 0;
        int positionY = 0;

        int temp = 0;

        int i = 0;

        boolean continuer = false;
        boolean clicGauche = false;








        while (!continuer) {


            try {
                Thread.sleep(100);
            } catch(Exception e) {}


            continuer = souris1.getClicGauche();
            positionSouris = souris1.getPosition();
            positionX = positionSouris.getX();
            positionY = positionSouris.getY();


            if ( positionX > 0 && positionX < taille  && positionY > taille && positionY < ( (taille)*nbLigne+taille)) {

                temp = positionY / taille;


               this.effaceCroix(parti, false , true);
               this.affichageCroixHorsJeu(temp,true,numJoueur, parti);

               if (continuer){
                   parti.ajoutPion( temp - 1 , nbColonne, numJoueur, true);
                   effaceCroix(parti, false , true);
               }
                i++;
            }


            else if ( positionX > (nbColonne*taille + taille) && positionX < ((taille*2)+(nbColonne*taille))  && positionY > taille && positionY < ( (taille)*nbLigne+taille)) {

                temp = positionY / taille;


                this.effaceCroix(parti, false, true);
                this.affichageCroixHorsJeu(temp,false,numJoueur, parti);

                if (continuer){
                    parti.ajoutPion( temp - 1, nbColonne , numJoueur, false);
                    effaceCroix(parti, false , true);
                }

                i++;
            }




        }



    }



    }



