package DAO.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connexion {

    public static Connection getConnection(){
        String URL ="jdbc:mysql://localhost:3306/devoir1";
        String Username="root";
        String password="";
        Connection connect=null;
        try{
            connect= DriverManager.getConnection(URL,Username,password);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return connect;
    }

}
