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
public class NoeudListe {

    private int data;
    private NoeudListe suivant;

    /**
     * Constructeur : pour creer un nouveau noeud. Il s'agit de l'équivalent de
     * l'operation
     *
     * @param data la donnée que va contenir le noeud créé
     */
    public NoeudListe(int data) {
        this.data = data;
        this.suivant = null; // A la création, il n'y a pas de noeud après le noeud créé
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
     * Permet d'obtenir le noeud après ce noeud
     *
     * @return l'adresse du noeud suivant ce noeud
     */
    public NoeudListe getSuivant() {
        return suivant;
    }

    /**
     * Permet de renseigner le noeud suivant de ce noeud
     *
     * @param suivant le noeud qui sera le noeud suivant de ce noeud
     */
    public void setSuivant(NoeudListe suivant) {
        this.suivant = suivant;
    }

}
