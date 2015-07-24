import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class RainbowTiles extends Component {

	static final int numRows = 8;
	static final int numCols = 32;
	static final int numTiles = numRows * numCols;

	BufferedImage img;
	int imgWidth, imgHeight;
	BufferedImage[] tiles;
	int tileWidth, tileHeight;

	static JFrame f;
	static int sleepTime = 15;

	int frameCounter;

	public void paint(Graphics g) {
		for(int curTile = 0; curTile < numTiles; curTile++){
			int redVal= 0, greenVal = 0, blueVal = 0;
			int tileFrameDiff = curTile - frameCounter;
			if(tileFrameDiff >= 0 && tileFrameDiff < 43) {
				redVal = 255 ;
				greenVal = tileFrameDiff * 6;
				blueVal = 0;
			} else if (tileFrameDiff >= 43 && tileFrameDiff < 85 ){
				redVal = 255 - (tileFrameDiff - 43) * 6;
				greenVal = 255;
				blueVal = 0;
			} else if (tileFrameDiff >= 85 && tileFrameDiff < 128 ){
				redVal = 0;
				greenVal = 255;
				blueVal = (tileFrameDiff - 85) * 6;
			} else if (tileFrameDiff >= 128 && tileFrameDiff < 171 ){
				redVal = 0;
				greenVal = 255 - (tileFrameDiff - 128) * 6;
				blueVal = 255;
			} else if (tileFrameDiff >= 171 && tileFrameDiff < 213 ){
				redVal = (tileFrameDiff - 171) * 6;
				greenVal = 0;
				blueVal = 255;
			} else if (tileFrameDiff >= 213 && tileFrameDiff < 256 ){
				redVal = 255;
				greenVal = 0;
				blueVal = 255 - (tileFrameDiff - 213) * 6;
			}
		   	else if(tileFrameDiff >= -255  && tileFrameDiff < -213 ) {
				redVal = 255;
				greenVal = (tileFrameDiff + 256) * 6;
				blueVal = 0;
			} else if(tileFrameDiff >= -213 && tileFrameDiff < -171) {
				redVal = 255 - (tileFrameDiff + 213) * 6;
				greenVal = 255;
				blueVal = 0;
			} else if(tileFrameDiff >= -171 && tileFrameDiff < -128) {
				redVal = 0;
				greenVal = 255;
				blueVal = (tileFrameDiff + 171) * 6;
			} else if(tileFrameDiff >=-128 && tileFrameDiff < -85) {
				redVal = 0;
				greenVal = 255 - (tileFrameDiff + 128) * 6;
				blueVal = 255;
			} else if(tileFrameDiff >=-85 && tileFrameDiff < -43) {
				redVal = (tileFrameDiff + 85) * 6;
				if(redVal > 255) redVal = 255;
				greenVal = 0;
				blueVal = 255;
			} else if(tileFrameDiff >=-43 && tileFrameDiff < 0) {
				redVal = 255;
				greenVal = 0;
				blueVal = 255 - (tileFrameDiff + 43) * 6;
			}

			for(int i = 0; i < tileWidth; i++) {
				for(int j = 0; j < tileHeight; j++) {
					Color c = new Color(tiles[curTile].getRGB(i, j), true);
					Color nc = new Color(redVal, greenVal, blueVal, c.getAlpha());
					tiles[curTile].setRGB(i, j, nc.getRGB());
				}
			}

			g.drawImage(tiles[curTile], (curTile % numCols) * tileWidth, (curTile / numCols) * tileHeight, null);
		}
	}

	public RainbowTiles() {
		try{
			img = convertToARGB(ImageIO.read(new File("CodePageTransparent.png")));
			imgWidth = img.getWidth();
			imgHeight = img.getHeight();

			tiles = new BufferedImage[numTiles];
			tileWidth = imgWidth / numCols;
			tileHeight = imgHeight / numRows;

			for(int i = 0; i < numCols; i++) {
				for(int j = 0; j < numRows; j++) {
					tiles[(numCols * j) + i] = img.getSubimage(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
				}
			}

			frameCounter = 0;

		} catch (IOException e) {
			System.out.println("Couldn't load the image: " + e);
		}
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100,100);
		} else {
			return new Dimension(imgWidth, imgHeight);
		}
	}

	public static BufferedImage convertToARGB(BufferedImage image) {
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}

	private void animate() {
		while(true) {
			if(frameCounter < 255) frameCounter++;
			else frameCounter = 0;

			try{
				Thread.sleep(sleepTime);
			} catch (Exception e) {}
			f.repaint();
		}
	}

	public static void main(String[] args) {
		f = new JFrame("Load Image Sample");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		RainbowTiles t = new RainbowTiles();

		f.getContentPane().setBackground(Color.BLACK);
		f.add(t);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
		t.animate();
	}
}
