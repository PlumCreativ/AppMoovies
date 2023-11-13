package gui;

import back.Genres;
import back.Movies;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MyListPane extends JPanel {

    private JPanel searchPanel;
    private JPanel contentNorthPanel;
    private JPanel datePanel;
    private JTextField searchInput ;
    private JLabel labelNameMovie;
    private   JButton  searchButton  ;
    private JComboBox listGenre;
    private JLabel  labelGenre;
    private JLabel labelDate;
    private JTextField beginYear;
    private JLabel  betweenLabel;
    private JTextField endYear;

    private JTable moviesTable;
    private DefaultTableModel tableModel;

    public MyListPane(){

        this.searchInput = new JTextField();
        this.labelNameMovie = new JLabel("nom du film");
        this.searchButton = new JButton("recherche");

        // Definition  de la scroll-bar
        this.labelGenre = new JLabel("Selection du genre !");
        this.listGenre = new JComboBox();
        for (String genre : Genres.getAllGenres()) {
            this.listGenre.addItem(genre);
        }

        this.labelDate = new JLabel("date de sortie");
        this.beginYear = new JTextField();
        this.betweenLabel = new JLabel("entre");
        this.endYear = new JTextField();


        String[]  columns =  new String[] {
                "id", "Nom", "Date", "Genre", "Delete", "Update"
        };

        this.tableModel = new DefaultTableModel(columns, 0);

        ArrayList movies = Movies.allMovies();
        for (int i = 0; i < movies.size(); i++) {
            HashMap movie = (HashMap) movies.get(i);
            String id = (String) movie.get("id");
            String name = (String) movie.get("nameMovie");
            String year = (String) movie.get("year");
            String genre = (String) movie.get("genre");
            String delete = "Delete";
            String update = "Update";


            Object[] data = {id, name, year, genre, delete, update};
            this.tableModel.addRow(data);
        }

        this.moviesTable = new JTable(tableModel);
        TableColumn genreColumn = moviesTable.getColumnModel().getColumn(3);
        JComboBox genresForEdit = new JComboBox();
        for (String genre: Genres.getAllGenres()){
            genresForEdit.addItem(genre);
        }
        genreColumn.setCellEditor(new DefaultCellEditor(genresForEdit));

        this.moviesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1) {
                    System.out.println("click 1");
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();

                    if (column == 4) {
                        System.out.println("click 1");
                        String id = (String) tableModel.getValueAt(row, 0);
                        System.out.println(id);
                        deleteById(id);
                    }else if (column == 5){
                        String id = (String) tableModel.getValueAt(row, 0);
                        String nom = (String) tableModel.getValueAt(row, 1);
                        String date = (String) tableModel.getValueAt(row, 2);
                        String genre = (String) tableModel.getValueAt(row, 3);
                        updateByLine(id, nom, date, genre);
                    }

                }
                if (e.getButton() == 2) {
                    System.out.println("click 2");
                }
            }
        });

        this.searchPanel = new JPanel();
        this.searchPanel.setLayout( new FlowLayout());

        // line one
        this.searchPanel.add(labelNameMovie);
        this.searchPanel.add(this.searchInput);

        // line two
        this.searchPanel.add(this.labelGenre);
        this.searchPanel.add(this.listGenre);

        this.datePanel = new JPanel();
        this.datePanel.setLayout( new FlowLayout()  );

        this.datePanel.add(this.labelDate);
        this.datePanel.add(this.beginYear);
        this.datePanel.add(this.betweenLabel);
        this.datePanel.add(this.endYear);

        this.searchInput.setPreferredSize(new Dimension(120,30));
        this.searchButton.setPreferredSize(new Dimension(120,30));
        this.beginYear.setPreferredSize(new Dimension(100,30));
        this.endYear.setPreferredSize(new Dimension(100,30));
        this.listGenre.setPreferredSize(new Dimension(100,30));

        this.contentNorthPanel =  new JPanel();
        this.contentNorthPanel.setLayout(new FlowLayout());
        this.contentNorthPanel.add(this.searchPanel);
        this.contentNorthPanel.add(this.datePanel);
        this.contentNorthPanel.add(this.searchButton);


        this.setLayout(new BorderLayout() );
        this.add(this.contentNorthPanel,BorderLayout.NORTH);
        this.add( new JScrollPane(this.moviesTable),BorderLayout.CENTER);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitResearch();
            }
        });
    }

    private void submitResearch(){
        String search =  searchInput.getText();
        String genre  = listGenre.getSelectedItem().toString();
        String startYear = beginYear.getText();
        String finalYear = endYear.getText();
        if(search.isEmpty() && genre.equals("aucun") &&  startYear.isEmpty() && finalYear.isEmpty() ){
            System.out.println("selectALl");
            ArrayList movies = Movies.allMovies();
            this.updateAllMovies(movies);
        }
        else if(! search.isEmpty() ){
            System.out.println("select where name ...");
            ArrayList movies = Movies.selectWhereName(search);
            this.updateAllMovies(movies);

        }
        else if(search.isEmpty() && genre.equals("aucun") && !startYear.isEmpty()  && !finalYear.isEmpty() ){
            System.out.println("select between pas de genre");
            int sy = Integer.parseInt(startYear);
            int fy = Integer.parseInt(finalYear);
            ArrayList movies = Movies.selectBetwenDate(sy, fy);
            this.updateAllMovies(movies);

        }
        else if(search.isEmpty() && !genre.equals("aucun") && !startYear.isEmpty() && !finalYear.isEmpty()){
            System.out.println("select between genre");
            int sy = Integer.parseInt(startYear);
            int fy = Integer.parseInt(finalYear);
            ArrayList movies = Movies.selectByGenreBetweenDate(sy, fy, genre);
            this.updateAllMovies(movies);
        }
        else if(search.isEmpty() && !genre.equals("aucun")){
            System.out.println("select join genres");
            ArrayList movies = Movies.selectByGenre(genre);
            this.updateAllMovies(movies);
        }
        else{
            System.out.println("pas de recherche");
        }
    }

    public void deleteById(String id){
        Movies.deleteById(id);
    }

    public void updateByLine(String id, String nom, String date, String genre){
        System.out.println(genre);
        Movies.updateMovie(id, nom, date, Integer.parseInt(genre));
    }

    public void updateAllMovies(ArrayList m){
        this.tableModel.setRowCount(0);
        ArrayList movies = Movies.allMovies();
        for (int i = 0; i < movies.size(); i++) {
            HashMap movie = (HashMap) movies.get(i);
            String id = (String) movie.get("id");
            String name = (String) movie.get("nameMovie");
            String year = (String) movie.get("year");
            String genre = (String) movie.get("genre");
            String delete = "Delete";
            String update = "Update";


            Object[] data = {id, name, year, genre, delete, update};
            this.tableModel.addRow(data);
        }
    }
}
