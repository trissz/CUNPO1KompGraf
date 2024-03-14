package hu.the.cunpo1;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CUNPO1Prog3 extends JFrame
{
    JLabel text1;
    JLabel text2;
    
    CUNPO1Prog3()
    {
        text1 = new JLabel("Programtervező informatikus, PTI");
        text2 = new JLabel("Programtervező informatikus, 2024");
        
        text1.setBounds(50, 50, 250, 30);
        text2.setBounds(50, 100, 250, 30);
        
        add(text1);
        add(text2);
        
        setLayout(null);
        //setLayout(new FlowLayout());
        
        //setLocationRelativeTo(null);
        centerFrame();
        
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void centerFrame()
    {
        Dimension windowSize = getSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = graphicsEnvironment.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2 - 200;
        int dy = centerPoint.y - windowSize.height / 2 - 150;    
        setLocation(dx, dy);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog3();
    }
}
