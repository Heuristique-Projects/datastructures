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
public class Liste {

    private NoeudListe tete;

    /**
     * Crée une liste vide
     */
    public Liste() {
        tete = null;
    }

    /**
     * Permet d'obtenir la tete de cette liste
     *
     * @return la tete de cette liste
     */
    public NoeudListe getTete() {
        return tete;
    }

    /**
     * Permet d'obtenir la liste qui suit la tete de cette listes
     *
     * @return la liste qui suit le premier noeud de cette liste
     */
    public Liste listeSuivante() {
        Liste l = null; // création d'une variable pour contenir la liste suivante
        if (this.estVide() == false) { // si cette liste n'est pas vide, alors elle possède une liste suivante
            l = new Liste();
            l.tete = this.tete.getSuivant(); // la tete de la liste suivante est le noeud qui suit le premier noeud de cette liste
        }
        return l;
    }

    /**
     * Permet de verifier si la liste est vide ou non
     *
     * @return true si la liste est vide et false sinon
     */
    public boolean estVide() {
        boolean resultat;
        if (this.tete == null) {
            resultat = true;
        } else {
            resultat = false;
        }
        return resultat;
    }

    /**
     * Permet d'obtenir la taille de cette liste de façon récursive
     *
     * @return la taille de cette liste
     */
    public int tailleRecursive() {
        int t;
        if (this.estVide() == true) {
            t = 0;
        } else {
            Liste listeSuivante = this.listeSuivante(); // obtention de la liste suivante du premier noeud

            t = 1 + listeSuivante.tailleRecursive(); // appel récursif sur la liste suivante
        }
        return t;
    }

    /**
     * Permet d'obtenir la taille de cette liste de façon itérative
     *
     * @return la taille de cette liste
     */
    public int tailleIterative() {
        NoeudListe tmp = tete; // au départ, notre pointeur pointe sur le premier noeud
        int t = 0;
        while (tmp != null) {
            tmp = tmp.getSuivant(); // se deplacer vers le noeud suivant
            t++;
        }
        return t;
    }

    /**
     * Permet d'ajouter un nouveau noeud portant la donnee "donnee" a la tete de
     * la liste
     *
     * @param donnee
     */
    public void ajouterTete(int donnee) {
        NoeudListe nouveauNoeud = new NoeudListe(donnee);

        nouveauNoeud.setSuivant(this.tete); // la liste devient la suite du nouveau noeud
        this.tete = nouveauNoeud; // la nouveau noeud devient la tete de la liste
    }

    /**
     * Permet d'ajouter une donnée à la fin de la liste
     *
     * @param donnee la donnée à ajouter dans la liste
     */
    public void ajouterQueue(int donnee) {
        if (this.estVide() == true) { // Si la liste est vide, alors l'ajout en queue revient à l'ajout en tête, car le noeud ajouté à la liste se retrouve en tête de liste
            this.ajouterTete(donnee);
        } else {
            NoeudListe nouveauNoeud = new NoeudListe(donnee); // création du nouveau noeud contenant la donnée ajoutée à la liste
            //recherche de l'actuel dernier noeud
            NoeudListe tmp = this.tete;
            while (tmp.getSuivant() != null) {
                tmp = tmp.getSuivant();
            }
            tmp.setSuivant(nouveauNoeud); // ajout du nouveau noeud à la suite du dernier noeud
        }
    }

    /**
     * Permet d'ajouter une donnee à une position de la liste
     *
     * @param donnee la donnée à ajouter dans la liste
     * @param position la position à laquelle la donnée doit être ajoutée dans
     * la liste
     */
    public void ajouterPosition(int donnee, int position) {
        if (position == 1 || this.estVide() == true) { // Si l'ajout se fait à la position 1 ou la liste est vide, alors l'ajout se fait en tête, car le noeud ajouté à la liste se retrouve en tête de liste
            this.ajouterTete(donnee);
        } else {
            NoeudListe nouveauNoeud = new NoeudListe(donnee); // création du nouveau noeud contenant la donnée ajoutée à la liste
            //recherche du noeud numéro i - 1 de la liste
            NoeudListe tmp = this.tete;
            for (int i = 2; i <= position - 1; i++) {
                tmp = tmp.getSuivant();
            }
            nouveauNoeud.setSuivant(tmp.getSuivant()); // ajout du noeud i à la suite du nouveau noeud
            tmp.setSuivant(nouveauNoeud); // ajout du nouveau noeud à la suite noeud i
        }
    }

    /**
     * Permet d'afficher les éléments de cette liste de façon récursive
     */
    public void afficherRecursive() {
        if (this.estVide() == true) {
            System.out.println("NULL");
        } else {
            Liste listeSuivante = this.listeSuivante(); // obtention de la liste suivante du premier noeud
            System.out.print(this.tete.getData() + " -> "); // affichage de la valeur du noeud en tete de la liste
            listeSuivante.afficherRecursive(); // appel recursif sur la liste suivante
        }
    }

    /**
     * Permet d'afficher les éléments de cette liste de façon itérative
     */
    public void afficherIterative() {
        NoeudListe tmp = this.tete;
        while (tmp != null) {
            System.out.print(tmp.getData() + " -> "); // affichage de la donne contenue dans le noeud
            tmp = tmp.getSuivant();
        }
        System.out.println("NULL");
    }

    /**
     * Permet de supprimer la donnee en tete de la liste. la liste doit etre non
     * vide.
     */
    public void supprimerTete() {
        NoeudListe deuxiemeNoeud = this.tete.getSuivant();
        this.tete = deuxiemeNoeud;
    }

    /**
     * Permet de supprimer la donne à la fin de la liste de manière récursive
     */
    public void supprimerQueueRecursive() {
        if (this.tete.getSuivant() == null) { // si la liste possède un seul élément, alors la liste se vide
            this.tete = null;
        } else { // sinon
            Liste listeSuivante = this.listeSuivante(); // obtention de la liste suivante du premier noeud
            listeSuivante.supprimerQueueRecursive(); // appel recursif sur la liste suivante
        }
    }

    /**
     * Permet de supprimer la donne à la fin de la liste de manière itérative
     */
    public void supprimerQueueIterative() {
        if (this.tete.getSuivant() == null) { // si la liste possède un seul élément, alors la liste se vide
            this.tete = null;
        } else { // sinon
            // on recherche l'avant dernier élément
            NoeudListe avantDernierNoeud = this.tete;
            NoeudListe dernierNoeud = avantDernierNoeud.getSuivant();
            while (dernierNoeud.getSuivant() != null) { // tant que le dernier noeud n'a pas été trouvé
                avantDernierNoeud = dernierNoeud; // le dernier noeud devient l'avant dernier noeud
                dernierNoeud = dernierNoeud.getSuivant(); // le suivant du dernier noeud devient le dernier noeud
            }
            avantDernierNoeud.setSuivant(null); // l'avant dernier noeud devient le dernier noeud de la liste
        }
    }
}
