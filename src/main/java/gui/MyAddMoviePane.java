package gui;

import back.Genres;
import back.Movies;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyAddMoviePane extends JPanel implements SimpleUpdate {



    private JTextField nom;
    private JLabel labelNom;
    private JComboBox listGenre;
    private JLabel labelGenre;
    private JTextArea details;
    private JLabel labelDetails;
    private JTextField releaseDate;
    private JLabel labelDate;
    private JButton addGenre;
    private JButton addMovie;

    public MyAddMoviePane() {

        this.labelNom = new JLabel("Nom du film");
        this.nom = new JTextField();
        this.nom.setPreferredSize(new Dimension(50, 30));
        this.labelDetails = new JLabel("Details du film");
        this.details = new JTextArea();
        this.details.setPreferredSize(new Dimension(300, 100));
        this.labelDate = new JLabel("Année de sortie");
        this.releaseDate = new JTextField();
        this.releaseDate.setPreferredSize(new Dimension(150, 30));
        this.labelGenre = new JLabel("Genre du film à ajouter");
        this.listGenre = new JComboBox();
        this.listGenre.setPreferredSize(new Dimension(150, 30));
        this.addMovie = new JButton("Ajouter un film ");
        this.labelNom = new JLabel("Nom du genre");
        this.nom = new JTextField();
        this.nom.setPreferredSize(new Dimension(50, 30));
        this.addGenre = new JButton("Ajouter un genre ");
        for (String genre : Genres.getAllGenres()) {
            this.listGenre.addItem(genre);
        }
        this.setLayout(new FlowLayout());
        this.add(this.labelNom);
        this.add(this.nom);
        this.add(this.labelDate);
        this.add(this.releaseDate);
        this.add(this.labelGenre);
        this.add(this.listGenre);
        this.add(this.labelDetails);
        this.add(this.details);
        this.add(this.addMovie);
        this.add(this.labelNom);
        this.add(this.nom);
        this.add(this.addGenre);


        this.addMovie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addOneMovie();
            }
        });

    }


        private void addOneGenre(){
            String genre = this.nom.getText();
            Genres.addGenre(genre);
    }

        private void addOneMovie()
        {
            String nom = this.nom.getText();
            String year = this.releaseDate.getText();
            String genre = this.listGenre.getSelectedItem().toString();
            int IdOfGenre = this.getIdOfGenre(genre);
            Movies.AddMovie(nom, year, IdOfGenre);

        }

    private int getIdOfGenre(String genre) {
        return Genres.getIdOfGenre(genre);
    }

    @Override
    public DefaultTableModel update(ArrayList movies) {
        return null;
    }
}
