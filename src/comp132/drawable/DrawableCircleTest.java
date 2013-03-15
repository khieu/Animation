package comp132.drawable;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class DrawableCircleTest {

	@Test
	public void testConstructorReadFromFile() throws IOException {
		FileOutputStream output = new FileOutputStream("aCircle.txt");
    	DataOutputStream dos = new DataOutputStream(output);
    	DrawableCircle thisCircle = new DrawableCircle(15, 20, 25);
    	thisCircle.write(dos);
    	FileInputStream input = new FileInputStream("aCircle.txt");
    	DataInputStream dis = new DataInputStream(input);
    	dis.readLine();
    	DrawableCircle copy = new DrawableCircle(dis);
    	Assert.assertEquals(copy.toString(), thisCircle.toString());
	}
	
	@Test
	public void testConstructorInterpolation(){
		DrawableCircle obj0 = new DrawableCircle(10, 20, 25);
		DrawableCircle obj1 = new DrawableCircle(20, 30, 35);
		DrawableCircle between = new DrawableCircle(obj0, obj1, .5);
		Assert.assertEquals(15, between.getX());
		Assert.assertEquals(25, between.getY());
		Assert.assertEquals(30, between.getRadius());
		Assert.assertEquals(obj0.getColor(), between.getColor());
	}
	@Test
	public void testInterpolate() {
		DrawableCircle obj0 = new DrawableCircle(10, 20, 25);
		DrawableCircle obj1 = new DrawableCircle(20, 30, 35);
		DrawableCircle between = (DrawableCircle) obj0.interpolate(obj1, 0.5);
		Assert.assertEquals(15, between.getX());
		Assert.assertEquals(25, between.getY());
		Assert.assertEquals(30, between.getRadius());
		Assert.assertEquals(obj0.getColor(), between.getColor());
	}
	@Test
	public void testMain() throws IOException {
		DrawableCircle.main(new String[0]);
	}
}
