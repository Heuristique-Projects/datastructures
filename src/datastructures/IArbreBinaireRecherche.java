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
public interface IArbreBinaireRecherche {

    /**
     * Permet de retrouver le noeud de cet arbre contenant la plus grande donnée
     * inférieure à celle du noeud passé en paramètre
     *
     * @param noeud le noeud dont on veut trouver le prédécesseur
     * @return le prédécesseur du noeud de cet arbre passé en paramètre
     */
    NoeudArbreBinaire predecesseur(NoeudArbreBinaire noeud);

    /**
     * Permet de retrouver le noeud de cet arbre contenant la plus petite donnée
     * supérieure à celle du noeud passé en paramètre
     *
     * @param noeud le noeud dont on veut trouver le sucesseur
     * @return le sucesseur du noeud de cet arbre passé en paramètre
     */
    NoeudArbreBinaire successeur(NoeudArbreBinaire noeud);

    /**
     * Permet d'insérer une nouvelle donnée dans cet arbre tout en préservant la
     * propriété d'arbre binaire de recherche
     *
     * @param donnee la donnee à insérer dans cet arbre
     */
    void inserer(int donnee);

    /**
     * permet de supprimer un noeud de cet arbre
     *
     * @param noeud le noeud à supprimer de cet arbre
     */
    void supprimer(NoeudArbreBinaire noeud);

}
