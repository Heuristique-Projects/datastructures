package datastructures;

/**
 *
 * @author Beril EKWELLE @HEURISTIQUE
 */
public class ArbreBinaireRecherche extends ArbreBinaire implements IArbreBinaireRecherche {

    public ArbreBinaireRecherche() {
        super();
    }

    @Override
    public NoeudArbreBinaire rechercher(int donnee) {
        NoeudArbreBinaire noeudRecherche;
        if (this.estVide() == true) { // si l'arbre est vide
            noeudRecherche = null;
        } else { // si l'arbre n'est pas vide
            if (this.racine.getData() == donnee) { // si la donnee contenue dans la racine est la donnée recherchée
                noeudRecherche = racine; // le noeud recherché est la racine
            } else if (donnee < racine.getData()) { // la donnée recherchée est inférieure à celle contenue dans la racine
                ArbreBinaire sousArbreGauche = this.sousArbreGauche();
                noeudRecherche = sousArbreGauche.rechercher(donnee); // on recherche la donnée dans le sous-arbre gauche
            } else { // la donnée recherchée est supérieure à celle contenue dans la racine
                ArbreBinaire sousArbreDroit = this.sousArbreDroit();
                noeudRecherche = sousArbreDroit.rechercher(donnee); // on recherche la donnée dans le sous arbre droit
            }
        }
        return noeudRecherche;
    }

    @Override
    public NoeudArbreBinaire minimum() {
        NoeudArbreBinaire noeudMinimum;
        if (this.estVide() == true) { // si l'arbre est vide
            noeudMinimum = null;
        } else { // sinon
            noeudMinimum = this.racine;
            // on parcourt l'arbre pour trouver le dernier noeud ne possédant pas de fils gauche
            while (noeudMinimum.getFilsGauche() != null) {
                noeudMinimum = noeudMinimum.getFilsGauche();
            }
        }
        return noeudMinimum;
    }

    @Override
    public NoeudArbreBinaire maximum() {
        NoeudArbreBinaire noeudMaximum;
        if (this.estVide() == true) { // si l'arbre est vide
            noeudMaximum = null;
        } else { // sinon
            noeudMaximum = this.racine;
            // on parcourt l'arbre pour trouver le dernier noeud ne possédant pas de fils droit
            while (noeudMaximum.getFilsDroit() != null) {
                noeudMaximum = noeudMaximum.getFilsDroit();
            }
        }
        return noeudMaximum;
    }

    @Override
    public NoeudArbreBinaire predecesseur(NoeudArbreBinaire noeud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NoeudArbreBinaire successeur(NoeudArbreBinaire noeud) {
        NoeudArbreBinaire noeudSuivant;
        if (noeud.getFilsDroit() != null) {
            noeudSuivant = this.sousArbreDroit().minimum();
        } else {
            NoeudArbreBinaire noeudTemporaire = noeud;
            noeudSuivant = noeud.getParent();

            while (noeudSuivant != null && noeudSuivant.getFilsDroit() == noeudSuivant) {
                noeudSuivant = noeud.getParent();
            }
        }
        return noeudSuivant;
    }

    @Override
    public void inserer(int donnee) {
        NoeudArbreBinaire nouveauNoeud = new NoeudArbreBinaire(donnee); // Création d'un nouveau noeud contenant la donnée à ajouter dans cet arbre

        NoeudArbreBinaire noeudParent = null;
        NoeudArbreBinaire noeudTemporaire = this.racine;

        // recherche du noeud parent de la donnée à insérer dans cet arbre
        while (noeudTemporaire != null) {
            noeudParent = noeudTemporaire;
            if (noeudTemporaire.getData() > donnee) {
                noeudTemporaire = noeudTemporaire.getFilsGauche();
            } else {
                noeudTemporaire = noeudTemporaire.getFilsDroit();
            }
        }
        nouveauNoeud.setParent(noeudParent); // le nouveau noeud a pour parent le noeud parent

        if (noeudParent == null) { // si le parent du noeud à insérer est la racine, alors ce noeud devient la racine de l'arbre
            this.racine = nouveauNoeud;
        } else {
            if (noeudParent.getData() > donnee) { // la donnée à insérer est inférieure à celle contenue dans le parent
                noeudParent.setFilsGauche(nouveauNoeud); // insertion à gauche du parent
            } else { // la donnée à insérer est supérieure à celle contenue dans le parent
                noeudParent.setFilsDroit(nouveauNoeud); // insertion à droite du paren
            }
        }
    }

    @Override
    public void supprimer(NoeudArbreBinaire noeud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
