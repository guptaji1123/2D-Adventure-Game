package ENTITY;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import MAIN.GamePanel;
import MAIN.KeyHandler;

public class Player extends Entity {
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int standCount = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        speed = 4;
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        direction = "down";
    }

    public void getPlayerImage() {
        up1 = setUp("/RESOURCES/PLAYER/boy_up_1");
        up2 = setUp("/RESOURCES/PLAYER/boy_up_2");
        down1 = setUp("/RESOURCES/PLAYER/boy_down_1");
        down2 = setUp("/RESOURCES/PLAYER/boy_down_2");
        left1 = setUp("/RESOURCES/PLAYER/boy_left_1");
        left2 = setUp("/RESOURCES/PLAYER/boy_left_2");
        right1 = setUp("/RESOURCES/PLAYER/boy_right_1");
        right2 = setUp("/RESOURCES/PLAYER/boy_right_2");
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            }
            if (keyH.downPressed == true) {
                direction = "down";
            }
            if (keyH.leftPressed == true) {
                direction = "left";
            }
            if (keyH.rightPressed == true) {
                direction = "right";
            }
            collisionOn = false;
            gp.checker.checkTile(this);
            int objIndex = gp.checker.checkObject(this, true);
            pickUpObject(objIndex);
            int npcIndex = gp.checker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            standCount++;
            if (standCount == 20) {
                spriteNum = 1;
                standCount = 0;
            }
        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {
        }
    }

    public void interactNPC(int i) {
        if (i != 999) {
            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null);
    }
}