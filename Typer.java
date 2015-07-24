import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Typer extends JComponent implements KeyListener {

	static JFrame f;
	ImageFont imageF;

	static final int cols = 80;
	static final int rows = 25;

	int width, height;
	int tWidth, tHeight;
	int x, y;

	char[][] tiles;

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, width, height);
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				imageF.drawChar(tiles[i][j], i*tWidth, j*tHeight, g);
			}
		}
	}

	public Typer() {
		imageF = new ImageFont("CodePageTransparent.png");
		this.tWidth = imageF.tileWidth();
		this.tHeight = imageF.tileHeight();
		this.width = tWidth * (cols - 1);
		this.height = tHeight * (rows - 1);
		this.x = 0;
		this.y = 0;

		tiles = new char[cols][rows];
		tiles[0][0] = '_';

		addKeyListener(this);
		setFocusable(true);
	}

	public void keyTyped(KeyEvent e) {
		tiles[x][y] = e.getKeyChar();
		f.repaint();
		if(x < cols - 1) {
			x++;
		} else {
			x = 0;
			if(y < rows - 1) y++;
			else y = 0;
		}
		tiles[x][y] = '_';
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}

	private void writeObject(java.io.ObjectOutputStream stream) { throw new Error("Serialization not expected!"); }

	public static void main(String[] args) {
		f = new JFrame("Type Away, my friend");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Typer t = new Typer();

		f.getContentPane().setBackground(Color.BLACK);
		f.add(t);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
}
