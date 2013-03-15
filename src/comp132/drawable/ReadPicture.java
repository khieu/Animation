package comp132.drawable;

public class ReadPicture {
	public static void main(String [] args) {
		DrawableObjectList myPict = new DrawableObjectList("myPicture.txt");
		DrawingTablet drawingTablet = new DrawingTablet(200,300, myPict);
		drawingTablet.show();
	}
}
