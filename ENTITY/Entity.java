package ENTITY;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;
    public String direction;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int spriteCounter = 0;
    public boolean collisionOn = false;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
}