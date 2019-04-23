import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;


public class Player extends Character{

    private boolean isInside;
    private boolean left, right, up, down;
    private int lastKey;
    private double timePressed;

    public Player(int x, int y, int health, int speed, boolean isInside) {
        super(x, y, health, speed, false);
        this.isInside = isInside;
        left = false;
        right = false;
        up = false;
        down = false;
        lastKey = 1;
        timePressed = 0;
    }

    public boolean isInside() {
        return isInside;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    private void setLeft(boolean left) {
        this.left = left;
    }

    private void setRight(boolean right) {
        this.right = right;
    }

    private void setUp(boolean up) {
        this.up = up;
    }

    private void setDown(boolean down) {
        this.down = down;
    }

    public void keyPressedPlayer(int key){
        timePressed += 0.6;
        if(timePressed > 11) {
            timePressed = timePressed % 11;
        }
        if (key == 87) {
            up = true;
        }
        if (key == 83) {
            down = true;

        }
        if (key == 65) {
            left = true;
        }
        if (key == 68) {
            right = true;
        }
    }

    public void keyReleasedPlayer(int key){
        //System.out.println(timePressed);
        timePressed = 0;
        if (key == 87) {
            up = false;
            lastKey = 1;
        }
        if (key == 83) {
            down = false;
            lastKey = 2;
        }
        if (key == 65) {
            left = false;
            lastKey = 3;
        }
        if (key == 68) {
            right = false;
            lastKey = 4;
        }
    }


    public void movePlayer() {
        if (isInside) {
            if (up) {
                setY(getY() - getSpeed());
            }
            if (down) {
                setY(getY() + getSpeed());
            }
            if (left) {
                setX(getX() - getSpeed());
            }
            if (right) {
                setX(getX() + getSpeed());
            }
        }
    }

    public void moveScene(ArrayList<Rectangle> gameSceneObjects) {
        if(!isInside){
            if(gameSceneObjects.size() != 0) {
                if (up) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() + getSpeed());
                    }
                }
                if (down) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() - getSpeed());
                    }
                }
                if (left) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() + getSpeed());
                    }
                }
                if (right) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() - getSpeed());
                    }
                }
            }
        }
    }

    public void paintPlayer(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile000.png"));

        if(up) {
            for(int i = 48; i <= timePressed + 48; i++) {
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile0" + i + ".png"));
            }
        }
        else if(down) {
            for(int i = 24; i <= timePressed + 24; i++) {
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile0" + i + ".png"));
            }
        }
        else if(left) {
            for(int i = 36; i <= timePressed + 36; i++) {
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile0" + i + ".png"));
            }
        }
        else if(right) {
            for(int i = 12; i <= timePressed + 12; i++) {
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile0" + i + ".png"));
            }
        }
        else{
            if(lastKey == 1){
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile000.png"));
            }
            else if(lastKey == 2){
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile024.png"));
            }
            else if(lastKey == 3){
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile037.png"));
            }
            else if(lastKey == 4){
                link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile013.png"));
            }
        }
        g2d.drawImage(link.getImage(), getX(), getY(), getW(), getH(), null);
    }

    public void sceneCollision(Rectangle room, int wallPixLenX, int wallPixLenY){
        if(getX() < room.getX() + wallPixLenX){
            setX(room.getX() + wallPixLenX);
        }
        if(getX() + getW() > room.getX() + room.getW() - wallPixLenX){
            setX(room.getX() + room.getW() - getW() - wallPixLenX);
        }
        if(getY() < room.getY() + wallPixLenY){
            setY(room.getY() + wallPixLenY);
        }
        if(getY() + getH() > room.getY() + room.getH() - wallPixLenY){
            setY(room.getY() + room.getH() - getH() - wallPixLenY);
        }
    }

    public void movementSwitch(Rectangle scene){
        if(scene.isOnEdge()){
            isInside = true;
        }
        else{
            isInside = false;
        }
    }




}
