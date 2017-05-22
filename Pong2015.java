import java.awt.*;
import javax.swing.*;

/**
 * This class is the driver class of the game. It creates the world using a GUI, or Graphical User Interface, through
 * the use of JPanel and JFrame
 * 
 * @Carlos Hurtado
 * @2.0
 */
public class Pong2015 extends Thread
{
   public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Pong");
        myFrame panel = new myFrame();
        panel.setFocusable(true); //allows for the JPanel to repaint
        panel.requestFocusInWindow();
        frame.setSize(1280,800);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        while(true)
        {
            panel.ball.moveBall();
            Thread.sleep(5); //makes the ball move slow enough for the user to visually see
            panel.ball.repaint();
            panel.repaint();
            if(panel.ball.getBall().intersects(panel.paddle.getRect()) || panel.ball.getBall().intersects(panel.paddle1.getRect()))
            {
                int colour = (int) (Math.random()*4);
                if(colour == 0)
                {
                    panel.setBackground(Color.YELLOW);
                }
                else if(colour == 1)
                {
                    panel.setBackground(Color.CYAN);
                }
                else if(colour == 2)
                {
                    panel.setBackground(Color.WHITE);
                }
                else
                {
                    panel.setBackground(Color.GREEN);
                }
            }
        }
    }
}
