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
public class ArbreBinaire {

    public enum Position {
        GAUCHE,
        DROITE
    }

    protected NoeudArbreBinaire racine;

    /**
     * Crée un arbre binaire vide
     */
    public ArbreBinaire() {
        racine = null;
    }

    /**
     * Permet d'obtenir la racine de cet arbre
     *
     * @return la racine de cet arbre
     */
    public NoeudArbreBinaire getRacine() {
        return racine;
    }

    /**
     * Permet de verifier si l'arbre est vide ou non
     *
     * @return true si l'arbre est vide et false sinon
     */
    public boolean estVide() {
        boolean resultat;
        if (this.racine == null) {
            resultat = true;
        } else {
            resultat = false;
        }
        return resultat;
    }

    /**
     * Permet d'obtenir le sous-arbre gauche de cet arbre
     *
     * @return le sous-arbre gauche de cet arbre
     */
    public ArbreBinaire sousArbreGauche() {
        ArbreBinaire sag = null; // création d'une variable pour contenir le sous-arbre gauche
        if (this.estVide() == false) { // si cet arbre n'est pas vide, alors il possède un sous-arbre gauche
            sag = new ArbreBinaire();
            sag.racine = this.racine.getFilsGauche(); // la racine du sous-arbre gauche est le fils gauche de la racine de cet arbre
        }
        return sag;
    }

    /**
     * Permet d'obtenir le sous-arbre droit de cet arbre
     *
     * @return le sous-arbre droit de cet arbre
     */
    public ArbreBinaire sousArbreDroit() {
        ArbreBinaire sad = null; // création d'une variable pour contenir le sous-arbre droit
        if (this.estVide() == false) { // si cet arbre n'est pas vide, alors il possède un sous-arbre droit
            sad = new ArbreBinaire();
            sad.racine = this.racine.getFilsDroit(); // la racine du sous-arbre droit est le fils droit de la racine de cet arbre
        }
        return sad;
    }

    private int max(int a, int b, int c) {
        int m = Math.max(a, b); // m est le maximum entre a et b
        m = Math.max(m, c); // le maximum entre m et c

        return m;
    }

    /**
     * Permet d'obtenir le degré de cet arbre
     *
     * @return le degré de cet arbre
     */
    public int degre() {
        int d;
        if (this.estVide() == true) { // si cet arbre est vide, son degré est 0
            d = 0;
        } else {
            d = max(this.racine.degre(), this.sousArbreGauche().degre(), this.sousArbreDroit().degre()); // le maximum entre le degré de la racine, l edegré du sous-arbre gauche et le degré du sous-arbre droit
        }
        return d;
    }

    /**
     * Permet d'obtenir la taille de cet arbre (le nombre de noeuds de cet
     * arbre)
     *
     * @return la taille de cet arbre
     */
    public int taille() {
        int t;
        if (this.estVide() == true) { // si cet arbre est vide, sa taille est 0
            t = 0;
        } else {
            t = 1 + this.sousArbreGauche().taille() + this.sousArbreDroit().taille(); // 1 pour le noeud racine
        }
        return t;
    }

    /**
     * Permet d'afficher les contenus des noeuds de l'arbre dans l'ordre du
     * parcours préfixe
     */
    public void prefixe() {
        if (this.estVide() == false) { // si l'arbre n'est pas vide
            System.out.print(this.racine.getData() + " "); // affichage de la donnée du noeud racine
            this.sousArbreGauche().prefixe(); // parcours prefixe du sous-arbre gauche
            this.sousArbreDroit().prefixe(); // parcours prefixe du sous-arbre gauche
        }
    }

    /**
     * Permet d'afficher les contenus des noeuds de l'arbre dans l'ordre du
     * parcours infixe
     */
    public void infixe() {
        if (this.estVide() == false) { // si l'arbre n'est pas vide
            this.sousArbreGauche().infixe(); // parcours infixe du sous-arbre gauche
            System.out.print(this.racine.getData() + " "); // affichage de la donnée du noeud racine
            this.sousArbreDroit().infixe(); // parcours infixe du sous-arbre droit
        }
    }

