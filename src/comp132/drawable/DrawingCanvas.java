package comp132.drawable;

import javax.swing.*;
import java.awt.*;

/**
 * A DrawingCanvas is the surface on which the shapes are
 * actually drawn.
 *
 * @author Grant Braught (4/22/2002)
 * @revised Marge Coahran (3/22/2012)	
 * @author Dickinson College
 */
public class DrawingCanvas 
    extends JPanel {
 
    private int width;
    private int height;
    private DrawableObjectList shapes;

    /**
     * Construct a new DrawingCanvas with the specified
     * width and height.
     *
     * @param width the width of the new DrawingCanvas.
     * @param height the height of the new DrawingCanvas.
     */
    public DrawingCanvas (int width, int height,
                          DrawableObjectList shapes) {
        this.width = width;
        this.height = height;
        this.shapes = shapes;
    }
    
    /**
     * Replace the current shapes list with a new one
     * @param newShapes  the new list of shapes
     */
    public void setShapes(DrawableObjectList newShapes) {
    	shapes = newShapes;
    }
    
    /**
     * Return the width and height of this DrawingCanvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this DrawingCanvas.
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    /**
     * Return the width and height of this DrawingCanvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this DrawingCanvas.
     */
    public Dimension getMinimumSize() {
        return new Dimension(width, height);
    }

    /**
     * Return the width and height of this DrawingCanvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this DrawingCanvas.
     */
    public Dimension getMaximumSize() {
        return new Dimension(width, height);
    }

    /**
     * Paint all of the shapes onto the specified graphics
     * context.
     *
     * @param g the graphics context onto which the shapes
     *          are to be drawn.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapes.drawAllObjects(g);
    }
}
