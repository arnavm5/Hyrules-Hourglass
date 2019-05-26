import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene {

    private ArrayList<Rectangle> houseObjects, villageObjects, castleObjects, forestObjects;;
    private boolean inHouse, inVillage, inCastle, inForest;
    private Rectangle houseExit , villageExit = new Rectangle(0,0,0,0, false), castleExit, forestExit;
    private Rectangle houseEnter = new Rectangle(0,0,0,0, false), villageEnter, castleEnter, forestEnter;
    private double timeSceneChange;

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
        houseEnter = new Rectangle(scale(425, 1.95) + background.getX(), scale(390, 1.4) + background.getY(), scale(430, 1.95) - scale(425, 1.95), scale(395, 1.4) - scale(390, 1.4), false);
        villageExit = new Rectangle(scale(255, 1.95) + background.getX(), scale(70, 1.4) + background.getY(), scale(315, 1.95) - scale(255, 1.95), scale(75, 1.4) - scale(70, 1.4), false);
        villageObjects.add(houseEnter);
        villageObjects.add(villageExit);
        return villageObjects;
    }

    public ArrayList<Rectangle> getCastleSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        houseEnter = new Rectangle(scale(425, 1.95) + background.getX(), scale(390, 1.4) + background.getY(), scale(430, 1.95) - scale(425, 1.95), scale(395, 1.4) - scale(390, 1.4), false);

        villageObjects.add(houseEnter);

        return villageObjects;
    }

    public ArrayList<Rectangle> getForestSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        houseEnter = new Rectangle(scale(425, 1.95) + background.getX(), scale(390, 1.4) + background.getY(), scale(430, 1.95) - scale(425, 1.95), scale(395, 1.4) - scale(390, 1.4), false);
        villageObjects.add(houseEnter);
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

    public void sceneChangeExit(Player link){
        int linkRX = link.getX() + link.getSpeed() + 4;
        int linkRW = link.getX() + link.getW() - link.getSpeed() - 4;
        int linkRY = link.getY() - link.getSpeed() - 4;
        int linkRH = link.getY() + link.getH() + link.getSpeed() + 4;
        if(inHouse && houseExit.getX() < linkRW && houseExit.getX() + houseExit.getW() > linkRX && houseExit.getY() < linkRH && houseExit.getY() + houseExit.getH() > linkRY && link.isDown()){
            System.out.println("Exit");
            inHouse = false;
            inVillage = true;
            link.setInside(false);
            link.setX(600);
            link.setY(250);
        }
        else if(inVillage && villageExit.getX() < linkRW && villageExit.getX() + villageExit.getW() > linkRX && villageExit.getY() < linkRH && villageExit.getY() + villageExit.getH() > linkRY && link.isUp()){
            System.out.println("Exit");
            inVillage = false;
            inCastle = true;
            link.setInside(false);
            link.setX(525);
            link.setY(350);
        }
    }

    public void sceneChangeEnter(Player link){
        int linkRX = link.getX() + link.getSpeed() + 4;
        int linkRW = link.getX() + link.getW() - link.getSpeed() - 4;
        int linkRY = link.getY() - link.getSpeed() - 4;
        int linkRH = link.getY() + link.getH() + link.getSpeed() + 4;
        if(inVillage && houseEnter.getX() < linkRW && houseEnter.getX() + houseEnter.getW() > linkRX && houseEnter.getY() < linkRH && houseEnter.getY() + houseEnter.getH() > linkRY && link.isUp()){
            System.out.println("Enter");
            inHouse = true;
            inVillage = false;
            link.setInside(true);
            link.setX(475);
            link.setY(300);
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
            g.setColor(Color.BLACK);
            back = new ImageIcon(Rectangle.class.getResource("Assests\\village.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInCastle() && scene == 2) {
            back = new ImageIcon(Rectangle.class.getResource("Assests\\castle.jpg"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInForest() && scene == 3) {
            back = new ImageIcon(Rectangle.class.getResource("Assests\\village.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }

    }

}
