package hu.the.cunpo1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CUNPO1Prog4
{

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Grafikus felület");
        frame.setBounds(20, 20, 400, 300);
        frame.getContentPane().setLayout(null);
        
        JLabel label = new JLabel("Helló CUNPO1");
        frame.getContentPane().add(label);
        
        label.setBounds(40, 100, 100, 20);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
