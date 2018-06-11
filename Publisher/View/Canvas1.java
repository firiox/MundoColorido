package Publisher.View;
import Publisher.Controller.*;
import Publisher.Library.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class Canvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Canvas1 extends Canvas
{
    private BufferedImage canvas;
    private LineBresemhan line;
    private Triangle triangle;
    private Quadrilateral quadrilateral;
    private CircleBresenham circle;
    private Color colorFound;
    
    private final int pixelSize = 10;
    public Canvas1()
    {
        setBackground(Color.BLACK);     
    }
   //*******************************************************************************
    public void buffer(int height,int width){
         this.colorFound = Color.BLACK;    
         this.canvas = new BufferedImage(height,width, BufferedImage.TYPE_INT_ARGB);
         line(0,0,50,50,Color.BLUE);
         lineaTanslate(250,250,Color.RED);
         //lineScale(20,Color.BLUE);
         //lineRote(45,Color.YELLOW);
         // triangle(100,50,150,100,75,100,Color.RED);
         // translateTriangle(200,400,Color.GREEN);
         // quadrilateral(300,300,150,200,Color.YELLOW);
         // translateQuadrilateral(10,10,Color.YELLOW);
         // circle(200,200,20,Color.GREEN);
         // translateCircle(50,50,Color.GREEN);
          
     }
    //*******************************************************************************
    public void paint(Graphics g){
        super.paint(g);
        //g.drawString("Lienzo de Dibujo Canvas",40,40);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(canvas,null,null);   
    }
    //*******************************************************************************  
    public void line(int x, int y, int x1, int y1,Color c){
        int color = c.getRGB();
        line = new LineBresemhan(new Point2D(x,y),new Point2D(x1,y1));
        line.drawLine();
        drawnPoint(line.getPoints(),color);
    }
    public void lineaTanslate(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = this.colorFound.getRGB();
        ArrayList<Point2D> aux = line.getPoints();
        drawnPoint(line.getPoints(),colorFoundDeault);
        line.translate(x,y);
        drawnPoint(line.getPoints(),color);
    }
    // public void lineaTanslate(int x, int y, Color c){
        // int color = c.getRGB();
        // int colorFoundDeault = this.colorFound.getRGB();
        // ArrayList<Point2D> aux = line.getPoints();
        // drawnPoint(line.getPoints(),colorFoundDeault);
        // translate(line.getPoints(),x,y);
        // drawnPoint(line.getPoints(),color);
        // int tam = line.getPoints().size();
        // line.setPoint12(line.getPoints().get(0),line.getPoints().get(tam));
        // //print(line.getPoints());
    // }
    public void lineScale(int distands, Color c){
        int color = c.getRGB();
        line.scale(distands);
        line.drawLine();
        Point2D aux = line.getPoint2();
        line.scale(distands);
        line = new LineBresemhan(aux,line.getPoint2());
        drawnPoint(line.getPoints(),color);
    }
    
    public void lineRote(double angle,Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        drawnPoint(line.getPoints(),colorFoundDeault); 
        rote(line.getPoints(),angle);
        drawnPoint(line.getPoints(),color);
    }
    
    public void rote(ArrayList<Point2D> point, double angle){
        for(Point2D p : point){
            p.rotePoint(angle);
            //System.out.println(p.getX() + "" + p.getY());
        }
    }
  
    public void print(ArrayList<Point2D> print){
        System.out.println("x " + "  " + " y");    
        for(Point2D p : print){
            System.out.println(p.getX() + "  " + p.getY());
        }
    }
    
    
  //*******************************************************************************  
    public void triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c){
        int color = c.getRGB();
        triangle = new Triangle(new Point2D(x1,y1),new Point2D(x2,y2),new Point2D(x3,y3));
        drawnPoint(triangle.getPointTriangle(),color);
    }
    
    public void translateTriangle(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        ArrayList<Point2D> aux = triangle.getPointTriangle(); 
        drawnPoint(aux,colorFoundDeault);
        triangle.translate(x,y);
        drawnPoint(triangle.getPointTriangle(),color);
    }
  //******************************************************************************* 
    public void quadrilateral(int x1, int y1, int x2, int y2, Color c){
        int color = c.getRGB();
        quadrilateral = new Quadrilateral(new Point2D(x1,y1),new Point2D(x2,y2));
        drawnPoint(quadrilateral.getPoint2DQuadrilateral(),color);
    }   
    
    public void translateQuadrilateral(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        ArrayList<Point2D> aux = quadrilateral.getPoint2DQuadrilateral(); 
        drawnPoint(aux,colorFoundDeault);
        quadrilateral.translate(x, y);
        drawnPoint(quadrilateral.getPoint2DQuadrilateral(),color);
    }
    // public void translateQuadrilateral(int x, int y, Color c){
        // int color = c.getRGB();
        // int colorFoundDeault = colorFound.getRGB();
        // ArrayList<Point2D> aux = quadrilateral.getPoint2DQuadrilateral(); 
        // drawnPoint(aux,colorFoundDeault);
        // translate(aux,x,y); 
        // drawnPoint(aux,color);
    // }
  //*******************************************************************************   
    public void circle(int xc, int yc, int radio, Color c){
        int color = c.getRGB();
        this.circle = new CircleBresenham(new Point2D(xc,yc),radio);
        drawnPoint(circle.calcule(),color);
    }
    // public void translateCircle(int x,int y, Color c){
        // int color = c.getRGB();
        // int colorFoundDeault = colorFound.getRGB();
        // drawnPoint(circle.getPoint2DCircle(),colorFoundDeault);
        // translate(circle.getPoint2DCircle(),x,y);
        // drawnPoint(circle.getPoint2DCircle(),color);
    // }
    public void translateCircle(int x,int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        drawnPoint(circle.getPoint2DCircle(),colorFoundDeault);
        circle.translation(x, y);
        drawnPoint(circle.getPoint2DCircle(),color);
    }
    
    // public void translate(ArrayList<Point2D> point, int x, int y){
        // for(Point2D p :point){
            // p.translate(x,y);
        // }
    // }
    // public void scale(ArrayList<Point2D> point,int x, int y){
        // for(Point2D p :point){
            // p.scale(x,y);
        // }
    // }
    
    
    public void drawnPoint(ArrayList<Point2D> points,int color){
        for(Point2D p :points){
           this.canvas.setRGB(p.getX(),p.getY(),color);
           repaint();
        }        
    }    

    public void paintSemilla(Point2D point,int color){   //pintado por semilla 
        Point2D aux;
        int colorFount = colorFound.getRGB();
        if(colorFount != color){//Si el pixel p es del color de fondo
           this.canvas.setRGB(point.getX(),point.getY(),color);
           repaint();
           aux = new Point2D(point.getX()-1,point.getY());
           paintSemilla(aux,color);
           //pixel de la izquierda
           aux = new Point2D(point.getX()+1,point.getY());
           paintSemilla(aux,color); 
           //píxel de la derecha
           aux = new Point2D(point.getX(),point.getY()-1);
           paintSemilla(aux,color); 
           //píxel inferior
           aux = new Point2D(point.getX(),point.getY()+1);
           paintSemilla(aux,color   );
           //píxel superior                        
        }
    }
}
