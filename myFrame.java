import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * The JPanel (canvas) for visual graphics. For Single player only
 * 
 * @Carlos Hurtado
 * @2.0
 */
public class myFrame extends JPanel
{
    /**Variables*/
    
    public Paddle paddle;
    public Paddle1 paddle1;
    public Ball ball;
    public Score score;
    private JPanel panel;
    public KeyListener listener;
    private static ActionListener listener1;
    private static Timer t;
    private Color colour1 = Color.BLACK;
    
    
    /**Constructor*/
    
    /**
     * Defaut constructor for the JPanel
     */
    public myFrame() 
    {

        setSize(1280,800);
        //objects for the world
        paddle = new Paddle(80,360,1200,360,this);
        paddle1 = new Paddle1(1200,360,this);
        ball = new Ball(this);
        score = new Score(this);
        setBackground(Color.CYAN);
        //the panel to make all objects visible
        add(paddle1);
        add(ball);
        add(paddle);

        setFocusable(true);
        setVisible(true);
        //the up down keys
        listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }
    
    
    /**Methods*/
    
    /**
     * The method to draw and paint the different componenets of the JPanel
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //court
        g2d.setColor(changeColor2());
        Rectangle leRect = new Rectangle(630,0,20,800);
        g2d.draw(leRect);
        g2d.fill(leRect);
        g2d.drawOval(440,200,400,400);
        //paddles and ball and score
        g2d.setColor(changeColor());
        ball.paint(g2d);
        paddle.paint(g2d);
        paddle1.paint(g2d);
        score.paint(g2d);
    }
    
    /**
     * Method to display final score and automatically quit the game
     */
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Final Score: "+score.version()  , "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    
    public Color changeColor()
    {
        if(ball.getBall().intersects(paddle.getRect()) || ball.getBall().intersects(paddle1.getRect()))
        {
            int colour = (int) (Math.random()*4);
            if(colour == 0)
            {
                colour1= Color.ORANGE;
            }
            else if(colour == 1)
            {
                colour1= Color.GREEN;
            }   
            else if(colour == 2)
            {
                colour1= Color.MAGENTA;
            }
            else if(colour==3)
            {
                colour1= Color.BLACK;
            }
        }
        return colour1;
    }
    public Color changeColor2()
    {
        if(ball.getBall().intersects(paddle.getRect()) || ball.getBall().intersects(paddle1.getRect()))
        {
            int colour = (int) (Math.random()*4);
            if(colour == 0)
            {
                colour1= Color.WHITE;
            }
            else if(colour == 1)
            {
                colour1= Color.BLACK;
            }   
            else if(colour == 2)
            {
                colour1= Color.YELLOW;
            }
            else if(colour ==3)
            {
                colour1= Color.RED;
            }
        }
        return colour1;
    }
    /**SPECIAL CLASS*/
    /**
     * Class that allows the user to move the paddles
     */
    public class MyKeyListener implements KeyListener 
    {
        @Override
        public void keyPressed(KeyEvent event) 
        {
            if(event.getKeyCode() ==  KeyEvent.VK_UP)   
            {
                paddle.moveRectangleBy1(0,-25); //method being called from the Paddle class
                paddle1.moveRectangleBy2(0,-25);
            }    
            else if(event.getKeyCode() ==  KeyEvent.VK_DOWN)
            {
                paddle.moveRectangleBy1(0,25);
                paddle1.moveRectangleBy2(0,25);
            }
        }
        public void keyTyped(KeyEvent event) {}
        public void keyReleased(KeyEvent event) {}
    }
}