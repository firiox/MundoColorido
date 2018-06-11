package Publisher.Controller;
import Publisher.Library.*;
import java.util.ArrayList;
/**
 * Write a description of class CircleBresenham here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleBresenham
{
    private Point2D pointCenter;
    private int radio;
    private ArrayList<Point2D> points;
    public CircleBresenham(Point2D pointCenter,int radio)
    {
        this.pointCenter = pointCenter;
        this.radio = radio;
        this.points = new ArrayList<Point2D>();
    }
    
    public CircleBresenham(){
        this.pointCenter = null;
        this.radio = 0;
        this.points = new ArrayList<Point2D>();
    }
    
    public ArrayList<Point2D> getPoint2DCircle(){
        return this.points;
    }
    
    public ArrayList<Point2D> calcule(){
        int xc = pointCenter.getX();
        int yc = pointCenter.getY();
        int x = this.radio;
        int y = 0;
        int e = 0;
        while(x >= y){
            points.add(new Point2D((xc + x),(yc + y)));
            points.add(new Point2D((xc + y),(yc + x)));
            points.add(new Point2D((xc - x),(yc + y)));
            points.add(new Point2D((xc - y),(yc + x)));

            points.add(new Point2D((xc + x),(yc - y)));
            points.add(new Point2D((xc + y),(yc - x)));
            points.add(new Point2D((xc - x),(yc - y)));
            points.add(new Point2D((xc - y),(yc - x)));
            e = e + (2*y) + 1;
            y = y+1;
            if((2 * e) > ((2*x)-1)){
                x = x - 1;
                e = e - (2*x) + 1;
            }
        }        
        // claculo de todos los puntos de la cirfunferencia 
        return this.points;
    }
 
    // public ArrayList<Point2D> translation(Point2D pointNew){
        // LineBresemhan line = new LineBresemhan(pointCenter,pointNew);
        // return this.points;
    // }
    public ArrayList<Point2D> extension(int radioNew){
        return this.points;
    }
    public void setPointCenter(Point2D pointNew){
        this.pointCenter = pointNew;
    }
    public Point2D getPointCenter(){
        return pointCenter;
    }
    public int getRadio(){
        return radio;
    }
    public void setRadio(int radio){
        this.radio = radio;
    }
    public void translation(int x, int y){
        System.out.println("************************************************");
        System.out.println(pointCenter.getX()+" "+pointCenter.getY());
        pointCenter.translate(x,y);
        System.out.println(pointCenter.getX()+" "+pointCenter.getY());
        for(Point2D p:this.points){
            p.translate(x,y);
        }
    }
    // public void translationCircle(Point2D pointNew){
        // int x = pointNew.getX();
        // int y = pointNew.getY();
        // for(Point2D p : getPoint2DCircle()){
            // p.setX(p.getX()+x);
            // p.setY(p.getY()+y);
        // }
        // //return this.points;
    // }
}
