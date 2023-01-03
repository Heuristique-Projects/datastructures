/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Admin
 */
public class Main {

    private static void exempleUtilisationListe() {
        Liste maListe = new Liste(); // création d'une liste vide
        System.out.println("Premier affichage : la liste est vide");
        maListe.afficherIterative();// affichage itératif de la liste
        maListe.afficherRecursive();// affichage récursif de la liste

        maListe.ajouterTete(1); // ajout de la donnee 1 en tête
        System.out.println("Deuxième affichage : la liste contient l'élément 1");
        maListe.afficherRecursive();// affichage récursif de la liste

        // Ajout des éléments 2, 3, 4, 5, 6 en queue de la liste
        for (int i = 2; i <= 6; i++) {
            maListe.ajouterQueue(i);
        }
        System.out.println("Troisième affichage : la liste contient les éléments 1, 2, 3, 4, 5, 6");
        maListe.afficherRecursive();// affichage récursif de la liste

        maListe.ajouterPosition(0, 1); // ajout de la donnée 0 en position 1
        System.out.println("Quatrième affichage : la liste contient les éléments 0, 1, 2, 3, 4, 5, 6");
        maListe.afficherIterative();// affichage itératif de la liste

        System.out.println("Cinquième affichage : affichage de la taille de la liste");
        System.out.println("Taille (calcul récursif) = " + maListe.tailleIterative());
        System.out.println("Taille (calcul itératif) = " + maListe.tailleRecursive());

        // Suppression de maListe'élément en tête de liste
        maListe.supprimerTete();
        System.out.println("Sixième affichage : la liste contient les éléments 1, 2, 3, 4, 5, 6");
        maListe.afficherIterative();// affichage itératif de la liste

        // Suppression de maListe'élément en queue de liste de façon itérative
        maListe.supprimerQueueIterative();
        System.out.println("Sixième affichage : la liste contient les éléments 1, 2, 3, 4, 5");
        maListe.afficherIterative();// affichage itératif de la liste

        // Suppression de maListe'élément en queue de liste de façon récursive
        maListe.supprimerQueueIterative();
        System.out.println("Septième affichage : la liste contient les éléments 1, 2, 3, 4");
        maListe.afficherIterative();// affichage itératif de la liste
    }

    private static void exempleUtilisationArbreBinaireRecherche() {
        // Création d'un arbre binaire vide
        ArbreBinaireRecherche monArbreBinaire = new ArbreBinaireRecherche(); // création d'une liste vide
        System.out.println("Premier affichage : "
                + (monArbreBinaire.estVide() == true ? "L'arbre est vide" : "L'arbre contient " + monArbreBinaire.taille() + " éléments"));
        monArbreBinaire.infixe();// affichage infixe de l'arbre

        System.out.println("Deuxième affichage");
        System.out.println("Degré de l'arbre : " + monArbreBinaire.degre());
        System.out.println("Taille de l'arbre : " + monArbreBinaire.taille());

        // Insertion de la donnée 1 dans l'arbre binaire de recherche
        monArbreBinaire.inserer(1);
        System.out.println("Troixième affichage.\nL'arbre contient la donnée : ");
        monArbreBinaire.infixe();// affichage infixe de l'arbre
        System.out.println();
        System.out.println((monArbreBinaire.estVide() == true ? "L'arbre est vide" : "L'arbre contient " + monArbreBinaire.taille() + " élément(s)"));

        // Insertion des données 0, 4, 8, 3, 7 (dans cet ordre) dans l'arbre binaire de recherche
        monArbreBinaire.inserer(0);
        monArbreBinaire.inserer(4);
        monArbreBinaire.inserer(8);
        monArbreBinaire.inserer(3);
        monArbreBinaire.inserer(7);
        System.out.println("Troisième affichage : l'arbre contient les données 0, 1, 3, 4, 7, 8");
        monArbreBinaire.infixe();// affichage infixe de l'arbre
        System.out.println();
        System.out.println((monArbreBinaire.estVide() == true ? "L'arbre est vide" : "L'arbre contient " + monArbreBinaire.taille() + " élément(s)"));

        // Détermination du minimum et du maximum de l'arbre
        System.out.println("Le minimum est : " + monArbreBinaire.minimum().getData());
        System.out.println("Le maximum est : " + monArbreBinaire.maximum().getData());

        // Recherche des éléments 0, 1, 2, 5 dans l'arbre
        int[] mesElements = new int[]{0, 1, 2, 5};
        for (int i : mesElements) {
            NoeudArbreBinaire noeud = monArbreBinaire.rechercher(i);
            String messageAAfficher = noeud == null ? "La donnée " + i + " n'est pas contenue dans l'arbre" : "La donnée " + i + " est contenue dans l'arbre, dans le noeud d'adresse " + noeud;
            System.out.println(messageAAfficher);
        }

        // Détermination de la hauteur de l'arbre
        System.out.println("La hauteur de l'arbre est " + monArbreBinaire.hauteur());

        // Détermination du sucesseur de 0
        NoeudArbreBinaire noeudActuel = monArbreBinaire.rechercher(0);
        while (noeudActuel != null) {
            NoeudArbreBinaire noeudSuccesseur = monArbreBinaire.successeur(noeudActuel);
            String messageAAfficher = noeudSuccesseur != null ? "Le successeur de " + noeudActuel.getData() + " dans l'arbre est " + noeudSuccesseur.getData() : "La donnée " + noeudActuel.getData() + " n'a pas de successeur dans l'arbre";
            System.out.println(messageAAfficher);
            noeudActuel = noeudSuccesseur;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Pour utiliser le code, il suffit de décommenter le code d'une méthode et de mettre le code de l'autre en commentaire */

        // exempleUtilisationListe();
        exempleUtilisationArbreBinaireRecherche();
    }

}
