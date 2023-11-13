package back;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Movies {

    public static @NotNull ArrayList<HashMap> allMovies(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<HashMap> movies = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            stmt = conn.createStatement();
            String sqlQuerry = "SELECT m.id, m.nom,releaseDate,g.nom AS genre FROM movies m JOIN genres g ON m.genres_id = g.id";
            rs = stmt.executeQuery(sqlQuerry);

            while(rs.next()){
                System.out.println("---------------------------------------------------");

                String id = rs.getString("id");
                String nameMovie = rs.getString("nom");
                String year = rs.getString("releaseDate");
                String genre = rs.getString("genres");
                HashMap movie = new HashMap();
                movie.put("id", id);
                movie.put("nameMovie", nameMovie);
                movie.put("year", year);
                movie.put("genre", genre);
                movies.add(movie);

                System.out.println("---------------------------------------------------");
            }
        }catch (SQLException ex){
            System.out.println("SQLExeption" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
        return movies;
    }

    public static void AddMovie(String nom, String year, int IdGenre){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "INSERT INTO movies (nom, releaseDate, genres_id) VALUES(?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, year);
            stmt.setString(3, String.valueOf(IdGenre));
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public static void deleteById(String _id){
        int id = Integer.parseInt(_id);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "", "");
            String sql = "DELETE FROM movies WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<HashMap> selectWhereName(String name){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList movies = new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "", "");
            String sql = "SELECT m.id, m.nom,releaseDate,g.nom AS genre FROM movies m JOIN genres g ON m.genres_id = g.id WHERE m.nom = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery(sql);


            while(rs.next()){
                System.out.println("------------------------------------------------------------");

                System.out.println("");
                String id = rs.getString("id");
                String nameMovie = rs.getString("nom");
                String year = rs.getString("releaseDate");
                String genre = rs.getString("genres");
                HashMap movie = new HashMap();
                movie.put("id", id);
                movie.put("nameMovie", nameMovie);
                movie.put("year", year);
                movie.put("genre", genre);
                movies.add(movie);

                System.out.println("------------------------------------------------------------");

            }

            return movies;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<HashMap> selectBetwenDate(int beginDate, int endDate) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<HashMap> movies = new ArrayList<>();
        System.out.println(beginDate);
        System.out.println(endDate);

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "SELECT m.id, m.nom, releaseDate, g.nom AS genre FROM movies m JOIN genres g ON m.genres_id = g.id WHERE m.realiseDate BETWEEN ? AND ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf((beginDate)));
            stmt.setString(2, String.valueOf(endDate));

            while(rs.next()){
                System.out.println("------------------------------------------------------------");

                String id = rs.getString("id");
                String nameMovie = rs.getString("nom");
                String year = rs.getString("releaseDate");
                String genre = rs.getString("genres");
                HashMap movie = new HashMap();
                movie.put("id", id);
                movie.put("nameMovie", nameMovie);
                movie.put("year", year);
                movie.put("genre", genre);
                movies.add(movie);



                System.out.println("------------------------------------------------------------");

            }

            return movies;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<HashMap> selectByGenre(String genderMovies){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<HashMap> movies = new ArrayList<>();
        System.out.println(genderMovies);


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "SELECT m.id, m.nom, releaseDate, g.nom AS genre FROM movies m JOIN genres g ON m.genres_id = g.id WHERE g.nom = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, genderMovies);
            rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("------------------------------------------------------------");

                String id = rs.getString("id");
                String nameMovie = rs.getString("nom");
                String year = rs.getString("releaseDate");
                String genre = rs.getString("genres");
                HashMap movie = new HashMap();
                movie.put("id", id);
                movie.put("nameMovie", nameMovie);
                movie.put("year", year);
                movie.put("genre", genre);
                movies.add(movie);



                System.out.println("------------------------------------------------------------");

            }

            return movies;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<HashMap> selectByGenreBetweenDate(int BeginDate, int EndDate, String genderMovies){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<HashMap> movies = new ArrayList<>();
        System.out.println(BeginDate);
        System.out.println(EndDate);


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "SELECT m.id, m.nom, releaseDate, g.nom AS genre FROM movies m JOIN genres g ON m.genres_id = g.id WHERE g.nom = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(BeginDate));
            stmt.setString(1, String.valueOf(EndDate));
            rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("------------------------------------------------------------");

                String id = rs.getString("id");
                String nameMovie = rs.getString("nom");
                String year = rs.getString("releaseDate");
                String genre = rs.getString("genres");
                HashMap movie = new HashMap();
                movie.put("id", id);
                movie.put("nameMovie", nameMovie);
                movie.put("year", year);
                movie.put("genre", genre);
                movies.add(movie);



                System.out.println("------------------------------------------------------------");

            }

            return movies;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static void updateMovie(String id, String nom, @NotNull String date, int genre){
        id = String.valueOf(Integer.parseInt(id));
        Connection conn = null;
        PreparedStatement stmt = null;

        genre = Genres.getIdOfGenre(String.valueOf(genre));
        System.out.println(genre);
        String newDate =  date.substring(0,4);
        System.out.println(newDate);
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appmoovies", "root", "");
            String sql = "UPDATE movies SET nom = ?, releaseDate = ?, genres_id = ? WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, newDate);
            stmt.setString(3, String.valueOf(genre));
            stmt.setString(4, id);
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
