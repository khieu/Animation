package comp132.drawable;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A DrawableCircle is an object representing a circle that
 * can be drawn on a Graphics object.
 * 
 * @author hieule
 * @version Feb 2013
 */
public class DrawableCircle
    extends DrawableObject
    implements Scaleable {

    private int radius;

    /**
     * Construct a new DrawableCircle centered at initX, initY 
     * with a radius of initRadius.
     *
     * @param initX the x coordinate of the center of the circle.
     * @param initY the y coordinate of the center of the circle.
     * @param initRadius the radius of the circle.
     */
    public DrawableCircle(int initX, int initY, int initRadius) {
        super(initX, initY);
        radius = initRadius;
    }
    
    /**
     * Construct a new DrawableCircle with specified information from data input
     * @param dis
     * @throws IOException
     */
    public DrawableCircle(DataInputStream dis) throws IOException {
    	super(dis);
    	radius = dis.readInt();
    }
    
    public DrawableCircle(DrawableCircle obj0, DrawableCircle obj1, double interp){
    	super(obj0, obj1, interp);
    	double theRadius = (1.0 - interp)*obj0.getRadius() + (interp)*obj1.getRadius();
    	radius = (int) theRadius;
    }
    /**
     * Get the radius of this DrawableCircle.
     *
     * @return the radius of this DrawableCircle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Scale this DrawableCircle by the specified factor.
     *
     * @param factor the factor by which this DrawableCircle
     *               is to be scaled.
     */
    public void scale(double factor) {
        radius = (int)(Math.round(radius * factor));
    }

    /**
     * Draw this DrawableCircle onto the specified Graphics
     * object.
     *
     * @param g the Graphics object on which to draw this
     *          DrawableCircle.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX() - radius, getY() - radius,
                   2*radius, 2*radius);
    }

    /**
     * Generate a String representation of this DrawableCircle.
     *
     * @return a String representation of this DrawableCircle.
     */
    public String toString() {
        return "DrawableCircle[x=" + getX() + " y=" + getY() +
            ", radius=" + radius + "]";
    }
    
    /**
     * Write information of the circle to a file
     * @param dos DataOutputStream
     */
    public void write(DataOutputStream dos) throws IOException {
    	dos.writeBytes("DrawableCircle" + "\n");
    	super.write(dos);
    	dos.writeInt(getRadius());
    }
    /**
     * return a new DrawableCircle object that is produced by 
     * interpolating between the calling object (this) and the object passed to the first parameter.
     */
    public DrawableObject interpolate(DrawableObject obj, double interp){
		DrawableCircle between = new DrawableCircle((DrawableCircle) this,(DrawableCircle) obj, interp);
		return between;
    	
    }
    /**
     * test the main method for lab part 2
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException{
    	FileOutputStream output = new FileOutputStream("aCircle.txt");
    	DataOutputStream dos = new DataOutputStream(output);
    	DrawableCircle thisCircle = new DrawableCircle(15, 20, 25);
    	thisCircle.write(dos);
    	FileInputStream input = new FileInputStream("aCircle.txt");
    	DataInputStream dis = new DataInputStream(input);
    	dis.readLine();
    	DrawableCircle copy = new DrawableCircle(dis);
    	System.out.println(copy.toString());
    	System.out.println(thisCircle.toString());
    	dos.close();
    }
}
