package comp132.drawable;


public class Animation {
	DrawableObjectList beforeList;
	DrawableObjectList middleList;
	DrawableObjectList middleList2;
	DrawableObjectList afterList;
	
	/**
	 * Create a new Animation object from two keyframe data files.
	 *
	 * @param before the name of the file containing the starting keyframe data
	 * @param after the name of the file containing the ending keyframe data
	 */
	public Animation(String before, String middle, String middle2, String After ) {
		beforeList = new DrawableObjectList(before);
		middleList = new DrawableObjectList(middle);
		middleList2 = new DrawableObjectList(middle2);
		afterList = new DrawableObjectList(After);
	}

	/**
	 * Run the animation from the "before" keyframe to the "after" keyframe.
	 * In-between frames are interpolated on the fly.
	 */
	public void run() throws InterruptedException {
		//create and show DrawingTablet with initial keyframe
		DrawingTablet dt = new DrawingTablet(400,400, beforeList);
		dt.show();

		//interpolate frames and display each one in turn
		while(true){
			int nFrames = 10;
			for (int i=1; i < nFrames; i++) {
				double time = (double)i / nFrames;
				DrawableObjectList currList = beforeList.interpolate(middleList, time);
				dt.setList(currList);
				Thread.sleep(100);
				dt.repaint();
			}
			for (int i=1; i < nFrames; i++) {
				double time = (double)i / nFrames;
				DrawableObjectList currList = middleList.interpolate(middleList2, time);
				dt.setList(currList);
				Thread.sleep(100);
				dt.repaint();
			}
			for (int i=1; i < nFrames; i++) {
				double time = (double)i / nFrames;
				DrawableObjectList currList = middleList2.interpolate(afterList, time);
				dt.setList(currList);
				Thread.sleep(100);
				dt.repaint();
			}
		
		}
			
	}
	
	/* main driver program */
	public static void main(String[] args) throws InterruptedException {
		//create and run an animation based on before and after keyframe files
		Animation anim = new Animation("keyframe0.dat", "keyframe1.dat","keyframe2.dat", "keyframe3.dat");
		anim.run();
	}
}

