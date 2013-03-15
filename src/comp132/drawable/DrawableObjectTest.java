package comp132.drawable;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class DrawableObjectTest {

	@Test
	public void testConstructorInterpolation() {
		DrawableObject obj0 = new DrawableObject(10, 15);
		DrawableObject obj1 = new DrawableObject(20, 30);
		DrawableObject objBetween = new DrawableObject(obj0, obj1, 0.5);
		Assert.assertEquals(15, objBetween.getX());
		Assert.assertEquals(22, objBetween.getY());
		Assert.assertEquals(obj0.getColor(), objBetween.getColor());
	}

}
