package OBJECT;

import java.io.IOException;
import javax.imageio.ImageIO;
import MAIN.GamePanel;

public class ObjectKey extends SuperObject {
    GamePanel gp;

    public ObjectKey(GamePanel gp) {
        this.gp = gp;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/RESOURCES/OBJECTS/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}