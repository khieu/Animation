package comp132.drawable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A class represent a line
 * 
 * @author hieule
 * @version Feb 2013
 */
public class DrawableLine extends DrawableObject{
	private int x2Pos;
	private int y2Pos;
	
	/**
	 * initialize a line to specified parameters
	 * @param initX
	 * @param initY
	 * @param initX2
	 * @param initY2
	 */
	public DrawableLine(int initX, int initY, int initX2, int initY2){
		super(initX, initY);
		x2Pos = initX2;
		y2Pos = initY2;
	}
	/**
	 * Construct a new DrawableLine with specified information from data input
	 * @param dis
	 * @throws IOException
	 */
	public DrawableLine(DataInputStream dis) throws IOException {
		super(dis);
		x2Pos = dis.readInt();
		y2Pos = dis.readInt();
	}
	
	public DrawableLine(DrawableLine obj0, DrawableLine obj1, double interp) {
		super(obj0, obj1, interp);
		double x2Position = (1.0 - interp)*obj0.getX2() + (interp)*obj1.getX2();
    	x2Pos = (int) x2Position;
    	double y2Position = (1.0 - interp)*obj0.getY2() + (interp)*obj1.getY2();
    	y2Pos = (int) y2Position;
	}
	/**
	 * get the value of X2
	 * @return the value of x2
	 */
	public int getX2() {
		return x2Pos;
	}
	
	/**
	 * get to value of Y2
	 * @return the value of y2
	 */
	public int getY2() {
		return y2Pos;
	}
	
	/**
	 * return all information about the line
	 * @return all information about the line
	 */
	public String toString() {
		String result = "The " + getColor() + " line has 2 points: (" + getX() + ", " + getY() + ") and ("  + getX2() + ", " + getY2() + ") ";
		return result;
	}
	
	/**
	 * translate the line to with a specific amount
	 * @param dxPos
	 * @param dyPos
	 */
	public void translate(int dxPos, int dyPos){
		super.translate(dxPos, dyPos);
		x2Pos = x2Pos + dxPos;
		y2Pos = y2Pos + dyPos;
	}
	
	/**
	 * draw the line
	 * @param graphic a graphics instance
	 */
	public void draw(java.awt.Graphics graphic){
		graphic.setColor(getColor());
		graphic.drawLine(getX(), getY(), getX2(), getY2());
	}
	/**
	 * write information of the line to an output file
	 * @throws IOException 
	 * 
	 */
	public void write(DataOutputStream dos) throws IOException {
		dos.writeBytes("DrawableLine" + "\n");
		super.write(dos);
		dos.writeInt(getX2());
		dos.writeInt(getY2());
	}
	
	public DrawableObject interpolate(DrawableObject obj, double interp){
		DrawableLine between = new DrawableLine((DrawableLine) this, (DrawableLine) obj, interp);
		return between;
	}
}
