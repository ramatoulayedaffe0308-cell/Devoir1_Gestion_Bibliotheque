package DAO.BD;
import models.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthentifierDAO {

    private Connection c;
    public AuthentifierDAO() {
        c = DB_Connexion.getConnection();
    }

    public Utilisateur authentifier(String email, String password) {
        String sql = "SELECT * FROM utilisateur WHERE email = ? AND mdp = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Utilisateur(
                        rs.getInt("idU"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mdp"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}