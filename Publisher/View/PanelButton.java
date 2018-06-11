package Publisher.View;

import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class PanelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PanelButton extends JPanel
{
    private ButtonFunction buttons;
    private JButton line;
    private JButton circle;
    private JButton triangle;
    private JButton quadrilateral;
    
    private JButton color;
    
    public PanelButton(){
        buttons = new ButtonFunction();
        button();
    }
    // public String label(String name){
        // String label = new JLabel();
        // return label;
    // }
    public void button(){
        this.line = new JButton("Line");
        this.line.setSize(100,20);
        // position(this.line,60,110,20,50);
        // this.circle = new JButton("Circle");
        // position(this.circle,80,110,20,50);
    }
    
    public void position(JButton button,int x,int y, int d, int h){
        JButton aux = button;
        aux.setBounds(x,y,d,h);
    }
    public JButton getButtonLine(){
        return line;
    }
    public JButton getButtonCircle(){
        return circle;
    }
    public JButton getButtonTriangle(){
        return triangle;
    }
    public JButton getButtonQuadrilateral(){
        return quadrilateral;
    }
}