package application;
import XML.*;
import Defines.*;
import application.Helper.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {

    public Window(int width, int height, Color color) {
   
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(color);
        this.setVisible(true);
        this.setLocationRelativeTo(null);     
    }
}