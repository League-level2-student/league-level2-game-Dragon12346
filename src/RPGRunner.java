 import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RPGRunner {
	GamePanel gp = new GamePanel();
	 JFrame frame = new JFrame();
	 static int WIDTH = 800;
	 static int HEIGHT = 800;
public static void main(String[] args) {
RPGRunner F = new RPGRunner();
F.setup();
}
void setup(){
	frame.add(gp);
	frame.addKeyListener(gp);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setCursor();
	frame.addMouseListener(gp);
}
	void setCursor() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image im = tk.getImage("src/CursorOrig.png");
		Cursor mouse = tk.createCustomCursor(im, new Point(0,0),"img");
		frame.setCursor(mouse);
	}
}
