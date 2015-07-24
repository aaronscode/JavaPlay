import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class TextBoxTester extends Component {
    
	StaticTileTextBox sttb;

	static JFrame f;
	ImageFont imageF;

	public TextBoxTester() {
		imageF = new ImageFont("CodePageTransparent.png");
		sttb = new StaticTileTextBox(0, 0, 100, 100, imageF, "Hello!");
	}

	public void paint(Graphics g) {
		sttb.paint(g);
	}

	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}

	private void writeObject(java.io.ObjectOutputStream stream) { throw new Error("Serialization not expected!"); }

	public static void main(String[] args) {
		f = new JFrame("Type Away, my friend");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		TextBoxTester tbt = new TextBoxTester();

		f.getContentPane().setBackground(Color.BLACK);
		f.add(tbt);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
}
