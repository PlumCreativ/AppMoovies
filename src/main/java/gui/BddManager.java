package gui;

import java.sql.*;

public class BddManager {
    public static void Truncate(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies/", "root", "");
            String sql = "TRUNCATE TABLE 'movies', 'genres'";
            stmt = conn.createStatement();
            stmt.executeQuery(sql);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
