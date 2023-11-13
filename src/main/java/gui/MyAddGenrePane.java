package gui;

import back.Genres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAddGenrePane extends JPanel{
    private JTextField nom;
    private  JLabel labelNom;
    private JButton addGenre;

    public MyAddGenrePane() {
        this.nom = new JTextField();
        this.nom.setPreferredSize(new Dimension(150, 30));
        this.labelNom = new JLabel("Nom du Genre");
        this.addGenre = new JButton("Ajouter le groupe");

        this.addGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGenre();
            }
        });


        this.add(this.labelNom);
        this.add(this.nom);
        this.add(this.addGenre);

        }

        private void addGenre(){
            String genre = this.nom.getText();
            Genres.addGenre(genre);
        }

}
