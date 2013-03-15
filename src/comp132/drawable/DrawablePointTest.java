package comp132.drawable;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class DrawablePointTest {

	@Test
	public void test() throws IOException {
		FileOutputStream output = new FileOutputStream("aPoint.txt");
    	DataOutputStream dos = new DataOutputStream(output);
    	DrawablePoint thisPoint = new DrawablePoint(15, 20);
    	thisPoint.write(dos);
    	FileInputStream input = new FileInputStream("aPoint.txt");
    	DataInputStream dis = new DataInputStream(input);
    	dis.readLine();
    	DrawablePoint copy = new DrawablePoint(dis);
    	Assert.assertEquals(copy.toString(), thisPoint.toString());
	}
	@Test
	public void testConstructorInterpolation(){
		DrawablePoint obj0 = new DrawablePoint(10, 15);
		DrawablePoint obj1 = new DrawablePoint(20, 30);
		DrawablePoint objBetween = new DrawablePoint(obj0, obj1, 0.5);
		Assert.assertEquals(15, objBetween.getX());
		Assert.assertEquals(22, objBetween.getY());
		Assert.assertEquals(obj0.getColor(), objBetween.getColor());
	}
	@Test
	public void testInterpolate(){
		DrawablePoint obj0 = new DrawablePoint(10, 15);
		DrawablePoint obj1 = new DrawablePoint(20, 30);
		DrawablePoint objBetween = (DrawablePoint) obj0.interpolate( obj1, 0.5);
		Assert.assertEquals(15, objBetween.getX());
		Assert.assertEquals(22, objBetween.getY());
		Assert.assertEquals(obj0.getColor(), objBetween.getColor());
	}
}
