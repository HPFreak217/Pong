import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
/**
 * This class is used for the movement of the paddle
 * 
 * @Carlos Hurtado
 * @2.0
 */
public class Paddle extends JComponent
{
    /**METHODS*/
    
    private static final int BOX_WIDTH = 20;
    private static final int BOX_HEIGHT = 100;
    private static int x;
    private static int y;
    private myFrame frame;
    private Rectangle paddle1;
    
    /**CONSTRUCTORS*/
    
    /**
     * Constructor for objects of class Paddle
     */
    public Paddle(int x, int y, int x1, int y2, myFrame frame)
    {
        paddle1 = new Rectangle(x,y, BOX_WIDTH, BOX_HEIGHT);
        this.x = x;
        this.y = y;
        this.frame = frame;
    }
    
    /**METHODS*/
    
    /**
     * Used for when ball intersects with this paddle
     * @return Returns the representation of this paddle
     */
    public Rectangle getRect()
    {
        return paddle1;
    }
    /**
     * The paint component that is used to make this paddle visible to the user
     */
    public void paintComponent(Graphics g)
      {  
        Graphics2D g2 = (Graphics2D) g;
         g2.draw(paddle1);
          g2.setColor(frame.changeColor());
         g2.fill(paddle1);  
      }
    /**
     * Moves the rectangle by a given amount. 
     * @param dx the amount to move in the x-direction 
     * @param dy the amount to move in the y-direction 
     */
     public void moveRectangleBy1(int dx, int dy)
     {
         if(paddle1.getY() <= 675 && paddle1.getY()>=0)
         {
             paddle1.translate(0, dy);
             repaint(); 
         }
         else
         {
             if(paddle1.getY()<2)
             {
                 paddle1.setLocation(80,0);
                 repaint();
             }
             else
             {
                 paddle1.setLocation(80,675);
                 repaint();
             }
       }
    }
}


