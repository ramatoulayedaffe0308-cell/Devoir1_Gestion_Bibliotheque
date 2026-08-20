package DAO.BD;
import models.Utilisateur;

public class Session {

    private Utilisateur utilisateurConnecte;

    public void connecter(Utilisateur utilisateur) {
        this.utilisateurConnecte = utilisateur;
    }

    public void deconnecter() {
        this.utilisateurConnecte = null;
    }

    public boolean estConnecte() {
        return utilisateurConnecte != null;
    }

    public Utilisateur getUtilisateurConnecte() {
        return utilisateurConnecte;
    }

    public String getRole() {
        if (utilisateurConnecte == null) {
            return null;
        }
        return utilisateurConnecte.getRole();
    }

}