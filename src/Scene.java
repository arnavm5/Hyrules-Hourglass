import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene {

    private ArrayList<Rectangle> houseObjects, villageObjects, castleObjects, forestObjects;;
    private boolean inHouse, inVillage, inCastle, inForest, start, story1, end, win, lose, controls, space, enter;
    private Rectangle houseExit , villageExitCastle, villageExitForest;
    private Rectangle houseEnter, villageEnterCastle, villageEnterForest;
    private Rectangle textBox;
    private Font text;
    private double timeSceneChange;
    private Character zelda;
    private int countSpaces;

    public Scene(){
        houseObjects = new ArrayList<Rectangle>();
        villageObjects = new ArrayList<Rectangle>();
        castleObjects = new ArrayList<Rectangle>();
        forestObjects = new ArrayList<Rectangle>();
        inHouse = true;
        inVillage = false;
        inCastle = false;
        inForest = false;
        start = true;
        story1 = true;
        end = false;
        win = false;
        lose = false;
        controls = true;
        space = false;
        enter = false;
        countSpaces = 0;
        timeSceneChange = 0;
        houseExit  = new Rectangle(0,0,0,0, false);
        villageExitCastle = new Rectangle(0,0,0,0, false);
        villageExitForest = new Rectangle(0,0,0,0, false);
        houseEnter = new Rectangle(0,0,0,0, false);
        villageEnterCastle = new Rectangle(0,0,0,0, false);
        villageEnterForest = new Rectangle(0,0,0,0, false);
        textBox = new Rectangle(0,0,0,0, false);
        text = new Font("Ariel", Font.PLAIN, 20);
        zelda = new Character(0,0,0,0, false);

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
       textBox = new Rectangle(background.getX() - 10, background.getY() + background.getH() - 50, background.getW() + 20, 100, false);
       houseExit = new Rectangle(scale(111, 1.875) + background.getX(), scale(148,2) + background.getY(), scale(130, 1.875) - scale(111, 1.875), scale(159,2) - scale(155,2), false);
       houseObjects.add(firePlace1);
       houseObjects.add(firePlace2);
       houseObjects.add(workshopTable);
       houseObjects.add(table);
       houseObjects.add(fence1);
       houseObjects.add(picket);
       houseObjects.add(fence2);
       houseObjects.add(textBox);
       houseObjects.add(houseExit);
       return houseObjects;
    }

    public ArrayList<Rectangle> getVillageSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        houseEnter = new Rectangle(scale(425, 1.5) + background.getX(), scale(385, 1.45) + background.getY(), scale(430, 1.5) - scale(425, 1.5), scale(390, 1.45) - scale(385, 1.45), false);
        villageExitCastle = new Rectangle(scale(255, 1.5) + background.getX(), scale(70, 1.45) + background.getY(), scale(315, 1.5) - scale(255, 1.5), scale(75, 1.45) - scale(70, 1.45), false);
        villageExitForest = new Rectangle(scale(55, 1.5) + background.getX(), scale(605, 1.45) + background.getY(), scale(60, 1.5) - scale(55, 1.5), scale(635, 1.45) - scale(605, 1.45), false);
        if(story1) {
            zelda = new Character(375 + background.getX(), 650 + background.getY(), 100, 2, false);
        }
        villageObjects.add(houseEnter);
        villageObjects.add(villageExitCastle);
        villageObjects.add(villageExitForest);
        villageObjects.add(zelda);
        return villageObjects;
    }

    public ArrayList<Rectangle> getCastleSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        villageEnterCastle = new Rectangle(scale(485, 1.3) + background.getX(), scale(505, 1.55) + background.getY(), scale(525, 1.3) - scale(485, 1.3), scale(510, 1.55) - scale(505, 1.55), false);
        castleObjects.add(villageEnterCastle);
        return castleObjects;
    }

    public ArrayList<Rectangle> getForestSceneObjects(Rectangle background) {
        Rectangle firePlace1;
        villageEnterForest = new Rectangle(scale(125, 1.05) + background.getX(), scale(15, 1.6) + background.getY(), scale(165, 1.05) - scale(125, 1.05), scale(20, 1.6) - scale(15, 1.6), false);
        forestObjects.add(villageExitForest);
        return forestObjects;
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
            link.setX(615);
            link.setY(205);
        }
        else if(inVillage && villageExitCastle.getX() < linkRW && villageExitCastle.getX() + villageExitCastle.getW() > linkRX && villageExitCastle.getY() < linkRH && villageExitCastle.getY() + villageExitCastle.getH() > linkRY && link.isUp()){
            System.out.println("Exit");
            inVillage = false;
            inCastle = true;
            link.setInside(false);
            link.setX(515);
            link.setY(350);
        }
        else if(inVillage && villageExitForest.getX() < linkRW && villageExitForest.getX() + villageExitForest.getW() > linkRX && villageExitForest.getY() < linkRH && villageExitForest.getY() + villageExitForest.getH() > linkRY && link.isLeft()){
            System.out.println("Exit");
            inVillage = false;
            inForest = true;
            link.setInside(true);
            link.setX(150);
            link.setY(20);
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
        else if(inCastle && villageEnterCastle.getX() < linkRW && villageEnterCastle.getX() + villageEnterCastle.getW() > linkRX && villageEnterCastle.getY() < linkRH && villageEnterCastle.getY() + villageEnterCastle.getH() > linkRY && link.isDown()){
            System.out.println("Enter");
            inVillage = true;
            inCastle = false;
            link.setInside(false);
            link.setX(575);
            link.setY(125);
        }
        else if(inForest && villageEnterForest.getX() < linkRW && villageEnterForest.getX() + villageEnterForest.getW() > linkRX && villageEnterForest.getY() < linkRH && villageEnterForest.getY() + villageEnterForest.getH() > linkRY && link.isUp()){
            System.out.println("Enter");
            inVillage = true;
            inForest = false;
            link.setInside(false);
            link.setX(575);
            link.setY(125);
        }

    }

    public void paintScene(Graphics g, Rectangle r, int scene){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon back;
        if(isInHouse() && scene == 0) {
            back = new ImageIcon(Scene.class.getResource("Assets/Scenes/house.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInVillage() && scene == 1) {
            g.setColor(Color.BLACK);
            back = new ImageIcon(Scene.class.getResource("Assets/Scenes/village.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInCastle() && scene == 2) {
            back = new ImageIcon(Scene.class.getResource("Assets/Scenes/castle.jpg"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        else if(isInForest() && scene == 3) {
            back = new ImageIcon(Scene.class.getResource("Assets/Scenes/forest.png"));
            g2d.drawImage(back.getImage(), r.getX(), r.getY(), r.getW(), r.getH(), null);
        }
        if(isInVillage() && zelda.getY() >= r.getY()) {
            Character.paintZelda(g, 2, zelda);
        }
        else{

        }
    }

    public void paintText(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon box = new ImageIcon(Scene.class.getResource("Assets/Extras/TextBox.jpg"));
        if(start && controls && inHouse){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setFont(text);
            g.setColor(Color.WHITE);
            g.drawString("Controls: W-A-S-D to move, Shift to run.", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(start && inHouse){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setFont(text);
            g.setColor(Color.WHITE);
            g.drawString("Zelda: Link, we will be late to the festival.", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(story1 && inVillage){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setFont(text);
            g.setColor(Color.WHITE);
            g.drawString("Zelda: I will see you at the Hourglass Festival in ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString(".", textBox.getX() + 133, textBox.getY() + 50);
            g.setColor(Color.CYAN);
            g.drawString("Hyrule Castle", textBox.getX() + 15, textBox.getY() + 50);

        }
    }

    public void sceneKeyPressed(int key){
        if(key == 32){
            space = true;
            countSpaces += 1;
        }
        if (key == 10) {
            enter = true;
        }
    }

    public void sceneKeyReleased(int key){
        if(key == 32){
            space = false;
        }
        if (key == 10) {
            enter = false;
        }
    }

    public void storyHandler(Player link){
        if(countSpaces == 0){
            start = true;
            controls = true;
        }
        else if(countSpaces == 1){
            controls = false;
        }
        else if(countSpaces == 2){
            start = false;
        }
        else if(countSpaces == 3){
            story1 = false;
        }
        System.out.println(countSpaces);
        boolean notWalk1 = countSpaces == 2 && story1 && inVillage;
        if(countSpaces <= 1 || notWalk1){
            link.setSpeed(0);
            link.setUp(false);
            link.setDown(false);
            link.setLeft(false);
            link.setRight(false);
        }
        else{
            link.setSpeed(3);
        }
    }

    public void autoCharacters(Rectangle scene){
        boolean zeldaMove1 = countSpaces >= 2 && inVillage;
        if(zeldaMove1){
            if(zelda.getY() >= scene.getY()){
                zelda.setY(zelda.getY() - zelda.getSpeed());
                if(zelda.getY() <= scene.getY()){
                    villageObjects.remove(zelda);
                    castleObjects.add(zelda);
                }
            }
        }
    }
}
