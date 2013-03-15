package comp132.drawable;

import java.awt.*;

public class Testing {
    public static void main(String[] args) {

        DrawingTablet dt = new DrawingTablet(100,100);

		DrawableCircle dc = new DrawableCircle(50,50,30);
		dc.setColor(Color.yellow);
		dt.drawShape(dc);

        DrawablePoint dp = new DrawablePoint(40,50);
        dp.setColor(Color.red);
        dt.drawShape(dp);
        for (int i=1; i <=5; i++) {
            dp.translate(5,0);
            dt.drawShape(dp);
        }

        DrawableString ds = new DrawableString(30, 45, "Testing.");
        dt.drawShape(ds);       
        
        DrawableLine newLine = new DrawableLine(15, 16, 55,60);
        newLine.setColor(Color.blue);
        dt.drawShape(newLine);
        
        DrawableRectangle newRect = new DrawableRectangle(30, 35, 25, 30);
        newRect.setColor(Color.green);
        dt.drawShape(newRect);
        
        DrawableRectangle newSqr = new DrawableRectangle(65, 70, 55, 55);
        newSqr.setColor(Color.pink);
        dt.drawShape(newSqr);
        
        dt.show();
    }
}
