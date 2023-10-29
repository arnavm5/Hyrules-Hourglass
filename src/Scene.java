import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.util.ArrayList;

public class Scene {

    private ArrayList<Rectangle> houseObjects, villageObjects, castleObjects, forestObjects;
    private ArrayList<Character> squirrels;
    private boolean inHouse, inVillage, inCastle,inForest, start, story1, enterCastle, villainTalks, question1 ,villainDec, end, win, lose, controls, space, spaceIncrement, enter;
    private Rectangle houseExit , villageExitCastle, villageExitForest;
    private Rectangle houseEnter, villageEnterCastle, villageEnterForest;
    private Rectangle linkHealth, workshopTable;
    private Rectangle textBox, heartRec, hourglass;
    private Font text;
    private Character zelda, vaati;
    private int countSpaces;
    private boolean isZeldaMoving, vaatiMoving, faint, warning, wanting, collectedSword, noEnterance, enterForest, squirrelLost, heartCollected, collectedOnce;

    public Scene(){
        houseObjects = new ArrayList<Rectangle>();
        villageObjects = new ArrayList<Rectangle>();
        castleObjects = new ArrayList<Rectangle>();
        forestObjects = new ArrayList<Rectangle>();
        squirrels = new ArrayList<Character>();
        inHouse = true;
        inVillage = false;
        inCastle = false;
        inForest = false;
        start = true;
        story1 = true;
        enterCastle = true;
        question1 = false;
        villainTalks = false;
        villainDec = false;
        end = false;
        win = false;
        lose = false;
        controls = true;
        space = false;
        enter = false;
        countSpaces = 0;
        houseExit  = new Rectangle(0,0,0,0, false);
        villageExitCastle = new Rectangle(0,0,0,0, false);
        villageExitForest = new Rectangle(0,0,0,0, false);
        houseEnter = new Rectangle(0,0,0,0, false);
        villageEnterCastle = new Rectangle(0,0,0,0, false);
        villageEnterForest = new Rectangle(0,0,0,0, false);
        textBox = new Rectangle(0,0,0,0, false);
        workshopTable = new Rectangle(0,0,0,0, false);
        text = new Font("Ariel", Font.PLAIN, 20);
        zelda = new Character(0,0,0,0, false);
        vaati = new Character(500,-170,350,2, false);
        linkHealth = new Rectangle(485, 25, 100, 10, false);
        spaceIncrement=false;
        isZeldaMoving = false;
        vaatiMoving = false;
        faint = false;
        warning = false;
        wanting = false;
        collectedSword = false;
        noEnterance = false;
        enterForest = false;
        squirrelLost = false;
        heartRec = new Rectangle(scale(860, 1.05),scale(70, 1.6),20,20,false);
        hourglass = new Rectangle(scale(760, 1.05),scale(245, 1.6),30,40,false);
        heartCollected = false;
        collectedOnce = false;

    }

