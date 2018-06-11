package Publisher.Library;


/**
 * Write a description of class Point3D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point3D
{
    private int x;
    private int y;
    private int z;
    public Point3D(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getZ(){
        return this.z;
    }
    
    public int[] getVectorP3D(){
        int [] vectorPoint3D = new int[3];
        vectorPoint3D[0] = this.x;
        vectorPoint3D[1] = this.y;
        vectorPoint3D[2] = this.z;
        return vectorPoint3D;
    }
}
