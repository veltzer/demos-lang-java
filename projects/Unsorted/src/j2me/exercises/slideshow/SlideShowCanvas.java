package j2me.exercises.slideshow;
import javax.microedition.lcdui.*;

/**
 * Canvas on which Slide Show images are displayed.
 */
public class SlideShowCanvas extends Canvas {
	private Image[] images;
	private int currentImageIndex = 0;

	/** Constructor. */
	public SlideShowCanvas(Image[] images) {
		this.images = images;
	}

	/** Renders the Canvas. The application must implement this method in order to paint any graphics. */
	public void paint(Graphics g) {
		clear(g);
		draw(g);
	}

	/** Clear entire canvas. */
	private void clear(Graphics g) {
		// Clear entire canvas.
		g.setColor(255, 255, 255); // White
		g.fillRect(0, 0, getWidth(), getHeight());

		// Draw border around canvas edges.
		g.setColor(0, 0, 0); // Black
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}

	/** Draw current image, centered horizontally and vertically. */
	private void draw(Graphics g) {
		g.drawImage(images[currentImageIndex], getWidth()/2, getHeight()/2, Graphics.HCENTER|Graphics.VCENTER);
	}

	/** Handle user key press event. */
	protected void keyPressed(int keyCode) {
		int action = getGameAction(keyCode); // Translate key code to game action for maximum portability

		if (action == LEFT)
			advanceBackward();
		else if (action == RIGHT)
			advanceForward();
	}

	/** Advance image index forward by one. */
	public void advanceForward() {
		if (currentImageIndex < images.length-1)
			++currentImageIndex;
		repaint();
	}

	/** Advance image index backward by one. */
	public void advanceBackward() {
		if (currentImageIndex > 0)
			--currentImageIndex;
		repaint();
	}
}
