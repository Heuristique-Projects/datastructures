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
public class NoeudArbreBinaire {

    private int data;
    private NoeudArbreBinaire filsGauche;
    private NoeudArbreBinaire filsDroit;
    private NoeudArbreBinaire parent;

    /**
     * Constructeur : pour creer un nouveau noeud. Il s'agit de l'équivalent de
     * l'operation
     *
     * @param data la donnée que va contenir le noeud créé
     */
    public NoeudArbreBinaire(int data) {
        this.data = data;
        this.filsGauche = null; // A la création, il n'y a pas de fils gauche
        this.filsDroit = null; // A la création, il n'y a pas de fils droit
        this.parent = null;
    }

    /**
     * Permet d'obtenir la valeur de la donnée contenue dans le neoud
     *
     * @return la donnée contenue dans le noeud
     */
    public int getData() {
        return data;
    }

    /**
     * Permet de modifier la valeur de la donnée contenue dans le noeud
     *
     * @param data la nouvelle valeur que va contenir le noeud
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Permet d'obtenir le fils gauche après ce noeud
     *
     * @return l'adresse du fils gauche de ce noeud
     */
    public NoeudArbreBinaire getFilsGauche() {
        return filsGauche;
    }

    /**
     * Permet de renseigner le fils gauche de ce noeud
     *
     * @param filsGauche le noeud qui sera le fils gauche de ce noeud
     */
    public void setFilsGauche(NoeudArbreBinaire filsGauche) {
        this.filsGauche = filsGauche;
    }

    /**
     * Permet d'obtenir le fils droit après ce noeud
     *
     * @return l'adresse du fils droit de ce noeud
     */
    public NoeudArbreBinaire getFilsDroit() {
        return filsDroit;
    }

    /**
     * Permet de renseigner le fils droit de ce noeud
     *
     * @param filsDroit le noeud qui sera le fils droit de ce noeud
     */
    public void setFilsDroit(NoeudArbreBinaire filsDroit) {
        this.filsDroit = filsDroit;
    }

    /**
     * Permet d'obtenir le noeud parent de ce noeud
     *
     * @return l'adresse du noeud parent de ce noeud
     */
    public NoeudArbreBinaire getParent() {
        return parent;
    }

    /**
     * Permet de renseigner le noeud parent de ce noeud
     *
     * @param parent le noeud qui sera le noeud parent de ce noeud
     */
    public void setParent(NoeudArbreBinaire parent) {
        this.parent = parent;
    }

    /**
     * Permet d'obtenir le degré de ce noeud
     *
     * @return le degre de ce noeud
     */
    public int degre() {
        int d = 0;
        if (this.filsGauche == null) {
            d = d + 1;
        }
        if (this.filsDroit == null) {
            d = d + 1;
        }
        return d;
    }

    /**
     * Permet de dire si un noeud est une feuille ou non
     *
     * @return true si ce noeud est une feuille et false sinon
     */
    public boolean estFeuille() {
        boolean resultat;
        if (this.degre() == 0) {
            resultat = true;
        } else {
            resultat = false;
        }
        return resultat;
    }
}
