import java.awt.Graphics;
import java.awt.Color;

public class StaticTileTextBox extends TileTextBox {
	String text;

	public StaticTileTextBox(int x, int y, int width, int height, ImageFont imf, String text, TileBorderInfo border) {
		super(x, y, width, height, imf, border);
		this.text = text;
	}

	public StaticTileTextBox(int x, int y, int width, int height, ImageFont imf, String text) {
		this(x, y, width, height, imf, text, new TileBorderInfo(false, width, height));
	}

	public void paint(Graphics g) {
		super.paint(g);
		// TODO  - paint string correctly taking into account margins and border
		imf.drawStringC(text, upperLeft.x, upperLeft.y, Color.RED, g);
	}
}
