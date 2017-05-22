import java.awt.*;
import javax.swing.*;
/**
 * Keeps the score in check and is added to the GUI 
 * 
 * @Carlos Hurtado
 * @2.0
 */
public class Score
{
    /**Variables*/
    private myFrame frame;
    private int score;
    
    /**Constructor*/
    /**
     * The constructor for the Score class. Whenever called, a score is added to the GUI
     */
    public Score(myFrame frame)
    {
        this.frame = frame;
        score = 0;
    }
    
    /**Methods*/
    /**
     * Allows the score to be "painted" to the screen
     */
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString(version(),10,10);
    }
    /**
     * Increases the score whenever the ball comes in contact with a paddle
     */
    public void changeScore()
    {
        score++;
    }
    /**
     * The score to be displayed
     */
    public int leScore()
    {
        return score;
    }
    /**
     * The score that is currently being displayed
     */
    public String version()
    {
        return score + "";
    }
}
