package comp132.drawable;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A DrawableString is an object representing a string that
 * can be drawn on a Graphics object.
 */
public class DrawableString
    extends DrawableObject {

    private String text;

    /**
     * Construct a new DrawableString that has its lower left
     * corner at initX, initY and displays the specified text.
     * 
     * @param initX the x coordinate of the lower left corner of 
     *              the text.
     * @param initY the y coordinate of the lower left corner of 
     *              the text.
     * @param text the text to be displayed.
     */
    public DrawableString(int initX, int initY, String text) {
        super(initX, initY);
        this.text = text;
    }
    
    public DrawableString(DrawableString obj0, DrawableString obj1, double t) {
    	super(obj0, obj1, t);
    	text = obj0.text;
    }
    /**
     * Construct a Drawable String with specified data from data input
     * @param dis
     * @throws IOException
     */
    public DrawableString(DataInputStream dis) throws IOException{
    	super(dis);
    	text = dis.readLine();
    }
    /**
     * Draw this DrawableString onto the specified Graphics
     * object.
     *
     * @param g the Graphics object on which to draw this
     *          DrawableString.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawString(text, getX(), getY());
    }

    /**
     * Generate a String representation of this DrawableString.
     *
     * @return a String representation of this DrawableString.
     */
    public String toString() {
        return "DrawableString[x=" + getX() + " y=" + getY() + 
            " text=" + text + "]";
    }
    /**
     * @throws IOException 
     * 
     */
    public void write(DataOutputStream dos) throws IOException{
    	dos.writeBytes("DrawableString" + "\n");
    	super.write(dos);
    	dos.writeBytes(text + "\n");
    }
    
    public DrawableObject interpolate(DrawableObject obj, double interp) {
    	DrawableString between = new DrawableString(this, (DrawableString) obj, interp);
    	return between;
    }
}


