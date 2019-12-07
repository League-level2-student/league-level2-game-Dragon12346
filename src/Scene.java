import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {
ArrayList<GameObject> sceneObjects = new ArrayList <GameObject>();
	void draw (Graphics g) { 
		for (GameObject o : sceneObjects) {
			o.draw(g);
		}
	}
	
}
