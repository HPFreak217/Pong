import java.awt.*;
import javax.swing.*;
/**
 * The class that is designed for a square ball for the game. Requires computer generated movement
 * 
 * @Carlos Hurtado
 * @2.0
 */
public class Ball extends JComponent
{
    /**Variables*/
    private myFrame frame;
    private Rectangle ball;
    private boolean intersected1;//boolean to see if the ball has came in contact with the paddle to the left
    private boolean intersected2;// boolean to see if the ball has came in contact with the paddle to the right
    public int x;
    public int y;
    /**
     * Constructor for objects of class Paddle
     */
    public Ball(myFrame frame)
    { 
        this.frame = frame;
        ball = new Rectangle(640,400, 25,25);
        /**The rest of the code in the constructor determines which direction the ball should move*/
        int which = (int)(Math.random()*3);
        if(which == 0)
        {
            intersected1 = false;
            intersected2 = true;
            x = -1;
            y = -1;
        }
        else if (which ==1)
        {
            intersected1 = false;
            intersected2 = true;
            x = -1;
            y = 1;
        }
        else if(which ==2)
        {
            intersected1 = true;
            intersected2 = false;
            x = 1;
            y = -1;
        }
        else
        {
            intersected1 = true;
            intersected2 = false;
            x = 1;
            y = 1;
        }
    }
    
    /**Methods*/
    
    /**
     * Method used to paint the ball onto the world
     */
    public void paintComponent(Graphics g)
    {  
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(ball);
        g2.setColor(frame.changeColor());
        g2.fill(ball);
    }
    
    /**
     * Method to control the ball movement and determines when to bounce. 
     * Also increases score when it comes in contact with a paddle
     */
    public void moveBall()
    { 
        if(ball.intersects(frame.paddle.getRect()) || ball.intersects(frame.paddle1.getRect()))
        {
            if(ball.intersects(frame.paddle.getRect()) && (y==-1 || y ==1))
            {
                intersected1 = true;
                intersected2 = false;
                x=1;
                ball.translate(x,y);
                frame.score.changeScore();
                repaint();
            }
            else if(ball.intersects(frame.paddle1.getRect()) && (y==1|| y ==-1))
            {
                intersected1 = false;
                intersected2 = true;
                x=-1;
                ball.translate(x,y);
                frame.score.changeScore();
                repaint();
            }
        }
        else if(ball.getY()>0 && ball.getY()<800-55) //the ball mover
        {
            ball.translate(x,y);
            repaint();
        }    
        else if(ball.getX()<=20 || ball.getX()>=frame.getWidth()-20)
        {
            frame.gameOver();
        }
        else
        {
            if(ball.getY() <=0)
            {
                if(intersected1 && ball.getY()<=0) //good
                {
                    x= 1;
                    y= 1;
                    ball.translate(x,y);
                    repaint();
                }
                else if(intersected2 && ball.getY() <=0)//good
                {
                    x = -1;
                    y = 1;
                    ball.translate(x,y);
                    repaint();
                }
            }
            else if(ball.getY()>=800-55){//good
                if(intersected1 && ball.getY()>=800-55)
                {
                    x = 1;
                    y = -1;
                    ball.translate(x,y);
                    repaint();
                }
                else if(intersected2 && ball.getY()>=800-55)//good
                {
                    x = -1;
                    y = -1;
                    ball.translate(x,y);
                    repaint();
                }
               
            }
            
        }
        
    }
    public Rectangle getBall()
    {
        return ball;
    }
}