import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Player extends Character{

    private boolean isInside;
    private boolean left, right, up, down;

    public Player(int x, int y, int health, int speed, boolean isInside) {
        super(x, y, health, speed, false);
        this.isInside = isInside;
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public boolean isInside() {
        return isInside;
    }

    private boolean isLeft() {
        return left;
    }

    private boolean isRight() {
        return right;
    }

    private boolean isUp() {
        return up;
    }

    private boolean isDown() {
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
        if (key == 87) {
            up = false;
        }
        if (key == 83) {
            down = false;
        }
        if (key == 65) {
            left = false;
        }
        if (key == 68) {
            right = false;
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
            link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile007.png"));
        }
        else if(down) {
            link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile030.png"));
        }
        else if(left) {
            link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile042.png"));
        }
        else if(right) {
            link = new ImageIcon(Player.class.getResource("Assests\\Link\\tile018.png"));
        }



        g2d.drawImage(link.getImage(), getX(), getY(), getW(), getH(), null);
        //g.setColor(Color.RED);
        //g.fillRect(getX(), getY(), getW(), getH());
    }

    public void sceneCollision(Rectangle room){
        if(getX() < room.getX()){
            setX(room.getX());
        }
        if(getX() + getW() > room.getX() + room.getW()){
            setX(room.getX() + room.getW() - getW());
        }
        if(getY() < room.getY()){
            setY(room.getY());
        }
        if(getY() + getH() > room.getY() + room.getH()){
            setY(room.getY() + room.getH() - getH());
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
