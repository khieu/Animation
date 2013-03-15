package comp132.drawable;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * A DrawablePoint is an object representing a point that
 * can be drawn on a Graphics object.
 */
public class DrawablePoint extends DrawableObject {

    /**
     * Construct a new DrawablePoint with the specified
     * coordinates.
     * 
     * @param initX the x coordinate of the new DrawablePoint.
     * @param initY the y coordinate of the new DrawablePoint.
     */
    public DrawablePoint(int initX, int initY) {
        super(initX, initY);
    }
    /**
     * construct a DrawablePoint with specified information from data input
     * @param dis
     * @throws IOException
     */
    public DrawablePoint(DataInputStream dis) throws IOException {
    	super(dis);
    }

    public DrawablePoint(DrawablePoint obj0, DrawablePoint obj1, double t) {
    	super(obj0, obj1, t);
    }
    /**
     * Draw this DrawablePoint onto the specified Graphics
     * object.
     *
     * @param g the Graphics object on which to draw this
     *          DrawablePoint.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());

        // The Graphics class provides no way to draw 
        // a single point so hack it by drawing a line
        // that starts and ends at the same point!
        g.drawLine(getX(), getY(), getX(), getY());
    }

    /**
     * Generate a String representation of this DrawablePoint.
     *
     * @return a String representation of this DrawablePoint.
     */
    public String toString() {
        return "DrawablePoint[x=" + getX() + " y=" + getY() + "]";
    }
    
    /**
     * 
     */
    public void write(DataOutputStream dos) throws IOException{
    	dos.writeBytes("DrawablePoint" + "\n");
    	super.write(dos);
    }
    
    public DrawableObject interpolate(DrawableObject obj, double interp) {
    	DrawablePoint between = new DrawablePoint ((DrawablePoint) this, (DrawablePoint) obj, interp);
    	return between;
    }
}

