package Publisher.Controller;
import Publisher.Library.*;
import java.util.ArrayList;
/**
 * Write a description of class LineBresemhan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineBresemhan
{
    private Point2D point1;
    private Point2D point2;
    private ArrayList<Point2D> points;
    private int distands;
    //private ArrayList<Point2D> proyectionPoints;
    public LineBresemhan(Point2D point1,Point2D point2)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.points = new ArrayList<>() ;
        this.distands = distands(point1,point2);
    }
    public Point2D getPoint1(){
        return point1;
    }
    
    public Point2D getPoint2(){
        return point2;
    }
    public void setPoint12(Point2D p1,Point2D p2){
        this.point1 = p1;
        this.point2 = p2;
    }
    
    public void drawLine() {
        // delta of exact value and rounded value of the dependent variable
        int x1 = point1.getX(); 
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                points.add(new Point2D(x,y));
                
                //System.out.println(x+"  "+y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                points.add(new Point2D(x,y));
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }
    public int distands(Point2D p1, Point2D p2){
        this.distands = (int)Math.sqrt((p1.getX()*p2.getX()) + (p1.getY()*p2.getY()));
        return distands;
    }
    public void scale(int d){
        if(d > this.distands){
            this.point2.translate(d,d);            
        }
        else{
            if(d < this.distands){
                this.point2.translate(-d,-d);
            }
        }
    }
    public void pointDistands(int d){
        
    }
    public void emtyPoint(){
        for(Point2D p: points){
            // borrar los elementos del arreglo
        }
    }   
    public ArrayList<Point2D> getPoints(){
        return points;
    }
    public void translate(int x, int y){
        // System.out.println(point1.getX()+" " + point1.getY());
        // System.out.println(point2.getX()+" " + point2.getY());
        point1.translate(x,y);
        point2.translate(x,y);
        // System.out.println("new puntos trasladados");
        // System.out.println(point1.getX()+" " + point1.getY());
        // System.out.println(point2.getX()+" " + point2.getY());
        for(Point2D p:this.points){
            p.translate(x,y);
        }
    }
}