    public ArrayList<Rectangle> getHouseSceneObjects(Rectangle background){
       Rectangle firePlace1, firePlace2, table, fence1, fence2, picket;
       firePlace1 = new Rectangle(182 + background.getX(), 128 + background.getY(), 21, 30, false);
       firePlace2 = new Rectangle(253 + background.getX(), 128 + background.getY(), 29, 30, false);
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
        Rectangle tree1,tree2,tree3,tree4,tree5,tree6,tree7,tree8,tree9,tree10,tree11,tree12,tree13,wood,house,tree16,tree17, house1, house2, water1, water2;
        tree1 = new Rectangle(scale(140, 1.5) + background.getX() ,scale(110, 1.45) + background.getY() ,  (int)(70 * 1.5),(int)(50  * 1.45), false);
        tree2 = new Rectangle(scale(180, 1.5) + background.getX() ,scale(160, 1.45) + background.getY() ,  (int)(60 * 1.5),(int)(110 * 1.45), false);
        tree3 = new Rectangle(scale(140, 1.5) + background.getX() ,scale(260, 1.45) + background.getY() ,  (int)(60 * 1.5),(int)(50 * 1.45), false);
        tree4 = new Rectangle(scale(20 , 1.5) + background.getX() ,scale(310, 1.45) + background.getY() , (int)(150 * 1.5),(int)(50 * 1.45), false);
        tree5 = new Rectangle(scale(20 , 1.5) + background.getX() ,scale(360, 1.45) + background.getY() ,  (int)(50 * 1.5),(int)(100 * 1.45), false);
        tree6 = new Rectangle(scale(70 , 1.5) + background.getX() ,scale(460, 1.45) + background.getY() ,  (int)(50 * 1.5),(int)(100 * 1.45), false);
        tree7 = new Rectangle(scale(120, 1.5) + background.getX() ,scale(500, 1.45) + background.getY() , (int)(100 * 1.5),(int)(50 * 1.45), false);
        tree8 = new Rectangle(scale(180, 1.5) + background.getX() ,scale(550, 1.45) + background.getY() ,  (int)(50 * 1.5),(int)(50 * 1.45), false);
        tree9 = new Rectangle(scale(360, 1.5) + background.getX() ,scale(110, 1.45) + background.getY() ,  (int)(50 * 1.5),(int)(50 * 1.45), false);
        tree10 = new Rectangle(scale(320, 1.5) + background.getX(), scale(160, 1.45) + background.getY(), (int)(300 * 1.5), (int)(50 * 1.45), false);
        tree11 = new Rectangle(scale(390, 1.5) + background.getX(), scale(210, 1.45) + background.getY(), (int)(100 * 1.5), (int)(50 * 1.45), false);
        tree12 = new Rectangle(scale(410, 1.5) + background.getX(), scale(260, 1.45) + background.getY(), (int)( 50 * 1.5), (int)(50 * 1.45), false);
        tree13 = new Rectangle(scale(340, 1.5) + background.getX(), scale(320, 1.45) + background.getY(), (int)( 50 * 1.5), (int)(50 * 1.45), false);
        wood = new Rectangle(scale(340, 1.5) + background.getX(),   scale(380, 1.45) + background.getY(),   (int)( 30 * 1.5), (int)(30 * 1.45), false);
        house = new Rectangle(scale(400, 1.5) + background.getX(),  scale(330, 1.45) + background.getY(),  (int)(110 * 1.5), (int)(70 * 1.45), false);
        tree16 = new Rectangle(scale(550, 1.5) + background.getX(), scale(450, 1.45) + background.getY(), (int)( 50 * 1.5), (int)(50 * 1.45), false);
        tree17 = new Rectangle(scale(480, 1.5) + background.getX(), scale(500, 1.45) + background.getY() ,(int)(110 * 1.5), (int)(60 * 1.45), false);

        house1 = new Rectangle(scale(317, 1.5) + background.getX() ,scale(320, 1.45) + background.getY() ,  (int)(96 * 1.5),(int)(191  * 1.45), false);
        house2 = new Rectangle(scale(455, 1.5) + background.getX() ,scale(320, 1.45) + background.getY() ,  (int)(88 * 1.5),(int)(180 * 1.45), false);
        water1 = new Rectangle(0 + background.getX() ,scale(123, 1.45) + background.getY() ,  (int)(116 * 1.5),(int)(49 * 1.45), false);
        water2 = new Rectangle(0 + background.getX() ,scale(477, 1.45) + background.getY() , (int)(40 * 1.5),(int)(103 * 1.45), false);

        houseEnter = new Rectangle(scale(425, 1.5) + background.getX(), scale(385, 1.45) + background.getY(), scale(430, 1.5) - scale(425, 1.5), scale(390, 1.45) - scale(385, 1.45), false);
        villageExitCastle = new Rectangle(scale(255, 1.5) + background.getX(), scale(70, 1.45) + background.getY(), scale(315, 1.5) - scale(255, 1.5), scale(75, 1.45) - scale(70, 1.45), false);
        villageExitForest = new Rectangle(scale(55, 1.5) + background.getX(), scale(605, 1.45) + background.getY(), scale(60, 1.5) - scale(55, 1.5), scale(635, 1.45) - scale(605, 1.45), false);
        if(story1) {
            zelda = new Character(375 + background.getX(), 650 + background.getY(), 100, 2, false);
        }
        villageObjects.add(houseEnter);
        villageObjects.add(villageExitCastle);
        villageObjects.add(villageExitForest);
        villageObjects.add(tree1);
        villageObjects.add(tree2);
        villageObjects.add(tree3);
        villageObjects.add(tree4);
        villageObjects.add(tree5);
        villageObjects.add(tree6);
        villageObjects.add(tree7);
        villageObjects.add(tree8);
        villageObjects.add(tree9);
        villageObjects.add(tree10);
        villageObjects.add(tree11);
        villageObjects.add(tree12);
        villageObjects.add(tree13);
        villageObjects.add(wood);
        villageObjects.add(house);
        villageObjects.add(tree16);
        villageObjects.add(tree17);
        villageObjects.add(house1);
        villageObjects.add(house2);
        villageObjects.add(water1);
        villageObjects.add(water2);

        if(countSpaces == 3)
            villageObjects.add(zelda);
        return villageObjects;
    }

