import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener {
	Scene DumpS;
	Scene HelpM;
	Scene MenuS;
	Scene HelpS;
	Scene SkF;
	Player hero;
	Timer frameDraw;
	JFrame frame;
	final int MENU = 0;
	final int GAME = 1;
	final int HELP = 2;
	final int SkF1 = 3;
	int currentState = MENU;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public GamePanel() {
		hero = new Player(480, 210, 100, 150, "hero", 100);
		DumpS = new Scene();
		HelpS = new Scene();
		DumpS.add(new GameObject(0, 0, 800, 800, "DumpsterBase.png"));
		DumpS.add(new GameObject(550, 190, 250, 250, "dumpster.png"));
		DumpS.add(new GameObject(0, 0, 170, 210, "trashcan.png"));
		DumpS.add(new GameObject(30, 110, 100, 100, "TrashBags.png"));
		DumpS.add(new GameObject(300,300,150,170,"skele.png"));
		MenuS = new Scene();
		MenuS.add(new GameObject(0, 0, 800, 800, "CastleBackground.gif"));
		MenuS.add(new GameObject(40, 600, 300, 100, "StartButton.png"));
		MenuS.add(new GameObject(450, 600, 300, 100, "HelpButton.png"));
		HelpM = new Scene();
		HelpM.add(new GameObject(0, 0, 800, 800, "helpMenu.png"));
		HelpM.add(new GameObject(0, 0, 890, 100, "helpTitle.png"));
		SkF = new Scene();
		SkF.add(new GameObject(0, 0, 890, 1000, ".png"));
		frameDraw = new Timer(1000 / 120, this);
		frameDraw.start();
	}

	void updateMenuState() {
	}

	void updateGameState() {
		hero.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		MenuS.draw(g);
	}

	void drawGameState(Graphics g) {
		DumpS.draw(g);
		hero.draw(g);
	}

	void drawHelpState(Graphics g) {
		HelpM.draw(g);
	}
	
	void drawSkF(Graphics g) {
		SkF.draw(g);
	}
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == HELP) {
			drawHelpState(g);
		} else if (currentState == SkF1) {
			drawSkF(g);
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (hero.x > 0) {
				hero.left();
			} else {
				hero.x = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (hero.x + 50 < RPGRunner.WIDTH) {
				hero.right();
			} else {
				hero.x = RPGRunner.WIDTH - 50;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			if (hero.y < RPGRunner.HEIGHT - 70) {
				hero.down();
			} else {
				hero.y = RPGRunner.HEIGHT - 70;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (hero.y > 0) {
				hero.up();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			
			}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
			if (currentState == GAME) {
				System.out.println(hero.x + " " + hero.y);
					if (hero.collisionBox.intersects((DumpS.sceneObjects.get(4)).collisionBox)) {
						currentState = SkF1;
					}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == GAME) {
			updateGameState();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			if (MenuS.sceneObjects.get(1).isClicked(e.getX(), e.getY())) {
				currentState = GAME;
			}
			if (MenuS.sceneObjects.get(2).isClicked(e.getX(), e.getY())) {
				currentState = HELP;
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
