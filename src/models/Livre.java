package models;

public class Livre {
    private int idL;
    private String titre;
    private String auteur;
    private int anPub;
    private String disponible;

    public Livre(int idL, String titre, String auteur, int anPub, String disponible) {
        this.idL = idL;
        this.titre = titre;
        this.auteur = auteur;
        this.anPub = anPub;
        this.disponible = disponible;
    }

    public int getIdL() {
        return idL;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnPub() {
        return anPub;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnPub(int anPub) {
        this.anPub = anPub;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "idL=" + idL +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anPub=" + anPub +
                ", disponible='" + disponible + '\'' +
                '}';
    }
}