    public ArrayList<Rectangle> getCastleSceneObjects(Rectangle background) {
        Rectangle rec1, rec2;

        rec1 = new Rectangle(0 + background.getX(), 0 + background.getY(), (int)(465 * 1.3), (int)(525 * 1.55), false);
        rec2 = new Rectangle(scale(545, 1.3) + background.getX(), 0 + background.getY(), (int)(462 * 1.3), (int)(525 * 1.55), false);

        villageEnterCastle = new Rectangle(scale(485, 1.3) + background.getX(), scale(505, 1.55) + background.getY(), scale(525, 1.3) - scale(485, 1.3), scale(510, 1.55) - scale(505, 1.55), false);
        if(!story1 && enterCastle) {
            zelda = new Character(375 + background.getX(), 650 + background.getY(), 100, 2, false);
        }
        castleObjects.add(villageEnterCastle);
        castleObjects.add(rec1);
        castleObjects.add(rec2);
        if(countSpaces <= 8)
            castleObjects.add(vaati);
        return castleObjects;
    }

    public ArrayList<Rectangle> getForestSceneObjects(Rectangle background) {
        Rectangle tree1,tree2,tree3,tree4,tree5,tree6, barrier1, barrier2, barrier3, barrier4;

        tree1 = new Rectangle(scale( 451, 1.05) + background.getX() , scale( 49, 1.6) + background.getY(), (int)(60* 1.05), (int)( 252* 1.6), false);
        tree2 = new Rectangle(scale( 513, 1.05) + background.getX() , scale( 64, 1.6) + background.getY(), (int)( 62* 1.05), (int)( 61* 1.6), false);
        tree3 = new Rectangle(scale( 624, 1.05) + background.getX() , scale( 49, 1.6) + background.getY(), (int)( 159* 1.05), (int)( 60* 1.6), false);
        tree4 = new Rectangle(scale( 656, 1.05) + background.getX() , scale( 129, 1.6) + background.getY(), (int)( 157* 1.05), (int)( 107* 1.6), false);
        tree5 = new Rectangle(scale( 624, 1.05) + background.getX() , scale( 180, 1.6) + background.getY(), (int)( 34* 1.05), (int)( 61* 1.6), false);
        tree6 = new Rectangle(scale( 815, 1.05) + background.getX() , scale( 128, 1.6) + background.getY(), (int)( 90* 1.05), (int)(79* 1.6), false);

        barrier1	= new Rectangle(scale( 50, 1.05) + background.getX() , scale( 30, 1.6) + background.getY(), (int)( 107* 1.05), (int)( 62* 1.6), false);
        barrier2	= new Rectangle(scale( 160, 1.05) + background.getX() , scale( 92, 1.6) + background.getY(), (int)( 206* 1.05), (int)( 32* 1.6), false);
        barrier3	= new Rectangle(scale( 51, 1.05) + background.getX() , scale( 154, 1.6) + background.getY(), (int)( 129* 1.05), (int)( 100* 1.6), false);
        barrier4	= new Rectangle(scale( 136, 1.05) + background.getX() , scale( 205, 1.6) + background.getY(), (int)(305 * 1.05), (int)( 45* 1.6), false);


        villageEnterForest = new Rectangle(scale(125, 1.05) + background.getX(), scale(15, 1.6) + background.getY(), scale(165, 1.05) - scale(125, 1.05), scale(20, 1.6) - scale(15, 1.6), false);
        forestObjects.add(villageExitForest);
        forestObjects.add(	tree1	);
        forestObjects.add(	tree2	);
        forestObjects.add(	tree3	);
        forestObjects.add(	tree4	);
        forestObjects.add(	tree5	);
        forestObjects.add(	tree6	);
        forestObjects.add(	barrier1	);
        forestObjects.add(	barrier2	);
        forestObjects.add(	barrier3	);
        forestObjects.add(	barrier4	);
        return forestObjects;
    }

