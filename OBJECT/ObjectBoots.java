package OBJECT;

import java.io.IOException;
import javax.imageio.ImageIO;
import MAIN.GamePanel;

public class ObjectBoots extends SuperObject {
    GamePanel gp;

    public ObjectBoots(GamePanel gp) {
        this.gp = gp;
        name = "Boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/RESOURCES/OBJECTS/boots.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}