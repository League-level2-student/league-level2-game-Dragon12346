import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;

	boolean isActive = true;
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	int speed = 15;


	GameObject(int x, int y, int width, int height, String fileName) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		collisionBox = new Rectangle();
		collisionBox.setBounds(x, y, width, height);
		if (needImage) {
			loadImage(fileName);
		}
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics g){
		 if (gotImage) {
				g.drawImage(image, x, y, width, height, null);}
			
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
	boolean isClicked(int x,int y) {
		Rectangle mouse = new Rectangle(x,y,1,1);
		if (mouse.intersects(collisionBox)) {
			return true;
		}
		return false;
	}
}
