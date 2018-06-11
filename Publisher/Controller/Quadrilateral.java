package Publisher.Controller;
import Publisher.Library.*;
import java.util.ArrayList;
import java.util.Stack;

public class Quadrilateral
{
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;
    private Point2D point4;
    private ArrayList<Point2D> point2DQuadrilateral;
    public Quadrilateral(Point2D point1,Point2D point3)
    {
        this.point1 = point1;
        this.point2 = new Point2D(point1.getX(),point3.getY());
        this.point3 = point3;
        this.point4 = new Point2D(point3.getX(),point1.getY());
        this.point2DQuadrilateral = new ArrayList<>();
    }
    public ArrayList<Point2D> getPoint2DQuadrilateral(){
        LineBresemhan line1 = new LineBresemhan(point1,point2);
        line1.drawLine();
        addPoinst(line1.getPoints());
        LineBresemhan line2 = new LineBresemhan(point2,point3);
        line2.drawLine();
        addPoinst(line2.getPoints());
        LineBresemhan line3 = new LineBresemhan(point3,point4);
        line3.drawLine();
        addPoinst(line3.getPoints());
        LineBresemhan line4 = new LineBresemhan(point4,point1);
        line4.drawLine();
        addPoinst(line4.getPoints());
        return point2DQuadrilateral;
    }
    public void addPoinst(ArrayList<Point2D> point){
        for(Point2D p : point){
            this.point2DQuadrilateral.add(p);
        }
    }
    public void translate(int x,int y){
        System.out.println("********************************************************************");
        System.out.println(point1.getX()+" "+point1.getY());
        System.out.println(point2.getX()+" "+point2.getY());
        System.out.println(point3.getX()+" "+point3.getY());
        System.out.println(point4.getX()+" "+point4.getY());
        point1.translate(x,y);
        point2.translate(x,y);
        point3.translate(x,y);
        point4.translate(x,y);
        System.out.println("********************************************************************");
        System.out.println(point1.getX()+" "+point1.getY());
        System.out.println(point2.getX()+" "+point2.getY());
        System.out.println(point3.getX()+" "+point3.getY());
        System.out.println(point4.getX()+" "+point4.getY());
        for(Point2D p:this.point2DQuadrilateral){
            p.translate(x,y);   
        }
    }
    
}
