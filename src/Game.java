import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.applet.*;
import java.util.ArrayList;


public class Game extends JComponent implements KeyListener, MouseListener, MouseMotionListener{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private Player link;
    private ArrayList<Rectangle> gameSceneObjects;
    private Rectangle house, village, castle, forest;
    private Scene scene;
    private int count;
    private AudioClip song;
    private JFrame gui;

    //Default Constructor
    public Game() {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;
        song = Applet.newAudioClip(this.getClass().getResource("/Assets/Sounds/House.wav"));

        int houseW = 450;
        int houseH = 350;
        link = new Player(WIDTH/2 - 25,HEIGHT/2 - 30, 100, 3, true);

        house = new Rectangle(WIDTH/2 - houseW/2, HEIGHT/2 - houseH/2, houseW, houseH, false);
        village = new Rectangle(-1, -342, 1000, 1000, false);
        castle = new Rectangle(-117, -340, 1300, 825, false);
        forest = new Rectangle(0, 0, 1010, 510, false);
        scene = new Scene();
        gameSceneObjects = scene.getHouseSceneObjects(house);
        count = 0;

        //Setting up the GUI
        gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Legend of Zelda: Hyrule's Hourglass");
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30));
        gui.setResizable(false);
        gui.getContentPane().add(this);
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.addKeyListener(this);
        gui.addMouseListener(this);
        gui.addMouseMotionListener(this);


    }

    //This method will acknowledge user input
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);
        link.keyPressedPlayer(key);
        scene.sceneKeyPressed(key);

    }

    //All your UI drawing goes in here
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);
        scene.paintScene(g, house, 0, link);
        scene.paintScene(g, village, 1, link);
        scene.paintScene(g, castle, 2, link);
        scene.paintScene(g, forest, 3, link);
        scene.paintText(g, link);
        scene.paintSquirrels(g);

        //for(Rectangle x:gameSceneObjects){
        //    g.fillRect(x.getX(), x.getY(), x.getW(), x.getH());
        //}
        //g.fillRect(gameSceneObjects.get(2).getX(), gameSceneObjects.get(2).getY(), gameSceneObjects.get(2).getW(), gameSceneObjects.get(2).getH());
        //All characters must be drawn last
        if(!scene.getFaint() && !scene.isWin() && !scene.isLose()) {
            link.paintPlayer(g);
        }

    }

    public void sceneFixtures(){
        if(scene.isInHouse()) {
            if(count % 2 == 0){
                gameSceneObjects = scene.getHouseSceneObjects(house);
                song.stop();
                song = Applet.newAudioClip(this.getClass().getResource("Assets/Sounds/House.wav"));
                song.loop();
                count ++;
            }
            link.sceneCollision(house, 58, 62);
            house.screenCollision(link, 100, 100);
            link.moveScene(gameSceneObjects, house);
            //System.out.println("In House:" + scene.isInHouse());
        }
        else if(scene.isInVillage()){
            if(count % 2 == 1){
                gameSceneObjects = scene.getVillageSceneObjects(village);
                song.stop();
                song = Applet.newAudioClip(this.getClass().getResource("Assets/Sounds/Village.wav"));
                song.loop();
                count ++;
            }
            link.sceneCollision(village, 0, 70);
            village.screenCollision(link, WIDTH/2, HEIGHT/2);
            link.moveScene(gameSceneObjects, village);
            link.movementSwitch(village);
            //System.out.println("In Village:" + scene.isInVillage());
        }
        else if(scene.isInCastle()){
            if(count % 2 == 0){
                gameSceneObjects = scene.getCastleSceneObjects(castle);
                song.stop();
                song = Applet.newAudioClip(this.getClass().getResource("Assets/Sounds/Castle.wav"));
                song.loop();
                count++;
            }
            link.sceneCollision(castle, 56, 0);
            castle.screenCollision(link, WIDTH/2, HEIGHT/2);
            link.moveScene(gameSceneObjects, castle);
            link.movementSwitch(castle);
            //System.out.println("In Castle:" + scene.isInCastle());
        }
        else if(scene.isInForest()){
            if(count % 2 == 0){
                gameSceneObjects = scene.getForestSceneObjects(forest);
                song.stop();
                song = Applet.newAudioClip(this.getClass().getResource("Assets/Sounds/Forest.wav"));
                song.loop();
                count++;
            }
            link.sceneCollision(forest, 56, 15);
            forest.screenCollision(link, 200, 100);
            link.moveScene(gameSceneObjects, forest);

            //System.out.println("In Forest:" + scene.isInForest());
        }

        for(Rectangle r: gameSceneObjects) {
            link.recCollision(r, 5, 16);
        }
        link.movePlayer();
        scene.sceneChangeExit(link, village, forest);
        scene.sceneChangeEnter(link);
    }


    public void loop() {
        link.timePressedMove();
        sceneFixtures();
        scene.storyHandler(link, castle);
        scene.autoCharacters(village, link, 1);
        scene.autoCharacters(castle, link, 2);
        scene.formSquirrels(link);
        scene.linkAttacking(link);
        scene.closeWindow(gui, song);
        scene.squirrelLostDec();
        repaint();
    }

    //These methods are required by the compiler.
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        link.keyReleasedPlayer(key);
        scene.sceneKeyReleased(key);
    }

    public void mousePressed(MouseEvent e) {
        link.mousePressedPlayer(e.getButton());
    }

    public void mouseReleased(MouseEvent e) {
        link.mouseReleasedPlayer(e.getButton());
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void start(final int ticks){
        Thread gameThread = new Thread(){
            public void run(){
                while(true){
                    loop();
                    try{
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start(60);
    }

}
