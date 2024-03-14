package hu.the.cunpo1;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CUNPO1Prog5 extends JFrame implements ActionListener
{
    JButton exitButton;
    
    CUNPO1Prog5()
    {
        exitButton = new JButton("Kilépés");
        
        exitButton.setBounds(100, 100, 100, 30);
        exitButton.addActionListener(this);
        
        add(exitButton);
        setLayout(null);
        
        setSize(400, 300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog5();
    }
}
