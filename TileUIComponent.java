import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class TileUIComponent {
	
	Point upperLeft, lowerRight; // the upper left and lower right hand corner cordinates

	int height, width; // width and height in pixels of text box
	int tw, th; // tile width and height in pixels

	ImageFont imf;

	public TileUIComponent (int x, int y, int width, int height, ImageFont imf) {
		this.upperLeft = new Point(x, y);
		this.lowerRight = new Point(x + width, y + height);
		this.width = width;
		this.height = height;

		this.imf = imf;
		this.tw = imf.tileWidth();
		this.th = imf.tileHeight();
	}

	public Point upperLeft() {return this.upperLeft; }
	public int width() {return this.width; }
	public int height() {return this.height; }
}
