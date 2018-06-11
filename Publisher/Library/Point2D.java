    package Publisher.Library;


/**
 * Write a description of class Point2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point2D
{
    private int x;
    private int y;
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.x = x;
    }
    public int[] getVectorP2D(){
        int [] vectorPoint2D = new int[2];
        vectorPoint2D[0] = this.x;
        vectorPoint2D[1] = this.y;
        return vectorPoint2D;
    }
    
    public void translate(int x1, int y1){
        this.x = this.x + x1;
        this.y = this.y + y1;
    }
    
    public void scale(int d){
        this.x = x * d;
        this.y = y * d;
    }
    
    public void rotePoint(double angle){
        double alfa =  Math.toRadians(angle) ;
        double x1,y1;
        x1 = x;
        y1 = y;        
        x1 = (x1 * Math.cos(alfa)) - (y1 * Math.sin(alfa));
        y1 = (x1 * Math.sin(alfa)) + (y1 * Math.cos(alfa));
        this.x = (int)x1;
        this.y = (int)y1;
    }

    public static void main(String [] args){
        Point2D p = new Point2D(0,1);
        p.rotePoint(90);
        System.out.println(p.getX()+" "+p.getY());
    }
    
}
