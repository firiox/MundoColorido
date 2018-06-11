package Publisher.View;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;


public class Frame extends JFrame implements WindowListener{   
    private static JMenuBar nav;
   // private JMenuBar lienzo;
    private static JMenu archive;
    private static JMenu insert;
    private static JMenu option;
    private static JMenu help;
    
    private static Canvas1 canvas;
    
    private static JPanel west;
    
    public Frame()
    {
        nav = new JMenuBar();
        nav();
        setJMenuBar(nav);
        setLayout(new BorderLayout());
        addWindowListener(this);      
        JPanel panel = new JPanel();
        JButton boton = new JButton("ver si se muestra");
        boton.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                System.out.println(canvas.getHeight()+"   "+canvas.getWidth());
            }
        });
        panel.add(boton);        
        canvas = new Canvas1(); //canvas.getheight y canvas.getWidth);
        add(panel, BorderLayout.WEST);
        add(canvas,BorderLayout.CENTER);
        setTitle("Publisher Graficacion Por Computadora");
        setSize(1600, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void windowActivated(WindowEvent arg0) {
            canvas.buffer(canvas.getHeight(),canvas.getWidth());
     }

    public void windowClosed(WindowEvent arg0) {
        //System.out.println("la ventana esta en estado 'dispose'");
    }

    public void windowClosing(WindowEvent arg0) {
       // System.out.println("La ventana se esta cerrando");
    }

    public void windowDeactivated(WindowEvent arg0) {
        //System.out.println("La ventana esta desactivada");
    }

    public void windowDeiconified(WindowEvent arg0) {
        System.out.println("la ventana esta maximizado luego de estar iconificado");
    }

    public void windowIconified(WindowEvent arg0) {
        System.out.println("la ventana esta iconificado o minimizado");
    }

    public void windowOpened(WindowEvent arg0) {
        System.out.println("la ventana esta abierta");
    }
    
    public void nav(){
        archive = new JMenu("Archive");
        insert = new JMenu("Insert");
        option = new JMenu("Option");
        help = new JMenu("Help");
        this.nav.add(archive);
        this.nav.add(insert);
        this.nav.add(option);
        this.nav.add(help);
    }
}
