import java.awt.*;

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

    public void paintRect(Color c, Graphics g){
        g.setColor(c);
        g.fillRect(getX(), getY(), getW(), getH());
    }

    public void screenCollision(int w, int h, Player p){

        if(getX() < 0){
            setX(0);
            setOnEdge(true);
        }
        else if(getX() + getW() > w){
            setX(w - getW());
            setOnEdge(true);
        }

        if(getY() <= 0){
            setY(0);
            setOnEdge(true);
        }
        else if(getY() + getH() >= h){
            setY(h - getH());
            setOnEdge(true);
        }


    }

}
