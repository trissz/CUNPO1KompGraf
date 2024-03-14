package hu.the.cunpo1;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CUNPO1Prog6 extends JFrame implements ActionListener
{
    JButton button1, button2, button3;
    
    CUNPO1Prog6()
    {
        button1 = new JButton("Kilépés");
        button2 = new JButton("Változtat");
        button3 = new JButton("Vissza");
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        
        setSize(500, 300);
        
        button1.setBounds(100, 100, 100, 30);
        button2.setBounds(220, 100, 100, 30);
        button3.setBounds(340, 100, 100, 30);
        
        add(button1);
        add(button2);
        add(button3);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog6();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton source = (JButton)e.getSource();
        String name = source.getText();
        
        switch ( name )
        {
            case "Kilépés": System.exit(0);break;
            case "Változtat": setTitle("Működik");break;
            case "Vissza": setTitle("Előző");break;
        }
    }
}
