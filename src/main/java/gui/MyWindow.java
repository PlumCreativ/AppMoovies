package gui;

import gui.MyListPane;
import gui.MyAddMoviePane;
import gui.MyAddGenrePane;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private MyAddMoviePane addMoviePane;
    private MyAddGenrePane addGenrePane;


    public MyWindow(String name) {
        super(name);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        JPanel MainPanel = (JPanel) this.getContentPane();

        MainPanel.add(createTabs());
    }
    public @NotNull JTabbedPane createTabs(){

        JPanel paneList = new MyListPane();
        this.addMoviePane = new MyAddMoviePane();
        this.addGenrePane = new MyAddGenrePane();

        JTabbedPane MultiPane = new JTabbedPane();
        MultiPane.setBounds(40, 20, 300, 300);


        MultiPane.add("Liste des films ", paneList);
        MultiPane.add("Ajouter", addMoviePane);
        MultiPane.add("Option", addGenrePane);

        return MultiPane;
    }

}
