import java.util.Arrays;

public class TileBorderInfo {
	
	int[] outerPadding = {0, 0, 0, 0}; // num of tiles to pad on each side (up-right-down-left) outside border
	int[] innerPadding = {0, 0, 0, 0}; // num tiles to padd on each side inside border

	boolean hasBorder =  false;
	// TODO - Create Tile class to use instead of chars - can encode colors and whatnot
	char[] corners; // the tile to use for the corner of the border
	char[] topLine;
	char[] botLine;
	char[] rightLine;
	char[] leftLine;

	int width = 0, height = 0; // width and height in tiles

	public TileBorderInfo(boolean hasBorder, int width, int height) {
		this.hasBorder = hasBorder;
		this.width = width;
		this.height = height;
	}
	public TileBorderInfo(boolean hasBorder, int width, int height, char corner, char lineChar) {

	}

	public TileBorderInfo(boolean hasBorder, int width, int height, char corner, char lineChar, int innerPadding, int outerPadding) {

	}

	public TileBorderInfo(boolean hasBorder, int width, int height, char[] corners, char[] lineChars) {
		this.hasBorder = hasBorder;
		this.width = width;
		this.height = height;

		this.corners = corners; 
		this.topLine = new char[width];
		this.botLine = new char[width];
		this.rightLine = new char[height];
		this.leftLine = new char[height];
		Arrays.fill(this.topLine, lineChars[0]);
		Arrays.fill(this.botLine, lineChars[1]);
		Arrays.fill(this.rightLine, lineChars[2]);
		Arrays.fill(this.leftLine, lineChars[3]);
		
	}

	public TileBorderInfo(int width, int height, boolean hasBorder, char[] corners, char[] lineChars, int innerPadding, int outerPadding) {
		this.hasBorder = hasBorder;
		this.width = width;
		this.height = height;

		this.corners = corners; 
		this.topLine = new char[width];
		this.botLine = new char[width];
		this.rightLine = new char[height];
		this.leftLine = new char[height];
		Arrays.fill(this.topLine, lineChars[0]);
		Arrays.fill(this.botLine, lineChars[1]);
		Arrays.fill(this.rightLine, lineChars[2]);
		Arrays.fill(this.leftLine, lineChars[3]);
		
		Arrays.fill(this.innerPadding, innerPadding);
		Arrays.fill(this.outerPadding, outerPadding);
	}

	// TODO - getters and setters
	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}

	public char corner(int i) {
		return this.corners[i];
	}

	public char[] corners() {
		return this.corners;
	}

	public char[] topLine() {
		return this.topLine;
	}

	public char[] botLine() {
		return this.botLine;
	}

	public char[] rightLine() {
		return this.rightLine;
	}

	public char[] leftLine() {
		return this.leftLine;
	}
}
