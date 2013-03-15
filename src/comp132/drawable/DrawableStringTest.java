package comp132.drawable;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class DrawableStringTest {

	@Test
	public void testConstructorReadFromFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("aString.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		DrawableString newStr = new DrawableString(5, 10, "This is a String");
		newStr.write(dos);
		FileInputStream fis = new FileInputStream("aString.txt");
		DataInputStream dis = new DataInputStream(fis);
		dis.readLine();
		DrawableString copy = new DrawableString(dis);
		Assert.assertEquals(newStr.toString(), copy.toString());
	}
	
	@Test
	public void testConstructorInterpolation() {
		DrawableString obj0 = new DrawableString(5, 10, "This is a String");
		DrawableString obj1 = new DrawableString(15, 20, "This is a String");
		DrawableString between = new DrawableString(obj0, obj1, .5);
		Assert.assertEquals(10, between.getX());
		Assert.assertEquals(15, between.getY());
	}
	
	@Test
	public void testInterpolate() {
		DrawableString obj0 = new DrawableString(5, 10, "This is a String");
		DrawableString obj1 = new DrawableString(15, 20, "This is a String");
		DrawableString between = (DrawableString) obj0.interpolate((DrawableString) obj1, 0.5);
		Assert.assertEquals(10, between.getX());
		Assert.assertEquals(15, between.getY());
	}

}
