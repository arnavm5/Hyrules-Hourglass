import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;


public class Player extends Character{

    private boolean isInside;
    private boolean left, right, up, down, shift, leftClick;
    private int lastKey;
    private double timePressed;

    public Player(int x, int y, int health, int speed, boolean isInside) {
        super(x, y, health, speed, false);
        this.isInside = isInside;
        left = false;
        right = false;
        up = false;
        down = false;
        shift = false;
        leftClick = false;
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

    public boolean isShift() {
        return shift;
    }

    public boolean isleftClick() {
        return leftClick;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeftClick(boolean leftClick) {
        this.leftClick = leftClick;
    }

    public void keyPressedPlayer(int key){
        if (key == 87) {
            up = true;
            down = false;
            left = false;
            right = false;
        }
        else if (key == 83) {
            down = true;
            up = false;
            left = false;
            right = false;
        }
        else if (key == 65) {
            left = true;
            up = false;
            down = false;
            right = false;
        }
        else if (key == 68) {
            right = true;
            left = false;
            up = false;
            down = false;
        }
        if (key == 16){
            shift = true;
        }
    }

    public void mousePressedPlayer(int button){
        if(button == 1){
            leftClick = true;
        }
    }

    public void mouseReleasedPlayer(int button){
        if(button == 1){
            leftClick = false;
        }
    }


    public void keyReleasedPlayer(int key){
        //System.out.println(timePressed);
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
        if(key == 16){
            shift = false;
        }
    }

    public void timePressedMove(){
        if(up || down || left || right || leftClick){
            timePressed += 0.4;
            if(timePressed > 11) {
                timePressed = timePressed % 11;
            }
        }
        else{
            timePressed = 0;
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

    public void moveScene(ArrayList<Rectangle> gameSceneObjects, Rectangle r) {
        if(!isInside){
            if(gameSceneObjects.size() > 0) {
                if (up) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() + getSpeed());
                    }
                    r.setY(r.getY() + getSpeed());
                }
                if (down) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() - getSpeed());
                    }
                    r.setY(r.getY() - getSpeed());
                }
                if (left) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() + getSpeed());
                    }
                    r.setX(r.getX() + getSpeed());
                }
                if (right) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() - getSpeed());
                    }
                    r.setX(r.getX() - getSpeed());
                }
            }
        }
    }

    public void paintPlayer(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon link = new ImageIcon(Player.class.getResource("Assets/Link/tile000.png"));

        if(leftClick && timePressed < 6 && !right && !left){
            if(lastKey == 3){
                setW(67);
                link = new ImageIcon(Player.class.getResource("Assets/Link/linkSwordLeft.png"));
            }
            else if(lastKey == 4){
                setW(67);
                link = new ImageIcon(Player.class.getResource("Assets/Link/linkSwordRight.png"));
            }
        }

        else if(up) {
            for(int i = 48; i <= timePressed + 48; i++) {
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile0" + i + ".png"));
            }
        }
        else if(down) {
            for(int i = 24; i <= timePressed + 24; i++) {
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile0" + i + ".png"));
            }
        }
        else if(left && !leftClick) {
            for(int i = 36; i <= timePressed + 36; i++) {
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile0" + i + ".png"));
            }
        }
        else if(right && !leftClick) {
            for (int i = 12; i <= timePressed + 12; i++) {
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile0" + i + ".png"));
            }
        }
        else{
             setW(50);
            if(lastKey == 1){
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile000.png"));
            }
            else if(lastKey == 2){
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile024.png"));
            }
            else if(lastKey == 3){
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile037.png"));
            }
            else if(lastKey == 4){
                link = new ImageIcon(Player.class.getResource("Assets/Link/tile013.png"));
            }
        }
        g2d.drawImage(link.getImage(), getX(), getY(), getW(), getH(), null);
        //g.setColor(Color.BLUE);
        //g.fillRect(getX(), getY(), getW(), getH());
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

    public void recCollision(Rectangle r, int wallPixLenX, int wallPixLenY){
        int linkRX = getX() + wallPixLenX;
        int linkRW = getX() + getW() - wallPixLenX;
        int linkRY = getY() + wallPixLenY;
        int linkRH = getY() + getH();

        if(r.getX() < linkRW && r.getX() + r.getW() > linkRX && r.getY() < linkRH && r.getY() + r.getH() > linkRY) {
                if (linkRX - getSpeed() <= r.getX() + r.getW() && linkRX + getSpeed() > r.getX() + r.getW() * 0.90 && left) {
                    setX(r.getX() + r.getW() - wallPixLenX);
                    System.out.println("X Right");
                }
                else if (linkRW + getSpeed() >= r.getX() && linkRW - getSpeed() < r.getX() + r.getW() * 0.10 && right) {
                    setX(r.getX() - getW() + wallPixLenX);
                    System.out.println("X Left");
                }
                else if (linkRY - getSpeed() <= r.getY() + r.getH() && linkRY + getSpeed() > r.getY() + r.getH() * 0.90 && up) {
                    setY(r.getY() + r.getH() - wallPixLenY);
                    System.out.println("Y Down");
                }
                else if (linkRH + getSpeed() >= r.getY() && linkRH - getSpeed() < r.getY() + r.getH() * 0.10 && down) {
                    setY(r.getY() - getH());
                    System.out.println("Y Up");
                }
                setInside(true);
        }
    }


}
