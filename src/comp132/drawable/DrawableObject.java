package comp132.drawable;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * A DrawableObject is an object representing a Object that
 * can be drawn on a Graphics object. The DrawableObject
 * class also forms the base of an heirarchy of Drawable
 * shapes.
 */
public class DrawableObject
    implements Cloneable {

    private int x;
    private int y;
    private Color color;

    /**
     * Construct a new DrawableObject with the specified
     * coordinates.
     * 
     * @param initX the x coordinate of the new DrawableObject.
     * @param initY the y coordinate of the new DrawableObject.
     */
    public DrawableObject(int initX, int initY) {
        x = initX;
        y = initY;
        color = Color.black;
    }
    
    /**
     * The constructor should read data from the input stream and 
     * use that data to initialize the instance fields of the class.
     * @param dis
     * @throws IOException 
     */
    public DrawableObject(DataInputStream dis) throws IOException {
    	int xPos = dis.readInt();
    	int yPos = dis.readInt();
    	x = xPos;
    	y = yPos;
    	color = new Color(dis.readInt());
    }
    
    public DrawableObject(DrawableObject obj0, DrawableObject obj1,double t) {
    	double xPos = (1.0 - t)*obj0.getX() + (t)*obj1.getX();
    	x = (int) xPos;
    	double yPos = (1.0 - t)*obj0.getY() + (t)*obj1.getY();
    	y = (int) yPos;
    	color = obj0.getColor();
    }
    /**
     * Translate this DrawableObject by the specified amount.
     *
     * @param dx the amount by which to translate the x coordinate.
     * @param dy the amount by which to translate the y coordinate.
     */
    public void translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    /**
     * Set the color of this DrawableObject.
     *
     * @param c the new color of this DrawableObject.
     */
    public void setColor(Color c) {
        color = c;
    }

    /** 
     * Get the x coordinate of this DrawableObject.
     *
     * @return the x coordinate of this DrawableObject.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Get the y coordinate of this DrawableObject.
     *
     * @return the y coordinate of this DrawableObject.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the color of this DrawableObject.
     *
     * @return the color of this DrawableObject.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Draw this DrawableObject onto the specified Graphics
     * object.
     *
     * @param g the Graphics object on which to draw this
     *          DrawableObject.
     */
    public void draw(Graphics g) {
        // this method intentionally left blank - override in each subclass
    }

    /**
     * Generate a String representation of this DrawableObject.
     *
     * @return a String representation of this DrawableObject.
     */
    public String toString() {
        // this method intentionally left blank - override in each subclass
        return "";
    }

    /**
     * Make a clone of this DrawableObject object.  This 
     * implementation will work for all current sub-classes
     * of DrawableObject because they use only primitive or
     * immutable data.  If any sub-class of DrawableObject
     * uses mutable objects as instance data it will have
     * to override the clone method.  See section 11.7.3,
     * Common Error 11.6, Quality Tip 11.1  and 
     * Advanced Topic 11.6 if you are interested
     * in why this method is necessary.
     *
     * @return a clone of this DrawableObject object.
     */
    public Object clone() {
        try {
            return (DrawableObject)(super.clone());
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    /**
     * 
     * @param dos
     * @throws IOException
     */
    public  void write(DataOutputStream dos) throws IOException{
    	dos.writeInt(getX());
    	dos.writeInt(getY());
    	dos.writeInt(color.getRGB());
    }
    
    public DrawableObject interpolate(DrawableObject obj, double interp) {
        return null;
    }
}

