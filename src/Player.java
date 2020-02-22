import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	public static BufferedImage[] image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int imageNum = 0;
	Player(int x, int y, int width, int height, String fileName, int health) {
		super(x, y, width, height, fileName);
		image = new BufferedImage[4];
		needImage = true;
		if (needImage) {
			loadImage(fileName);
		}
	}

	void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image[imageNum], x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void right() {
		x += speed;
		imageNum=0;
	}

	public void left() {
		x -= speed;
		imageNum=1;
	}

	public void up() {
		y -= speed;
		imageNum=2;
	}

	public void down() {
		y += speed;
		imageNum=3;
	}
	
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image[0] = ImageIO.read(this.getClass().getResourceAsStream(imageFile + "Right.png"));
				image[1] = ImageIO.read(this.getClass().getResourceAsStream(imageFile + "Left.png"));
				image[2] = ImageIO.read(this.getClass().getResourceAsStream(imageFile + "Right.png"));
				image[3] = ImageIO.read(this.getClass().getResourceAsStream(imageFile + "Right.png"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}