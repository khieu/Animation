package comp132.drawable;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DrawableLineTest {
	private DrawableLine newLine;
	@Before public void setUp() {
		newLine = new DrawableLine(2, 3, 7, 9);
	}
	@Test
	public void testConstructor() {
		Assert.assertEquals(2, newLine.getX());
		Assert.assertEquals(3, newLine.getY());
		Assert.assertEquals(7, newLine.getX2());
		Assert.assertEquals(9, newLine.getY2());
	}
	
	@Test
	public void testToString(){
		String result = "The java.awt.Color[r=0,g=0,b=0] line has 2 points: (2, 3) and (7, 9) ";
		Assert.assertEquals(result, newLine.toString());
	}
	@Test
	public void testTranslate(){
		newLine.translate(1, 1);
		Assert.assertEquals(8, newLine.getX2());
		Assert.assertEquals(10, newLine.getY2());
		Assert.assertEquals(3, newLine.getX());
		Assert.assertEquals(4, newLine.getY());
	}
	@Test
	public void testConstructorReadFromFile() throws IOException{
		FileOutputStream fos = new FileOutputStream("aLine.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		newLine.write(dos);
		FileInputStream fis = new FileInputStream("aLine.txt");
		DataInputStream dis = new DataInputStream(fis);
		dis.readLine();
		DrawableLine copy = new DrawableLine(dis);
		Assert.assertEquals(newLine.toString(), copy.toString());
	}
	@Test
	public void testConstructorInterpolation(){
		DrawableLine obj0 = new DrawableLine(10,20 ,40, 50);
		DrawableLine obj1 = new DrawableLine(20,30 ,50, 60);
		DrawableLine between = new DrawableLine(obj0, obj1, .5);
		Assert.assertEquals(15, between.getX());
		Assert.assertEquals(25, between.getY());
		Assert.assertEquals(45, between.getX2());
		Assert.assertEquals(55, between.getY2());
		Assert.assertEquals(obj0.getColor(), between.getColor());
	}
	@Test
	public void testInterpolate(){
		DrawableLine obj0 = new DrawableLine(10,20 ,40, 50);
		DrawableLine obj1 = new DrawableLine(20,30 ,50, 60);
		DrawableLine between = (DrawableLine) obj0.interpolate(obj1, 0.5);
		Assert.assertEquals(15, between.getX());
		Assert.assertEquals(25, between.getY());
		Assert.assertEquals(45, between.getX2());
		Assert.assertEquals(55, between.getY2());
		Assert.assertEquals(obj0.getColor(), between.getColor());
	}
}
