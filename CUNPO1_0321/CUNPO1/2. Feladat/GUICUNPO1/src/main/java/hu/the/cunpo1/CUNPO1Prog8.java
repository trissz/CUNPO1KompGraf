package hu.the.cunpo1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class CUNPO1Prog8 extends JFrame
{
    private JPanel panel;
    
    CUNPO1Prog8()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CUNPO1-Színek");
        
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(10, 10, 100, 100);
                g.setColor(Color.MAGENTA);
                g.fillRect(150, 10, 100, 100);
                g.setColor(Color.CYAN);
                g.fillRect(290, 10, 100, 100);
            }
        };
        
        setLayout(null);
        
        panel.setBackground(Color.YELLOW);
        setContentPane(panel);
        
        setSize(500, 300);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog8();
    }
}