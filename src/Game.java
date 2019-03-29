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


public class Game extends JComponent implements KeyListener, MouseListener, MouseMotionListener{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private Rectangle player;
    private Rectangle ending;

    //Default Constructor
    public Game()
    {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;
        player = new Rectangle(500,250,50,50);
        ending = new Rectangle(-300, 0, 1000,500);

        //Setting up the GUI
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Learning Graphics");
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
        if(key == 37){
            player.setX(player.getX() - 5);
        }
        if(key == 39){
            player.setX(player.getX() + 5);
        }

    }
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(player.getX(), player.getY(), player.getW(), player.getH());
        g.setColor(Color.BLUE);
        g.fillRect(ending.getX(), ending.getY(), ending.getW(), ending.getH());

    }
    public void loop()
    {

        repaint();
    }
    //These methods are required by the compiler.
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
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
