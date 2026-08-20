package DAO.BD;

import models.Emprunt;
import models.Livre;
import repositories.InterfaceGest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireDAO  implements InterfaceGest {

    private Connection c;
    public GestionnaireDAO(){
        c = DB_Connexion.getConnection();
    }

    @Override
    public void enregisterEmp(Emprunt emp) {
        try {
            String verification = "SELECT disponible FROM livre WHERE idL = ?";
            PreparedStatement psVerification = c.prepareStatement(verification);
            psVerification.setInt(1, emp.getIdL());
            ResultSet rs = psVerification.executeQuery();

            if (!rs.next()) {
                System.out.println("Livre introuvable.");
                return;
            }String disponible = rs.getString("disponible");

            if (!"oui".equalsIgnoreCase(disponible)) {
                System.out.println("Ce livre n'est pas disponible.");
                return;
            }

            String sql =
                    "INSERT INTO emprunt " +
                            "(idEmp, idL, status, dateEmp, dateRetourPrev, dateRetourFin, nomComplet) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setInt(1, emp.getIdEmp());
                    ps.setInt(2, emp.getIdL());
                    ps.setString(3, "en cours");
                    ps.setString(4, emp.getDateEmp());
                    ps.setString(5, emp.getDateRetourPrev());
                    ps.setString(6, emp.getDateRetourFin());
                    ps.setString(7, emp.getNomComplet());

                    ps.executeUpdate();

                    String sqlLivre = "UPDATE livre SET disponible = ? WHERE idL = ?";

                    PreparedStatement psLivre = c.prepareStatement(sqlLivre);

                    psLivre.setString(1, "non");
                    psLivre.setInt(2, emp.getIdL());

                    psLivre.executeUpdate();

                    System.out.println("Emprunt enregistré avec succès.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Emprunt> afficherEmprunts() {
        List<Emprunt> ListEmp = new ArrayList<>();
        String sql = "SELECT * FROM emprunt";

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                ListEmp.add(
                        new Emprunt(
                                rs.getInt("idEmp"),
                                rs.getInt("idL"),
                                rs.getString("status"),
                                rs.getString("dateEmp"),
                                rs.getString("dateRetourPrev"),
                                rs.getString("dateRetourFin"),
                                rs.getString("nomComplet")
                        )
                );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListEmp;
    }

    @Override
    public void retournerLivre(Livre l) {
        String sql = "UPDATE livre SET disponible = ? WHERE idL = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "oui");
            ps.setInt(2, l.getIdL());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Livre retourné avec succès.");
            } else {
                System.out.println("Livre introuvable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