    /**
     * Permet d'afficher les contenus des noeuds de l'arbre dans l'ordre du
     * parcours postfixe
     */
    public void postfixe() {
        if (this.estVide() == false) { // si l'arbre n'est pas vide
            this.sousArbreGauche().postfixe(); // parcours postfixe du sous-arbre gauche
            this.sousArbreDroit().postfixe(); // parcours postfixe du sous-arbre gauche
            System.out.print(this.racine.getData() + " "); // affichage de la donnée du noeud racine
        }
    }

    /**
     * Permet de rechercher la donnée "donnee" dans cet arbre
     *
     * @param donnee la donnée à rechercher dans l'arbre
     * @return le noeud contenant la valeur donnee ou null si la donnée
     * recherchée n'est pas trouvée dans cet arbre.
     */
    public NoeudArbreBinaire rechercher(int donnee) {
        NoeudArbreBinaire noeudRecherche;
        if (this.estVide() == true) { // si l'arbre est vide
            noeudRecherche = null;
        } else { // si l'arbre n'est pas vide
            if (this.racine.getData() == donnee) { // si la donnee contenue dans la racine est la donnée recherchée
                noeudRecherche = this.racine; // le noeud recherché est la racine
            } else { // la donnee recherchée n'est pas dans la racine
                ArbreBinaire sousArbreGauche = this.sousArbreGauche();
                noeudRecherche = sousArbreGauche.rechercher(donnee); // on recherche la donnée dans le sous-arbre gauche
                if (noeudRecherche == null) { // si la donnée n'est pas trouvée dans le sous-arbre gauche
                    ArbreBinaire sousArbreDroit = this.sousArbreDroit();
                    noeudRecherche = sousArbreDroit.rechercher(donnee); // on recherche la donnée dans le sous arbre droit
                }
            }
        }
        return noeudRecherche;
    }

    /**
     * Permet d'obtenir le noeud contenant la donnée minimale de cet arbre
     *
     * @return le noeud de cet arbre contenant la donnée minimale
     */
    public NoeudArbreBinaire minimum() {
        NoeudArbreBinaire noeudMinimum = null;

        return noeudMinimum;
    }

    /**
     * Permet d'obtenir le noeud contenant la donnée maximale de cet arbre
     *
     * @return le noeud de cet arbre contenant la donnée maximale
     */
    public NoeudArbreBinaire maximum() {
        NoeudArbreBinaire noeudMaximum = null;

        return noeudMaximum;
    }

    /**
     * Permet d'obtenir la hauteur de cet arbre
     *
     * @return la hauteur de cet arbre (le nombre de noeuds de la plus longue
     * branche de cet arbre)
     */
    public int hauteur() {
        int h;
        if (this.estVide() == true) { // si l'arbre est vide
            h = 0; // la hauteur d'un arbre vide est 0
        } else { // dans la cas contraire
            h = 1 + Math.max(this.sousArbreGauche().hauteur(), this.sousArbreDroit().hauteur()); // 1 pour la racine + le maximum entre la hauteur du sous-arbre gauche et le maximum entre le sous-arbre droit
        }
        return h;
    }

    /**
     * permet d'ajouter un nouveau noeud après un noeud spécifié de l'arbre. Le
     * noeud spécifié doit être dans l'arbre
     *
     * @param noeud le noeud après lequel on ajoute la donnée
     * @param donnee la donnée à a jouter dans l'arbre
     * @param position indique si on ajoute à gauche du noeud ou à droite du
     * noeud
     */
    public void ajouterApresNoeud(NoeudArbreBinaire noeud, int donnee, Position position) {
        NoeudArbreBinaire nouveauNoeud = new NoeudArbreBinaire(donnee); // création d'un nouveau noeud
        if (position == Position.GAUCHE) {
            noeud.setFilsGauche(nouveauNoeud); // ajout du nouveau noeud à gauche
        } else {
            noeud.setFilsDroit(nouveauNoeud); // ajout du nouveau noeud à droite
        }
        nouveauNoeud.setParent(noeud); // le parent du nouveau noeud
    }
}
