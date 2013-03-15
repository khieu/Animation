package comp132.drawable;

import java.awt.Color;
/**
 * a clas represents my picture
 * @author hieule
 * @version Feb 2013
 */

public class MyPictureAfter2 {
	/**
	 * initialize a picture
	 */
	public MyPictureAfter2(){
		
	}
	
	/**
	 * a main method to draw my picture
	 * @param args
	 */
    public static void main(String[] args) {

        DrawingTablet drawTablet = new DrawingTablet(100,100);

		DrawableCircle drawCircle = new DrawableCircle(20,20,20);
		drawCircle.setColor(Color.yellow);
		drawTablet.drawShape(drawCircle);

        /*DrawablePoint dp = new DrawablePoint(40,50);
        dp.setColor(Color.red);
        dt.drawShape(dp);
        for (int i=1; i <=5; i++) {
            dp.translate(5,0);
            dt.drawShape(dp);
        }*/

        DrawableString drawString = new DrawableString(30, 90, "My picture");
        drawTablet.drawShape(drawString);      
        
        /*DrawableLine newLine = new DrawableLine(15, 16, 55,60);
        newLine.setColor(Color.blue);
        dt.drawShape(newLine);*/
        
        DrawableRectangle newRect = new DrawableRectangle(41, 50, 50, 25);
        newRect.setColor(Color.green);
        drawTablet.drawShape(newRect);
        
        DrawableRectangle newRectg = new DrawableRectangle(45, 55, 15, 20);
        newRectg.setColor(Color.pink);
        drawTablet.drawShape(newRectg);
        
        DrawableRectangle newSqr = new DrawableRectangle(65, 55, 15, 15);
        newSqr.setColor(Color.pink);
        drawTablet.drawShape(newSqr);
        
        
        DrawableLine newLine = new DrawableLine(85, 50, 95,50);
        newLine.setColor(Color.blue);
        drawTablet.drawShape(newLine);
        for (int i=1; i <=25; i++) {
            newLine.translate(-1,-1);
            drawTablet.drawShape(newLine);
        }
        
        DrawableLine newLine1 = new DrawableLine(35, 50, 45,50);
        newLine1.setColor(Color.blue);
        drawTablet.drawShape(newLine1);
        for (int i=1; i <=25; i++) {
            newLine1.translate(+1,-1);
            drawTablet.drawShape(newLine1);
        }
        drawTablet.show();
        
        drawTablet.write("keyframe2.dat");
    }
}
