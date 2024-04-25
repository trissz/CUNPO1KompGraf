package hu.the.cunpo1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class CUNPO1Prog16 extends JFrame
{
    int frameWidth, frameHeight;
    
    CUNPO1Prog16()
    {
        setTitle("Mértani Alakzatok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setVisible(true);
        setLocationRelativeTo(null);
        
        frameWidth = getWidth();
        frameHeight = getHeight();
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.drawRect(10, 33, frameWidth - 20, frameHeight - 43);
        g2d.fillOval(20, 40, 50, 70);
        g2d.fillOval(100, 40, 70, 50);
        g2d.fillOval(190, 40, 50, 50);
        g2d.fillArc(20, 120, 60, 60, 0, 90);
        g2d.fillArc(100, 120, 60, 60, 90, 90);
        g2d.fillArc(200, 120, 60, 60, 180, 60);
        g2d.fillArc(210, 120, 60, 60, 270, 60);
        drawStripedArc(20, 175, 50, 50, 0, 360, 20, 10, g2d);
        drawStripedArc(100, 175, 30, 50, 0, 360, 20, 10, g2d);
        drawStripedArc(205, 185, 30, 40, 0, 180, 20, 10, g2d);
        g2d.drawRoundRect(230, 105, 30, 30, 10, 10);
    }
    
    public void drawStripedArc(int x, int y, int width, int height, int angleFrom, int angleTo, int angleDiff, int angleStep, Graphics2D g2d)
    {
        for ( int angle = angleFrom; angle < angleTo; angle += angleDiff + angleStep )
        {
            g2d.fillArc(x, y, width, height, angle, angleDiff);
        }
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new CUNPO1Prog16();
        });
    }
}