package comp132.drawable;

import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * a class represent a list of drawable object
 * @author hieule
 * @version Feb 2013
 *
 */
public class DrawableObjectList {
	private ArrayList<DrawableObject> objList;
	
	/**
	 * initialize a drawable object list 
	 */
	public DrawableObjectList(){
		objList = new ArrayList<DrawableObject>();
	}
	/**
	 * Construct a drawableObjectList with specified information from data input
	 * @param fileName
	 * @throws IOException 
	 */
	public DrawableObjectList(String fileName) {
		objList = new ArrayList<DrawableObject>();
		DataInputStream dis = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String className = "";
			try {
				while (dis.available() >0){
					className = dis.readLine();
					if (className.equals("DrawableLine")) {
						objList.add(new DrawableLine(dis));
					} else if (className.equals("DrawableCircle")) {
						objList.add(new DrawableCircle(dis));
					} else if (className.equals("DrawablePoint")) {
						objList.add(new DrawablePoint(dis));
					}  else if (className.equals("DrawableRectangle")){
						objList.add(new DrawableRectangle(dis));
					}  else if (className.equals("DrawableString")) {
						objList.add(new DrawableString(dis));
					} else {
						throw new InvalidShapeException("Invalid Shape! This is not a drawable object");
					}
				} 
			} catch (InvalidShapeException ise) {
				System.out.println(className);
				System.out.println("Invalid shape. This is not a drawable object");
				System.exit(0);
			} finally {
				dis.close();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Cannot Open file");
		} catch ( IOException ioe) {
			System.out.println("Error reading file");
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					System.out.println("Error reading file");
				}
			}
			System.exit(0);
		}
	}
	/**
	 * add an drawableObject to the list
	 * @param pObj
	 */
	public void addObject(DrawableObject pObj){
		objList.add(pObj);
	}
	/**
	 * get the number of objects in the list
	 * @return the number of objects in the list
	 */
	public int numObjects(){
		return objList.size();
	}
	/**
	 * draw all the objects in the list
	 * @param graphics
	 */
	public void drawAllObjects(java.awt.Graphics graphics){
		for (DrawableObject thisObj: objList){
			thisObj.draw(graphics);
		}
	}
	/**
	 * scale all the scaleable object to a specified factor
	 * @param factor
	 */
	public void scaleAllObjects(double factor){
		for (DrawableObject thisObj: objList){
			if (thisObj instanceof Scaleable){
				((Scaleable) thisObj).scale(factor);
			}
		}
	}
	/**
	 * 
	 * @param fileName
	 */
	public void write(String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			DataOutputStream dos = new DataOutputStream(fos);
			for (DrawableObject obj: objList) {
				try {
					obj.write(dos);
				} catch (IOException e) {
					System.out.println("cannot open");
					System.exit(0);
				}
			}
			try {
				dos.close();
			} catch (FileNotFoundException e) {
				System.out.println("cannot write to file!");
				System.exit(0);
			}
		} catch (IOException ioe) {
			System.out.println("cannot open");
			System.exit(0);
		}	
	}
	
	public DrawableObject getObject(int index) {
		return objList.get(index);
	}
	
	public DrawableObjectList interpolate(DrawableObjectList doL, double interp){
		DrawableObjectList between = new DrawableObjectList();
		for (int i = 0; i < objList.size(); i++) {
			between.addObject(objList.get(i).interpolate( doL.getObject(i), interp));
		}
		
		return between;
	}
}
