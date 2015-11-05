import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class MainGameMockup extends Component {
	static JFrame f;
	ImageFont imageF;
	int tw, th;
	int tilesWide, tilesHigh;
	int width, height;
	Color uiColor;

	public MainGameMockup() {
		imageF = new ImageFont("CodePageTransparent.png");
		this.tw = imageF.tileWidth();
		this.th = imageF.tileHeight();

		tilesWide = 80;
		tilesHigh = 30;

		width = this.tw * tilesWide;
		height = this.th * tilesHigh;

		uiColor = Color.WHITE;
	}

	public void paint(Graphics g) {
		// main gameplay box
		imageF.drawTileNumC(ImageFont.T_UP_LEFT_CORNER, 0, 0, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_LEFT_CORNER, 0, 19*th, uiColor, g);	
		for(int i = 1; i < 59; i++) {
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 0, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 19*th, uiColor, g);
		}
		imageF.drawTileNumC(ImageFont.T_UP_RIGHT_CORNER, 59*tw, 0, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_RIGHT_CORNER, 59*tw, 19*th, uiColor, g);	
		for(int i = 1; i < 19; i++) {
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 0, i*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 59*tw, i*th, uiColor, g);
		}

		// text entry box
		imageF.drawTileNumC(ImageFont.T_UP_LEFT_CORNER, 0, 20*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_LEFT_CORNER, 0, 29*th, uiColor, g);	
		for(int i = 1; i < 59; i++) {
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 20*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 29*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 27*th, uiColor, g); // text entry line
		}
		imageF.drawTileNumC(ImageFont.T_UP_RIGHT_CORNER, 59*tw, 20*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_RIGHT_CORNER, 59*tw, 29*th, uiColor, g);	
		for(int i = 21; i < 29; i++) {
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 0, i*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 59*tw, i*th, uiColor, g);
		}
		// scroll bar line
		for(int i = 21; i < 27; i++) {
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 57*tw, i*th, uiColor, g);
		}
		// scroll bar
		imageF.drawTileNumC(ImageFont.T_UP_TRIANGLE, 58*tw, 21*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_DOWN_TRIANGLE, 58*tw, 26*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_SMILEY, 58*tw, 22*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_INVERTED_SMILEY, 58*tw, 22*th, uiColor, g);	
		// prompt
		imageF.drawCharC('>', 58*tw, 22*th, uiColor, g);	
		
		// stats box
		imageF.drawTileNumC(ImageFont.T_UP_LEFT_CORNER, 60*tw, 0, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_LEFT_CORNER, 60*tw, 29*th, uiColor, g);	
		for(int i = 61; i < 79; i++) {
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 0, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_HORIZONTAL_BAR, i*tw, 29*th, uiColor, g);
		}
		imageF.drawTileNumC(ImageFont.T_UP_RIGHT_CORNER, 79*tw, 0, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_BOT_RIGHT_CORNER, 79*tw, 29*th, uiColor, g);	
		for(int i = 1; i < 29; i++) {
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 60*tw, i*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 79*tw, i*th, uiColor, g);
			imageF.drawTileNumC(ImageFont.T_VERT_BAR, 77*tw, i*th, uiColor, g);
		}
		// scroll bar
		imageF.drawTileNumC(ImageFont.T_UP_TRIANGLE, 78*tw, 1*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_DOWN_TRIANGLE, 78*tw, 28*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_SMILEY, 78*tw, 2*th, uiColor, g);	
		imageF.drawTileNumC(ImageFont.T_INVERTED_SMILEY, 78*tw, 2*th, uiColor, g);	
	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	private void writeObject(java.io.ObjectOutputStream stream) { throw new Error("Serialization not expected!"); }

	public static void main(String[] args) {
		f = new JFrame("Game mockup");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		MainGameMockup mgm = new MainGameMockup();

		f.getContentPane().setBackground(Color.BLACK);
		f.add(mgm);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
}
