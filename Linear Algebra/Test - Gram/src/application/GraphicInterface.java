package application;
//import XML.*;
import Defines.*;
import application.Algebra.*;
import application.Helper.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicInterface{

    XmlFile Configs;
    public Window window;
    public JPanel panel;
    public JTextField input;
    public JTextField plan;
    public JLabel error;
    private JButton sendInput;

    private void LoadWindow(){

        Configs = new XmlFile(Defines.WindowConfig);

        if(Configs.IsNotNull()){
            
            int width = Helper.StringToInt(Configs.getElement("width"));
            int height = Helper.StringToInt(Configs.getElement("height"));

            this.window = new Window(width, height, Color.lightGray);
        }
    }


    private void LoadInputArea(){

        if(!this.Configs.IsNotNull() && !this.Configs.path.equals(Defines.WindowConfig))
            Configs = new XmlFile(Defines.WindowConfig);

        if(Configs.IsNotNull()){
            
            int inputAreaLength = Helper.StringToInt(Configs.getElement("inputArea"));

            this.plan = new JTextField(1);
            this.window.add(plan);

            this.input = new JTextField(40);
            this.window.add(input);

            this.sendInput = new JButton("Middle button");

            this.error = new JLabel();
            error.setBounds(170,335,120,20);

            sendInput.addActionListener( new ActionListener()
            {    
                public void actionPerformed(ActionEvent e)
                {
                   Algebra algebra = new Algebra(input.getText(), plan.getText());
                   error.setText(algebra.GetError());
                }
            });

            this.window.add(sendInput);
            this.window.add(error);
            this.window.setVisible(true);
        }
    }   

    private void AddTextArea(int rows, int columns){

        JTextArea field = new JTextArea("", rows, columns);
        this.window.add(field);
    }

    public GraphicInterface(){

        this.LoadWindow();
        this.LoadInputArea();
        this.window.setVisible(true);
    }
}

