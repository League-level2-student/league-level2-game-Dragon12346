import javax.swing.Timer;
import java.awt.Color;
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
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener {
	Scene DumpS;
	Scene MenuS;
	Player hero;
	Timer frameDraw;
	  final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	public GamePanel() {
		hero = new Player(480,210,100,150,"hero");
		DumpS = new Scene();
		DumpS.add(new GameObject(0,0,800,800,"DumpsterBase.png"));
		DumpS.add(new GameObject(550,190,250,250,"dumpster.png"));
		DumpS.add(new GameObject(0,0,170,210,"trashcan.png"));
		DumpS.add(new GameObject(30,110,100,100,"TrashBags.png"));
		MenuS = new Scene();
		MenuS.add(new GameObject(0, 0, 800, 800, "CastleBackground.gif"));
		MenuS.add(new GameObject(40, 600, 300, 100, "StartButton.png"));
		MenuS.add(new GameObject(450, 600, 300, 100, "HelpButton.png"));
		frameDraw = new Timer(1000 / 120, this);
		frameDraw.start();
	}
	
	 void updateMenuState() {  }
	 void updateGameState() {  }
	 void updateEndState()  {  }
	 void drawMenuState(Graphics g) { MenuS.draw(g); }
	 void drawGameState(Graphics g) { DumpS.draw(g); hero.draw(g); }
	 void drawEndState(Graphics g)  {  }
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
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
	}
	@Override
	public void actionPerformed(ActionEvent e) { 
		repaint();
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
				System.out.println("REEEEEEEEEEEEEEEEEE");
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
