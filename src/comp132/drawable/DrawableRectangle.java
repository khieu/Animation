package comp132.drawable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * a class represents a rectangle
 * 
 * @author hieule
 * @version Feb 2013
 */
public class DrawableRectangle extends DrawableObject implements Scaleable {
	private int width;
	private int height;
	
	/**
	 * initialize a rectangle to specified parameters
	 * @param initX
	 * @param initY
	 * @param initWidth
	 * @param initHeight
	 */
	public DrawableRectangle(int initX, int initY, int initWidth, int initHeight){
		super(initX, initY);
		width = initWidth;
		height = initHeight;
	}
	/**
	 * Construct a DrawableRectangle with specified information from data input
	 * @param dis
	 * @throws IOException
	 */
	public DrawableRectangle(DataInputStream dis) throws IOException {
		super(dis);
		width = dis.readInt();
		height = dis.readInt();
	}
	
	public DrawableRectangle(DrawableRectangle obj0, DrawableRectangle obj1, double t) {
		super(obj0, obj1, t);
		double theWidth = (1.0 - t)*obj0.getWidth() + (t)*obj1.getWidth();
		width = (int) theWidth;
		double theHeight = (1.0 - t)*obj0.getHeight() + (t)*obj1.getHeight();
		height = (int) theHeight;
	}
	/**
	 * get the width of the rectangle
	 * @return the width of the rectangle
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * get the height of the rectangle
	 * 
	 * @return the height of the rectangle
	 */
	public int getHeight() {
		return height;
	}

	@Override
	/**
	 * scale the rectangle to a specific factor
	 * @param factor
	 */
	public void scale(double factor) {
		double initWidth =  width * factor;
		width = (int) initWidth;
		height = (int) (height * factor);
		// TODO Auto-generated method stub
	}
	/**
	 * get all information of the rectangle
	 * @return all the information of the rectangle
	 */
	public String toString(){
		String result = "This " + getColor() + " rectangle has the width of " + width + " and the height of " + height + ". Its initial uper left point is ("
				        + getX() + ", " + getY() + ").";  
		return result;
	}
	
	/**
	 * draw the rectangle
	 * @param graphic
	 */
	public void draw(java.awt.Graphics graphic){
		graphic.setColor(getColor());
		graphic.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	/**
	 * @throws IOException 
	 * 
	 */	
	public void write(DataOutputStream dos) throws IOException{
		dos.writeBytes("DrawableRectangle" + "\n");
		super.write(dos);
		dos.writeInt(getWidth());
		dos.writeInt(getHeight());
	}
	
	public static void main(String [] args) throws IOException {
		DrawableRectangle newRect = new DrawableRectangle(15, 20, 50, 70);
		FileOutputStream fos = new FileOutputStream("aRectangle");
		DataOutputStream dos = new DataOutputStream(fos);
		newRect.write(dos);
		dos.close();
	} 
	
	public DrawableObject interpolate(DrawableObject obj, double interp) {
		DrawableRectangle between = new DrawableRectangle(this, (DrawableRectangle) obj, interp);
		return between;
		
	}
}
