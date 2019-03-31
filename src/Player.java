import java.util.ArrayList;

public class Player extends Character{

    private boolean isInside;

    public Player(int x, int y, int health, int speed, boolean isInside) {
        super(x, y, health, speed);
        this.isInside = isInside;
    }

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public void movement(int key, ArrayList<Rectangle> gameSceneObjects){
        if(isInside){
            if (key == 87) {
                setY(getY() - getSpeed());
            }
            if (key == 83) {
                setY(getY() + getSpeed());
            }
            if (key == 65) {
                setX(getX() - getSpeed());
            }
            if (key == 68) {
                setX(getX() + getSpeed());
            }
        }
        else{
            if(gameSceneObjects.size() != 0) {
                if (key == 87) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() + getSpeed());
                    }
                }
                if (key == 83) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setY(o.getY() - getSpeed());
                    }
                }
                if (key == 65) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() + getSpeed());
                    }
                }
                if (key == 68) {
                    for (Rectangle o : gameSceneObjects) {
                        o.setX(o.getX() - getSpeed());
                    }
                }
            }
        }
    }

}
