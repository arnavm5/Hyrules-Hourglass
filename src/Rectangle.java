import java.awt.*;
import javax.swing.ImageIcon;

public class Rectangle {

    private int x;
    private int y;
    private int w;
    private int h;
    private boolean isOnEdge;

    public Rectangle(int x, int y, int w, int h, boolean isOnEdge) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isOnEdge = isOnEdge;
    }

    public String toString() {
        return "Rectangle: " + x + "," + y + "," + w + "," + h;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }
    public boolean isOnEdge() {
        return isOnEdge;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setW(int w) {
        this.w = w;
    }
    public void setH(int h) {
        this.h = h;
    }
    public void setOnEdge(boolean onEdge) {
        isOnEdge = onEdge;
    }

    public void screenCollision(Player p, int dist){
        if(p.isLeft() || p.isRight()){
            if(Math.abs(p.getX() - getX()) < dist || Math.abs((p.getX() + p.getW()) - (getX() + w)) < dist)
                setOnEdge(true);
            else{
                setOnEdge(false);
            }
        }
        if(p.isUp() || p.isDown()){
            if(Math.abs(p.getY()-getY()) < dist || Math.abs((p.getY() + p.getH())-(getY() + h)) < dist){
                setOnEdge(true);
            }  
            else
                setOnEdge(false);
        }
    }
}
