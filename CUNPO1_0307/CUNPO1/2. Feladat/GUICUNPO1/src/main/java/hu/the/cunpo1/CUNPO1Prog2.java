package hu.the.cunpo1;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CUNPO1Prog2 extends JFrame
{
    JLabel text;
    
    CUNPO1Prog2()
    {
        text = new JLabel("Programtervező informatikus, BSc");
        add(text);
        setSize(400, 300);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog2();
    }
}
