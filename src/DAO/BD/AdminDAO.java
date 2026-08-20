package DAO.BD;

import models.Livre;
import models.Utilisateur;
import repositories.InterfaceAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements InterfaceAdmin {

    private Connection c;
    public AdminDAO(){
        c = DB_Connexion.getConnection();
    }

    @Override
    public void ajouterUtils(Utilisateur u) {
        String sql = "INSERT INTO utilisateur(idU,nom,prenom,email,mdp,role)" + " VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,u.getIdU());
            ps.setString(2,u.getNom());
            ps.setString(3,u.getPrenom());
            ps.setString(4,u.getEmail());
            ps.setString(5,u.getMdp());
            ps.setString(6,u.getRole());

            ps.executeUpdate();
            System.out.println("Ajout réussi");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> afficherUtilisateurs() {

        List<Utilisateur> listUtilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                listUtilisateurs.add(
                        new Utilisateur(
                                rs.getInt("idU"),
                                rs.getString("nom"),
                                rs.getString("prenom"),
                                rs.getString("email"),
                                rs.getString("mdp"),
                                rs.getString("role")
                        )
                );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listUtilisateurs;
    }

    @Override
    public Utilisateur rechercherUtils(int id) {
        String sql = "SELECT * FROM utilisateur WHERE idU=?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
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

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void ajouterLivre(Livre l) {
        String sql = "INSERT INTO livre (idL,titre,auteur,anPub,disponible)" + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,l.getIdL());
            ps.setString(2,l.getTitre());
            ps.setString(3,l.getAuteur());
            ps.setInt(4,l.getAnPub());
            ps.setString(5,l.getDisponible());

            ps.executeUpdate();
            System.out.println("Ajout livre réussie");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Livre> listerLivre() {
        List<Livre> livreList = new ArrayList<>();
        String sql = "SELECT * FROM livre";

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                livreList.add(
                        new Livre(
                                rs.getInt("idL"),
                                rs.getString("titre"),
                                rs.getString("auteur"),
                                rs.getInt("anPub"),
                                rs.getString("disponible")
                        )
                );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return livreList;
    }

}
