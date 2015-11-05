import java.awt.Graphics;
import java.awt.Color;

public class StaticTileTextBox extends TileTextBox {
	String text;

	public StaticTileTextBox(int x, int y, int width, int height, ImageFont imf, String text) {
		super(x, y, width, height, imf);
		this.text = text;
	}

	public void paint(Graphics g) {
		super.paint(g);
		imf.drawStringC(text, upperLeft.x, upperLeft.y, Color.RED, g);
	}
}