    private static int scale(int x, double scale){
        return (int)(x * scale);
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public boolean getFaint() {
        return faint;
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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public void setInForest(boolean inForest) {
        this.inForest = inForest;
    }

    public void sceneChangeExit(Player link, Rectangle r1, Rectangle r2){
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
            link.setY(230);
        }
        else if(inVillage && villageExitCastle.getX() < linkRW && villageExitCastle.getX() + villageExitCastle.getW() > linkRX && villageExitCastle.getY() < linkRH && villageExitCastle.getY() + villageExitCastle.getH() > linkRY && link.isUp() && countSpaces < 9){
            System.out.println("Exit");
            inVillage = false;
            inCastle = true;
            link.setInside(false);
            link.setX(515);
            link.setY(300);
        }
        else if(inVillage && villageExitForest.getX() < linkRW && villageExitForest.getX() + villageExitForest.getW() > linkRX && villageExitForest.getY() < linkRH && villageExitForest.getY() + villageExitForest.getH() > linkRY && link.isLeft() && collectedSword){
            System.out.println("Exit");
            inVillage = false;
            inForest = true;
            link.setInside(true);
            link.setX(150);
            link.setY(20);
            link.setDown(true);
            link.setDown(false);
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
        else if(inCastle && villageEnterCastle.getX() < linkRW && villageEnterCastle.getX() + villageEnterCastle.getW() > linkRX && villageEnterCastle.getY() < linkRH && villageEnterCastle.getY() + villageEnterCastle.getH() > linkRY && link.isDown() && (countSpaces <= 2 || countSpaces >= 7)){
            System.out.println("Enter");
            inVillage = true;
            inCastle = false;
            link.setInside(false);
            link.setX(400);
            link.setY(95);
        }
        else if(inForest && villageEnterForest.getX() < linkRW && villageEnterForest.getX() + villageEnterForest.getW() > linkRX && villageEnterForest.getY() < linkRH && villageEnterForest.getY() + villageEnterForest.getH() > linkRY && link.isUp()){
            System.out.println("Enter");
            inVillage = true;
            inForest = false;
            link.setInside(false);
            link.setX(90);
            link.setY(350);
            link.setRight(true);
            link.setRight(false);
        }

    }

    public void paintScene(Graphics g, Rectangle r, int scene, Player link){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon back;
        ImageIcon sword = new ImageIcon(Scene.class.getResource("Assets/Extras/sword.png"));
        ImageIcon miniLink = new ImageIcon(Scene.class.getResource("Assets/Link/miniLink.png"));
        ImageIcon heart = new ImageIcon(Scene.class.getResource("Assets/Extras/heart.png"));
        ImageIcon hourglassPic = new ImageIcon(Scene.class.getResource("Assets/Extras/hourglass.png"));
        ImageIcon winPic = new ImageIcon(Scene.class.getResource("Assets/Extras/winPic.JPG"));
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
        if(isInVillage() && zelda.getY() >= r.getY() && enterCastle) {
            zelda.paintZelda(g, 2);
        }
        if(isInCastle() && vaati.getY() >= 70 && vaati.getY() < 500){
            vaati.paintVaati(g);
        }
        if(isInCastle() && countSpaces == 7){
            g2d.drawImage(miniLink.getImage(), linkHealth.getX() - 30, linkHealth.getY() - 5, 25,20,null);
            g.setColor(Color.RED);
            g.fillRect(linkHealth.getX(), linkHealth.getY(), linkHealth.getW(), linkHealth.getH());
        }
        if(linkHealth.getW() <= 0 && vaati.getY() >= 500){
            setInCastle(false);
            faint = true;
        }
        if(faint && warning){
            g2d.drawImage(miniLink.getImage(), linkHealth.getX() - 35 - 30, linkHealth.getY() - 5, 25,20,null);
            g.setColor(Color.RED);
            g.fillRect(linkHealth.getX() - 35, linkHealth.getY(), linkHealth.getW(), linkHealth.getH());
        }
        if(isInHouse() && scene == 0 && countSpaces >= 8 && !collectedSword){
            g2d.drawImage(sword.getImage(), 90 + r.getX(), 70 + r.getY(), 25, 25, null);
            linkHealth.setX(350);
            linkHealth.setW(400);
        }
        if(inForest && countSpaces >= 10){
            g2d.drawImage(miniLink.getImage(), linkHealth.getX() - 35 - 30, linkHealth.getY() - 10, 25,20,null);
            g.setColor(Color.RED);
            g.fillRect(linkHealth.getX() - 35, linkHealth.getY() - 5, linkHealth.getW(), linkHealth.getH());
        }
        if(inForest && !lose && !win){
            if(vaati.getHealth() > 0) {
                vaati.setX(scale(640, 1.05));
                vaati.setY(scale(235, 1.6));
                vaati.paintVaati(g);
            }
            zelda.setX(scale(855, 1.05));
            zelda.setY(scale(210, 1.6));
            zelda.paintZelda(g, 1);
            if(!win) {
                g2d.drawImage(hourglassPic.getImage(), hourglass.getX(), hourglass.getY(), hourglass.getW(), hourglass.getH(), null);
            }

        }
        if(lose){
            setInForest(false);
        }
        if(win){
            setInForest(false);
            g2d.drawImage(winPic.getImage(), 300, 0, 400,500,null);
        }
        if(squirrelLost && !enter && !heartCollected && !collectedOnce && !lose && !win){
            g2d.drawImage(heart.getImage(), heartRec.getX(), heartRec.getY(), heartRec.getW(),heartRec.getH(),null);
        }
    }

    public void paintText(Graphics g, Player link){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon box = new ImageIcon(Scene.class.getResource("Assets/Extras/TextBox.jpg"));
        g.setFont(text);
        if(start && controls && inHouse){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Controls: W-A-S-D to move, Shift to run, ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString("Enter to pickup items.", textBox.getX() + 15, textBox.getY() + 50);
        }
        else if(start && inHouse){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("???: Link, we will be late to the festival.", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(story1 && inVillage){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Zelda: I will see you at the Hourglass Festival in ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString(".", textBox.getX() + 133, textBox.getY() + 50);
            g.setColor(Color.CYAN);
            g.drawString("Hyrule Castle", textBox.getX() + 15, textBox.getY() + 50);
        }
        else if(inCastle && enterCastle){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Link: Hey, where did everyone go?", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(inCastle && villainTalks){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.MAGENTA);
            g.drawString("???: MUWHAHAHAHA, I have Zelda and the", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString("Hourglass. No one can stop me from taking ", textBox.getX() + 15, textBox.getY() + 50);
            g.drawString("over Hyrule now.", textBox.getX() + 15, textBox.getY() + 73);
        }
        else if(inCastle && question1){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Link: WHO ARE YOU AND WHERE IS ZELDA??", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(inCastle && villainDec){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.MAGENTA);
            g.drawString("???: I AM VAATI, AND I WILL TAKE OVER ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString("HYRULE. MWAHAHAHA", textBox.getX() + 15, textBox.getY() + 50);
        }
        else if(faint && warning){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Voice from Afar: Keep your health up to prevent ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString("fainting.", textBox.getX() + 15, textBox.getY() + 50);
        }
        else if(inCastle && wanting){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Link: I need to save Zelda.", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(inVillage && noEnterance && countSpaces == 9){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Voice from Afar: The forest is too dangerous right ", textBox.getX() + 15, textBox.getY() + 30);
            g.drawString("now.", textBox.getX() + 15, textBox.getY() + 50);
        }
        else if(inForest && enterForest){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.WHITE);
            g.drawString("Controls: Left click to attack.", textBox.getX() + 15, textBox.getY() + 30);
        }
        else if(lose){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.RED);
            g.drawString("Vaati took over all of Hyrule.", textBox.getX() + 15, textBox.getY() + 30);
            g.setColor(Color.RED);
            Font LOSE = new Font("Ariel", Font.BOLD, 100);
            g.setFont(LOSE);
            g.drawString("YOU LOSE!!!!!", 200, 300);
        }
        else if(win){
            g2d.drawImage(box.getImage(), textBox.getX(), textBox.getY(), textBox.getW(), textBox.getH(), null);
            g.setColor(Color.GREEN);
            g.drawString("You Won. Hyrule has been saved.", textBox.getX() + 15, textBox.getY() + 30);
        }

    }

    public void sceneKeyPressed(int key){
        if(key == 32){
            space = true;
            
        }
        if (key == 10) {
            enter = true;
        }
    }

    public void sceneKeyReleased(int key){
        if(key == 32){
            space = false;
            if(spaceIncrement)
                countSpaces++;
        }
        if (key == 10) {
            enter = false;
        }
    }

    public void storyHandler(Player link, Rectangle back1){
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
            isZeldaMoving = true;
            if(zelda.getY() + zelda.getH() < 0){
                isZeldaMoving = false;
            }
        }
        else if(countSpaces == 4){
            enterCastle = false;
            if(back1.getY() > -100){
                villainTalks = true;
            }
        }
        else if(countSpaces == 5){
            villainTalks = false;
            if(back1.getY() > -100) {
                question1 = true;
            }
        }
        else if(countSpaces == 6){
            question1 = false;
            villainDec = true;
        }
        else if(countSpaces == 7){
            villainDec = false;
            vaatiMoving = true;
            if(linkHealth.getW() <= 0){
                warning = true;
            }
        }
        else if(countSpaces == 8){
            vaatiMoving = false;
            warning = false;
            if(inCastle){
                wanting = true;
            }
        }
        else if(countSpaces == 9){
            wanting = false;
            if(inVillage && !collectedSword && villageExitForest.getX() < link.getX() + link.getW() && villageExitForest.getX() + villageExitForest.getW() > link.getX() && villageExitForest.getY() < link.getY() + link.getH() && villageExitForest.getY() + villageExitForest.getH() > link.getY() && link.isLeft()){
                noEnterance = true;
            }
            if(inVillage && collectedSword && villageExitForest.getX() < link.getX() + link.getW() && villageExitForest.getX() + villageExitForest.getW() > link.getX() && villageExitForest.getY() < link.getY() + link.getH() && villageExitForest.getY() + villageExitForest.getH() > link.getY() && link.isLeft()){
                noEnterance = false;
                countSpaces++;
            }
        }
        else if(countSpaces == 10){
            if(inVillage && collectedSword && villageExitForest.getX() < link.getX() + link.getW() && villageExitForest.getX() + villageExitForest.getW() > link.getX() && villageExitForest.getY() < link.getY() + link.getH() && villageExitForest.getY() + villageExitForest.getH() > link.getY() && link.isLeft()){
                noEnterance = false;
            }
            if(inForest){
                enterForest = true;
            }
        }
        else if(countSpaces == 11){
            enterForest = false;
        }
        System.out.println(countSpaces);
        boolean notWalk1 = countSpaces == 2 && story1 && inVillage;
        boolean notWalk2 = countSpaces == 3 && enterCastle && inCastle;
        boolean notWalk3 = countSpaces == 4 && villainTalks && inCastle;
        boolean notWalk4 = countSpaces == 5 && question1 && inCastle;
        boolean notWalk5 = countSpaces == 6 && villainDec && inCastle;
        boolean notWalk6 = countSpaces == 7 && warning && linkHealth.getW() >= 100;
        boolean notWalk7 = countSpaces == 8 && wanting;
        boolean notWalk8 = countSpaces == 9 && noEnterance && inVillage;
        boolean notWalk9 = countSpaces == 10 && enterForest && inForest;
        if(countSpaces <= 1 || notWalk1 || notWalk2 || notWalk3 || notWalk4 || notWalk5 || notWalk6 || notWalk7 || notWalk8 || notWalk9){
            link.setSpeed(0);
            link.setUp(false);
            link.setDown(false);
            link.setLeft(false);
            link.setRight(false);
            spaceIncrement = true;
        }
        else{
            if(inCastle){
                isZeldaMoving =false;
            }
            spaceIncrement = false;
            if(link.isShift())
                link.setSpeed(4);
            else{
                link.setSpeed(3);
            }
        }
        if(isZeldaMoving){
                link.setSpeed(0);
                link.setUp(false);
                link.setDown(false);
                link.setLeft(false);
                link.setRight(false);
        }
        if(vaatiMoving){
            link.setSpeed(0);
            link.setUp(false);
            link.setDown(false);
            link.setLeft(false);
            link.setRight(false);
        }

        if(squirrelLost){
            if(linkHealth.getW() < 200) {
                link.recCollision(heartRec, 5, 16);
                if (heartRec.getX() < link.getX() + link.getW() && heartRec.getX() + heartRec.getW() > link.getX() && heartRec.getY() < link.getY() + link.getH() && heartRec.getY() + heartRec.getH() > link.getY() && enter && !heartCollected) {
                    heartCollected = true;
                    collectedOnce = true;
                }
            }
            if(linkHealth.getW() >= 200){
                heartCollected = false;
            }
        }
        link.recCollision(hourglass, 5, 16);
        if(hourglass.getX() < link.getX() + link.getW() && hourglass.getX() + hourglass.getW() > link.getX() && hourglass.getY() < link.getY() + link.getH() && hourglass.getY() + hourglass.getH() > link.getY() && enter) {
            win = true;
        }

    }

    public void autoCharacters(Rectangle scene, Player link, int x){
       // int linkRX = link.getX() + link.getSpeed() + 4;
        // int linkRW = link.getX() + link.getW() - link.getSpeed() - 4;
       // int linkRY = link.getY() - link.getSpeed() - 4;
       // int linkRH = link.getY() + link.getH() + link.getSpeed() + 4;

        boolean zeldaMove1 = countSpaces == 2 || countSpaces == 3 && inVillage;
        if(zeldaMove1 && x == 1){
            if(zelda.getY() >= scene.getY()){
                zelda.setY(zelda.getY() - zelda.getSpeed());
                if(zelda.getY() <= scene.getY()){
                    villageObjects.remove(zelda);
                    forestObjects.add(zelda);
                }
            }
        }
        if(vaatiMoving){
            if(vaati.getY() < 500) {
                vaati.setY(vaati.getY() + vaati.getSpeed());
                if(vaati.getY() >= link.getY() && vaati.getY() <= 500 && linkHealth.getW() >= 1){
                    linkHealth.setW(linkHealth.getW() - 2);
                }
            }
            else{
                vaatiMoving = false;
                castleObjects.remove(vaati);
            }
        }
        if(faint && warning && linkHealth.getW() < 100){
            linkHealth.setW(linkHealth.getW() + 1);
        }
        if(!warning && linkHealth.getW() >= 100 && countSpaces == 8){
            setInCastle(true);
            faint = false;
        }
        if(enter && workshopTable.getX() < link.getX() + link.getW() && workshopTable.getX() + workshopTable.getW() > link.getX() && workshopTable.getY() < link.getY() + link.getH() && workshopTable.getY() + workshopTable.getH() > link.getY()) {
            collectedSword = true;
        }
        if(countSpaces < 11){
            link.setLeftClick(false);
        }
        if(linkHealth.getW() <= 0 && countSpaces >= 11){
            lose = true;
        }
        if(heartCollected && linkHealth.getW() < 200){
            linkHealth.setW(linkHealth.getW() + 5);
        }
        if(vaati.getHealth() >= 0){
            link.recCollision(vaati, 5, 16);
        }
        link.recCollision(zelda, 5, 16);

    }

    public void formSquirrels(Player link){
        if(countSpaces >= 10 && inForest){
            Character squirrel1, squirrel2, squirrel3, squirrel4, squirrel5;
            squirrel1 = new Character(scale(150, 1.05),scale(170,1.6),220,0,false);//0
            squirrel2 = new Character(scale(300, 1.05),scale(50,1.6),220,0,false);//1
            squirrel3 = new Character(scale(520, 1.05),scale(170,1.6),220,0,false);//2
            squirrel4 = new Character(scale(872, 1.05),scale(75,1.6),220,0,false);//3
            squirrel5 = new Character(scale(610, 1.05),scale(150,1.6),220,0,false);//4
            squirrels.add(squirrel1);
            squirrels.add(squirrel2);
            squirrels.add(squirrel3);
            squirrels.add(squirrel4);
            squirrels.add(squirrel5);
            if(squirrels.get(0).getHealth() >= 0) {
                link.recCollision(squirrels.get(0), 5, 16);
            }
            if(squirrels.get(1).getHealth() >= 0) {
                link.recCollision(squirrels.get(1), 5, 16);
            }
            if(squirrels.get(2).getHealth() >= 0) {
                link.recCollision(squirrels.get(2), 5, 16);
            }
            if(squirrels.get(3).getHealth() >= 0) {
                link.recCollision(squirrels.get(3), 5, 16);
            }
            if(squirrels.get(4).getHealth() >= 0) {
                link.recCollision(squirrels.get(4), 5, 16);
            }

        }
    }

    public void paintSquirrels(Graphics g) {
        if(inForest && countSpaces >= 10 && !lose){
            Graphics2D g2d = (Graphics2D) g;
            ImageIcon squirrelArt;
            if(squirrels.get(0).getHealth() > 0){
                squirrels.get(0).setW(40);
                squirrels.get(0).setH(40);
                squirrelArt = new ImageIcon(Scene.class.getResource("Assets/Squirrels/squirrelRight.png"));
                g2d.drawImage(squirrelArt.getImage(), squirrels.get(0).getX(), squirrels.get(0).getY(), squirrels.get(0).getW(), squirrels.get(0).getH(), null);
            }
            if(squirrels.get(1).getHealth() > 0){
                squirrels.get(1).setW(40);
                squirrels.get(1).setH(40);
                squirrelArt = new ImageIcon(Scene.class.getResource("Assets/Squirrels/squirrelLeft.png"));
                g2d.drawImage(squirrelArt.getImage(), squirrels.get(1).getX(), squirrels.get(1).getY(), squirrels.get(1).getW(), squirrels.get(1).getH(), null);
            }
            if(squirrels.get(2).getHealth() > 0){
                squirrels.get(2).setW(40);
                squirrels.get(2).setH(40);
                squirrelArt = new ImageIcon(Scene.class.getResource("Assets/Squirrels/squirrelRight.png"));
                g2d.drawImage(squirrelArt.getImage(), squirrels.get(2).getX(), squirrels.get(2).getY(), squirrels.get(2).getW(), squirrels.get(2).getH(), null);
            }
            if(squirrels.get(3).getHealth() > 0){
                squirrels.get(3).setW(40);
                squirrels.get(3).setH(40);
                squirrelArt = new ImageIcon(Scene.class.getResource("Assets/Squirrels/squirrelLeft.png"));
                g2d.drawImage(squirrelArt.getImage(), squirrels.get(3).getX(), squirrels.get(3).getY(), squirrels.get(3).getW(), squirrels.get(3).getH(), null);
            }
            if(squirrels.get(4).getHealth() > 0){
                squirrels.get(4).setW(40);
                squirrels.get(4).setH(40);
                squirrelArt = new ImageIcon(Scene.class.getResource("Assets/Squirrels/squirrelLeft.png"));
                g2d.drawImage(squirrelArt.getImage(), squirrels.get(4).getX(), squirrels.get(4).getY(), squirrels.get(4).getW(), squirrels.get(4).getH(), null);
            }
        }
    }

    public void linkAttacking(Player link){
        if(link.isleftClick()){
            link.setLeft(false);
            link.setRight(false);
            link.setUp(false);
            link.setDown(false);
            if(squirrels.get(0).getX() < link.getX() + link.getW() && squirrels.get(0).getX() + squirrels.get(0).getW() > link.getX() && squirrels.get(0).getY() < link.getY() + link.getH() && squirrels.get(0).getY() + squirrels.get(0).getH() > link.getY()) {
                squirrels.get(0).setHealth(squirrels.get(0).getHealth() - 3);
                if (linkHealth.getW() > 0 && squirrels.get(0).getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
            if(squirrels.get(1).getX() < link.getX() + link.getW() && squirrels.get(1).getX() + squirrels.get(1).getW() > link.getX() && squirrels.get(1).getY() < link.getY() + link.getH() && squirrels.get(1).getY() + squirrels.get(1).getH() > link.getY()) {
                squirrels.get(1).setHealth(squirrels.get(1).getHealth() - 3);
                if (linkHealth.getW() > 0 && squirrels.get(1).getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
            if(squirrels.get(2).getX() < link.getX() + link.getW() && squirrels.get(2).getX() + squirrels.get(2).getW() > link.getX() && squirrels.get(2).getY() < link.getY() + link.getH() && squirrels.get(2).getY() + squirrels.get(2).getH() > link.getY()) {
                squirrels.get(2).setHealth(squirrels.get(2).getHealth() - 3);
                if (linkHealth.getW() > 0 && squirrels.get(2).getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
            if(squirrels.get(3).getX() < link.getX() + link.getW() && squirrels.get(3).getX() + squirrels.get(3).getW() > link.getX() && squirrels.get(3).getY() < link.getY() + link.getH() && squirrels.get(3).getY() + squirrels.get(3).getH() > link.getY()) {
                squirrels.get(3).setHealth(squirrels.get(3).getHealth() - 3);
                if (linkHealth.getW() > 0 && squirrels.get(3).getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
            if(squirrels.get(4).getX() < link.getX() + link.getW() && squirrels.get(4).getX() + squirrels.get(4).getW() > link.getX() && squirrels.get(4).getY() < link.getY() + link.getH() && squirrels.get(4).getY() + squirrels.get(4).getH() > link.getY()) {
                squirrels.get(4).setHealth(squirrels.get(4).getHealth() - 3);
                if (linkHealth.getW() > 0 && squirrels.get(4).getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
            if(vaati.getX() < link.getX() + link.getW() && vaati.getX() + vaati.getW() > link.getX() && vaati.getY() < link.getY() + link.getH() && vaati.getY() + vaati.getH() > link.getY()){
                vaati.setHealth(vaati.getHealth() - 3);
                if (linkHealth.getW() > 0 && vaati.getHealth() > 0) {
                    linkHealth.setW(linkHealth.getW() - 1);
                }
            }
        }
    }

    public void squirrelLostDec(){
        if(inForest && squirrels.get(0).getHealth() <= 0 && squirrels.get(1).getHealth() <= 0 && squirrels.get(2).getHealth() <= 0 && squirrels.get(3).getHealth() <= 0 && squirrels.get(4).getHealth() <= 0){
            squirrelLost = true;
        }
    }


    public void closeWindow(JFrame gui, AudioClip song){
        if((lose|| win) && space){
            gui.dispose();
            song.stop();
            System.exit(0);
            //Exits system
        }
    }




}
