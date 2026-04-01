package OBJECT;

import java.io.IOException;
import javax.imageio.ImageIO;
import MAIN.GamePanel;

public class ObjectChest extends SuperObject {
    GamePanel gp;

    public ObjectChest(GamePanel gp) {
        this.gp = gp;
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/RESOURCES/OBJECTS/chest (OLD).png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}