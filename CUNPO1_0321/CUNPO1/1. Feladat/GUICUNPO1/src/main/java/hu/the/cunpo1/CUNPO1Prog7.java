package hu.the.cunpo1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

class CUNPO1Prog7 extends JFrame
{
    JLabel text1 = new JLabel("Programtervező informatikus 2024");
    JLabel text2 = new JLabel("Programtervező informatikus 2024");
    JLabel text3 = new JLabel("Programtervező informatikus 2024");
    
    Font text1Font = new Font("serif", Font.ITALIC | Font.BOLD, 30);
    Font text2Font = new Font("serif", Font.BOLD, 20);
    Font text3Font = new Font("serif", Font.ITALIC, 15);
    
    CUNPO1Prog7()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.YELLOW);
        
        text1.setForeground(Color.BLUE);
        text1.setFont(text1Font);
        Dimension size1 = text1.getPreferredSize();
        text1.setBounds(30, 50, 1000, size1.height);
        add(text1);
        
        text2.setForeground(Color.BLACK);
        text2.setFont(text2Font);
        Dimension size2 = text2.getPreferredSize();
        text2.setBounds(30, 125,1000, size2.height);
        add(text2);
        
        text3.setForeground(Color.RED);
        text3.setFont(text3Font);
        Dimension size3 = text3.getPreferredSize();
        text3.setBounds(30, 200, 1000, size3.height);
        add(text3);
        
        setLayout(null);
        
        setTitle("Bárdos");
        
        setSize(650, 300);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog7();
    }
}