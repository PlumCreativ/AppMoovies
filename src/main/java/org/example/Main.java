package org.example;

import gui.MyWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch (UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }
        MyWindow myapp = new MyWindow("Movies Menager");
        myapp.setVisible(true);
    }
}
