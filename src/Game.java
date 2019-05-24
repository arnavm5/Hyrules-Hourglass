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
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Game extends JComponent implements KeyListener, MouseListener, MouseMotionListener{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private Player link;
    private ArrayList<Rectangle> gameSceneObjects;
    private Rectangle house;
    private boolean initiallyInside;

    //Default Constructor
    public Game()
    {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;

        int houseW = 450;
        int houseH = 350;
        link = new Player(WIDTH/2 - 25,HEIGHT/2 - 30, 100, 3, true);
        initiallyInside = link.isInside();

        house = new Rectangle(WIDTH/2 - houseW/2, HEIGHT/2 - houseH/2, houseW, houseH, false);
        gameSceneObjects = Scene.getHouseSceneObjects(house);


        //Setting up the GUI
        JFrame gui = new JFrame();
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
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        link.keyPressedPlayer(key);

    }


    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        house.paintHouse(g);
        g.fillRect(gameSceneObjects.get(4).getX(), gameSceneObjects.get(4).getY(), gameSceneObjects.get(4).getW(), gameSceneObjects.get(4).getH());
        //All characters must be drawn last
        this.link.paintPlayer(g);

    }

    public void loop()
    {
        link.timePressedMove();
        link.sceneCollision(house, 58, 62);
        house.screenCollision(link);
        for(Rectangle r: gameSceneObjects)
            link.recCollision(r, 5, 16);
        link.movePlayer();
        link.moveScene(gameSceneObjects);
        if(!initiallyInside)
            link.movementSwitch(house);
        //System.out.println("SCENE isOnLEdge"+scene.isOnEdge());
        //System.out.println("is link inside? "+link.isInside());
        repaint();
    }

    //These methods are required by the compiler.
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        link.keyReleasedPlayer(key);
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
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

    public static void main(String[] args)
    {
        Game g = new Game();
        g.start(60);
    }

}
