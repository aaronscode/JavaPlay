import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class TileUIComponent {
	
	Point upperLeft, lowerRight; // the upper left and lower right hand corner cordinates

	int height, width; // width and height in tiles 
	int pixHeight, pixWidth; // width and height in pixels
	int tw, th; // tile width and height in pixels

	ImageFont imf;
	TileBorderInfo border;

	public TileUIComponent (int x, int y, int width, int height, ImageFont imf, TileBorderInfo border) {
		this.width = width;
		this.height = height;

		this.imf = imf;
		this.tw = imf.tileWidth();
		this.th = imf.tileHeight();

		this.pixWidth = width * this.tw;
		this.pixHeight = height * this.th;

		this.upperLeft = new Point(x, y);
		this.lowerRight = new Point(x + pixWidth, y + pixHeight);

		this.border = border;
	}

	protected void paint(Graphics g) {
		// TODO draw borders accounting for margin
		imf.drawChar(border.corner(0), upperLeft.x, upperLeft.y, g);
		imf.drawChar(border.corner(1), lowerRight.x, upperLeft.y, g);
		imf.drawChar(border.corner(2), lowerRight.x, lowerRight.y, g);
		imf.drawChar(border.corner(2), upperLeft.x, lowerRight.y, g);
		for(int i = 1; i < border.width(); i++) {
			imf.drawChar(border.topLineChar(i-1), upperLeft.x + i*tw, upperLeft.y, g);
			imf.drawChar(border.botLineChar(i-1), upperLeft.x + i*tw, lowerRight.y, g);
		}
	}

	// Getter methods
	public Point upperLeft() {return this.upperLeft; }
	public int width() {return this.width; }
	public int height() {return this.height; }
}
