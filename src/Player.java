import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Player(int x, int y, int width, int height, String fileName) {
		super(x, y, width, height, fileName);
		if (needImage) {
			loadImage("TrashBags.png");
		}
	}

	void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
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
}