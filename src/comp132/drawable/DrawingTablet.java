package comp132.drawable;

import javax.swing.*;


import java.awt.event.*;
import java.awt.*;

/**
 * The DrawingTablet class represents a window on the graphics
 * screen onto which objects that implement the Drawable
 * interface may be drawn.
 *
 * @author Grant Braught (4/22/2002)
 * @revised Marge Coahran (3/22/2012)
 * @author Dickinson College
 */
public class DrawingTablet {

    private DrawingCanvas canvas;
    private JFrame myFrame;
    private DrawableObjectList shapes;

    /**
     * Create a new DrawingTablet with the specified 
     * size.
     *
     * @param width the width of the window.
     * @param height the height of the window.
     */
    public DrawingTablet(int width, int height) {
    	this(width, height, new DrawableObjectList());
    }
    
    /**
     * Create a new DrawingTablet with the given width, height,
     * and list of drawable shapes
     * .
     * @param width the width of the window
     * @param height the height of the window
     * @param list the list of drawable shapes
     */
    public DrawingTablet(int width, int height, DrawableObjectList list) {
        shapes = list;
        myFrame = new JFrame("Drawing Tablet");
        canvas = new DrawingCanvas(width,height,shapes); 

        Container thePane = myFrame.getContentPane();
        thePane.add(canvas, BorderLayout.CENTER);
        
        // Handle closing the window.
        myFrame.addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
                 System.exit(0);
             }
         });

        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setLocation(100,100);
    }

    /**
     * Replace the current shapes list with a new one
     * @param newShapes  the new list of shapes
     */
    public void setList(DrawableObjectList newShapes) {
    	shapes = newShapes;
    	canvas.setShapes(newShapes);
    }
    
    /**
     * Mark the window as "dirty," causing it to be redrawn at
     * the next opportunity. 
     */
    public void repaint() {
    	canvas.repaint();
    }
    
    /**
     * Display this DrawingTablet on the screen.
     */
    public void show() {
        myFrame.setVisible(true);
    }

    /**
     * Hide this DrawingTablet from view.
     */
    public void hide() {
        myFrame.setVisible(false);
    }

    /**
     * Add the specified DrawableObject object to the
     * list of DrawableObjects that are displayed in
     * this DrawingTablet.
     *
     * @param p the DrawableObject to be added.
     */
    public void drawShape(DrawableObject p) {
        shapes.addObject((DrawableObject)(p.clone()));
    }

    /**
     * Scale all of the Scaleable shapes currently
     * displayed on this DrawingTablet by the 
     * specified factor.
     *
     * @param factor the factor by which to scale the
     *               shapes.
     */
    public void scaleAllShapes(double factor) {
        shapes.scaleAllObjects(factor);
    }
    
    /**
     * Asks the DrawableObjectList to write all its objects to an output file.
     * 
     * @param filename the output file name
     */
    public void write(String filename) {
    	shapes.write(filename);
    }
}

