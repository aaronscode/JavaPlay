import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class OneChar extends Component {


	static JFrame f;
	ImageFont imageF;

	public void paint(Graphics g) {
		imageF.drawTileNum(imageF.T_UP_TRIANGLE, 0, 0, g);
	}

	public OneChar() {
		imageF = new ImageFont("CodePageTransparent.png");
	}

	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}

	public static void main(String[] args) {
		f = new JFrame("Testing ImageFont");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		OneChar oc = new OneChar();

		f.getContentPane().setBackground(Color.BLACK);
		f.add(oc);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
}
