package models;

public class Emprunt {

    private int idEmp;
    private int idL;
    private String status;
    private String dateEmp;
    private String dateRetourPrev;
    private String dateRetourFin;
    private String nomComplet;

    public Emprunt(int idEmp, int idL, String status,
                   String dateEmp, String dateRetourPrev,
                   String dateRetourFin, String nomComplet) {

        this.idEmp = idEmp;
        this.idL = idL;
        this.status = status;
        this.dateEmp = dateEmp;
        this.dateRetourPrev = dateRetourPrev;
        this.dateRetourFin = dateRetourFin;
        this.nomComplet = nomComplet;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public int getIdL() {
        return idL;
    }

    public String getStatus() {
        return status;
    }

    public String getDateEmp() {
        return dateEmp;
    }

    public String getDateRetourPrev() {
        return dateRetourPrev;
    }

    public String getDateRetourFin() {
        return dateRetourFin;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateEmp(String dateEmp) {
        this.dateEmp = dateEmp;
    }

    public void setDateRetourPrev(String dateRetourPrev) {
        this.dateRetourPrev = dateRetourPrev;
    }

    public void setDateRetourFin(String dateRetourFin) {
        this.dateRetourFin = dateRetourFin;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "idEmp=" + idEmp +
                ", idL=" + idL +
                ", status='" + status + '\'' +
                ", dateEmp='" + dateEmp + '\'' +
                ", dateRetourPrev='" + dateRetourPrev + '\'' +
                ", dateRetourFin='" + dateRetourFin + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                '}';
    }
}