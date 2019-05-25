import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene {

    private ArrayList<Rectangle> houseObjects, villageObjects;
    private boolean inHouse, inVillage, inCastle, inForest;
    private Rectangle houseExit, villageExit, castleExit, forestExit;
    private int timeSceneChange;

    public Scene(){
        houseObjects = new ArrayList<Rectangle>();
        villageObjects = new ArrayList<Rectangle>();
        inHouse = true;
        inVillage = false;
        inCastle = false;
        inForest = false;
        timeSceneChange = 0;
    }

    public ArrayList<Rectangle> getHouseSceneObjects(Rectangle background){
       Rectangle firePlace1, firePlace2, workshopTable, table, fence1, fence2, picket;
       firePlace1 = new Rectangle(182 + background.getX(), 128 + background.getY(), 25, 30, false);
       firePlace2 = new Rectangle(250 + background.getX(), 128 + background.getY(), 29, 30, false);
       workshopTable = new Rectangle(75 + background.getX(), 70 + background.getY(), 44, 36, false);
       table = new Rectangle(scale(160, 1.875) + background.getX() - 5, scale(80,2) + background.getY(), scale(207, 1.875) - scale(160, 1.875), scale(110,2) - scale(80,2), false);
       fence1 = new Rectangle(scale(32, 1.875) + background.getX(), scale(80,2) + background.getY(), scale(86, 1.875) - scale(32, 1.875), scale(87,2) - scale(80,2), false);
       picket = new Rectangle(scale(80, 1.875) + background.getX(), scale(88,2) + background.getY(), scale(86, 1.875) - scale(80, 1.875), scale(95,2) - scale(88,2), false);
       fence2 = new Rectangle(scale(80, 1.875) + background.getX(), scale(128,2) + background.getY(), scale(86, 1.875) - scale(80, 1.875), scale(143,2) - scale(128,2), false);
       houseExit = new Rectangle(scale(111, 1.875) + background.getX(), scale(148,2) + background.getY(), scale(130, 1.875) - scale(111, 1.875), scale(159,2) - scale(155,2), false);
       houseObjects.add(firePlace1);
       houseObjects.add(firePlace2);
       houseObjects.add(workshopTable);
       houseObjects.add(table);
       houseObjects.add(fence1);
       houseObjects.add(picket);
       houseObjects.add(fence2);
       houseObjects.add(houseExit);
       return houseObjects;
    }

    public ArrayList<Rectangle> getVillageSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        firePlace1 = new Rectangle(0, 0, 0, 0, false);
        villageObjects.add(firePlace1);
        return villageObjects;
    }

    private static int scale(int x, double scale){
        return (int)(x * scale);
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public void setInHouse(boolean inHouse) {
        this.inHouse = inHouse;
    }

    public boolean isInVillage() {
        return inVillage;
    }

    public void setInVillage(boolean inVillage) {
        this.inVillage = inVillage;
    }

    public boolean isInCastle() {
        return inCastle;
    }

    public void setInCastle(boolean inCastle) {
        this.inCastle = inCastle;
    }

    public boolean isInForest() {
        return inForest;
    }

    public void setInForest(boolean inForest) {
        this.inForest = inForest;
    }

    public void sceneChangeExit(Player link, ArrayList<Rectangle> objects){
        int linkRX = link.getX() + link.getSpeed() + 4;
        int linkRW = link.getX() + link.getW() - link.getSpeed() - 4;
        int linkRY = link.getY() - link.getSpeed() - 4;
        int linkRH = link.getY() + link.getH() + link.getSpeed() + 4;
        if(inHouse && houseExit.getX() < linkRW && houseExit.getX() + houseExit.getW() > linkRX && houseExit.getY() < linkRH && houseExit.getY() + houseExit.getH() > linkRY && link.isDown()){
            System.out.println("Exit");
            timeSceneChange += 0.1;
            System.out.println(timeSceneChange);
            inHouse = false;
            inVillage = true;
            link.setInside(false);
        }
    }

    public void sceneChangeEnter(Player link, ArrayList<Rectangle> objects){
        int linkRX = link.getX() + link.getSpeed() + 4;
        int linkRW = link.getX() + link.getW() - link.getSpeed() - 4;
        int linkRY = link.getY() - link.getSpeed() - 4;
        int linkRH = link.getY() + link.getH() + link.getSpeed() + 4;
        if(inHouse && houseExit.getX() < linkRW && houseExit.getX() + houseExit.getW() > linkRX && houseExit.getY() < linkRH && houseExit.getY() + houseExit.getH() > linkRY && link.isDown()){
            System.out.println("Exit");
            inHouse = false;
            inVillage = true;
            link.setInside(false);

        }
    }

    public void paintScene(Graphics g, Rectangle r, int scene){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon back;
        if(isInHouse() && scene == 0) {
            back = new ImageIcon(Rectangle.class.getResource("Assests\\house.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInVillage() && scene == 1) {
            if(timeSceneChange % 10 == 0){
                g.setColor(Color.BLACK);
                g.drawRect(0,0, r.getW(), r.getH());
            }
            back = new ImageIcon(Rectangle.class.getResource("Assests\\village.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }


    }

}
