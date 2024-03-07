package hu.the.cunpo1;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CUNPO1Prog3 extends JFrame
{
    JLabel text1;
    JLabel text2;
    
    CUNPO1Prog3()
    {
        text1 = new JLabel("Programtervező informatikus, BSc");
        text2 = new JLabel("Programtervező informatikus, 2024");
        
        text1.setBounds(50, 50, 250, 30);
        text2.setBounds(50, 100, 250, 30);
        
        add(text1);
        add(text2);
        
        //setLayout(null);
        setLayout(new FlowLayout());
        
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog3();
    }
}
