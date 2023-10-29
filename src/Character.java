import javax.swing.*;
import java.awt.*;

public class Character extends Rectangle {

    private int health;
    private int speed;
    private boolean isAttacking;
    private boolean isBlocking;

    public Character(int x, int y, int health, int speed, boolean isOnEdge) {
        super(x, y, 50, 60, isOnEdge);
        this.health = health;
        this.speed = speed;
        isAttacking = false;
        isBlocking = false;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean IsAttacking() {
        return isAttacking;
    }

    public boolean IsBlocking() {
        return isBlocking;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public void setBlocking(boolean blocking) {
        isBlocking = blocking;
    }

    public void paintZelda(Graphics g, int x ){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon character;
        character = new ImageIcon(Rectangle.class.getResource("Assets/Zelda/00" + x + ".png"));
        g2d.drawImage(character.getImage(), getX(), getY(), getW() - 10, getH() - 14, null);
    }

    public void paintVaati(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon character;
        character = new ImageIcon(Rectangle.class.getResource("Assets/Extras/vaati.png"));
        g2d.drawImage(character.getImage(), getX(), getY(), getW() + 20, getH() + 20, null);
    }

}
