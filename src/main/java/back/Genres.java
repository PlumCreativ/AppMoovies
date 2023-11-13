package back;


import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class Genres {

    public static @NotNull ArrayList<String> getAllGenres() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> genres = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            stmt = conn.createStatement();
            String selectQuery = "SELECT nom  FROM genres ";
            rs = stmt.executeQuery(selectQuery);


            int i = 0;
            // System.out.println("------------------------------------------------------------");
            while (rs.next()) {

                String name = rs.getString("nom");
                System.out.println(name);
                genres.add(name);

            }
            //  System.out.println("------------------------------------------------------------");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return genres;

    }


    public static int getIdOfGenre(String g){
        Connection conn = null;
        Statement stmt;
        ResultSet rs = null;

        int IdOfGenre = 0;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "SELECT * FROM genres WHERE nom ='" + g + "'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("-----------------------------------------------------------------------------");

                IdOfGenre = Integer.parseInt(rs.getString("id"));
                System.out.println("id du genre : " + IdOfGenre);

                System.out.println("-----------------------------------------------------------------------------");

            }


            } catch(SQLException e){
                throw new RuntimeException(e);
            }

            return IdOfGenre;

    }

    public static void addGenre(String genre){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "INSERT INTO genres (nom) VALUES(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, genre);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
