import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Imager extends Component {

	BufferedImage img;
	int imgWidth, imgHeight;

	public void paint(Graphics g) {
		for(int i = 0; i < imgWidth; i++) {
			for(int j = 0; j < imgHeight; j++) {
				Color c = new Color(img.getRGB(i, j), true);
				Color nc = new Color(255, 0, 0, c.getAlpha());
				img.setRGB(i, j, nc.getRGB());
			}
		}

		g.drawImage(img, 0, 0, null);
	}

	public Imager() {
		try{
			img = convertToARGB(ImageIO.read(new File("CodePageTransparent.png")));
			imgWidth = img.getWidth();
			imgHeight = img.getHeight();
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

	public static void main(String[] args) {
		JFrame f = new JFrame("Load Image Sample");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.getContentPane().setBackground(Color.BLACK);
		f.add(new Imager());
		f.pack();
		f.setVisible(true);
	}
}
