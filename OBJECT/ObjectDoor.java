package OBJECT;

import java.io.IOException;
import javax.imageio.ImageIO;
import MAIN.GamePanel;

public class ObjectDoor extends SuperObject {
    GamePanel gp;

    public ObjectDoor(GamePanel gp) {
        this.gp = gp;
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/RESOURCES/OBJECTS/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}