import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class TileUIComponent {
	
	Point upperLeft, lowerRight; // the upper left and lower right hand corner cordinates

	// TODO - change this to width and height in tiles
	int height, width; // width and height in tiles of 
	int tw, th; // tile width and height in pixels

	ImageFont imf;
	TileBorderInfo border;

	public TileUIComponent (int x, int y, int width, int height, ImageFont imf) {
		this.upperLeft = new Point(x, y);
		this.lowerRight = new Point(x + width, y + height);
		this.width = width;
		this.height = height;

		this.imf = imf;
		this.tw = imf.tileWidth();
		this.th = imf.tileHeight();
		char[] corners = {'*', '*', '*', '*'};
		char[] lineChars = {'-', '|', '-', '|'};
		border = new TileBorderInfo(true, 6, 3, corners, lineChars);
	}

	protected void paint(Graphics g) {
		imf.drawChar(border.corner(0), 0, 0, g);
		imf.drawChar(border.corner(0), 0, 3*th, g);

	}

	// Getter methods
	public Point upperLeft() {return this.upperLeft; }
	public int width() {return this.width; }
	public int height() {return this.height; }
}
