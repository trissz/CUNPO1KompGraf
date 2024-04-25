package hu.the.cunpo1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CUNPO1Prog17 extends JFrame implements ActionListener
{
    public Graphics2D g2d;
    public Button drawButton = new Button("Rajzolás");
    public int frameWidth, frameHeight;
    public boolean buttonClicked = false;
    
    CUNPO1Prog17()
    {
        setTitle("Rajzolás Gombra kattintva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        
        frameWidth = getWidth();
        frameHeight = getHeight();
        
        setLayout(new BorderLayout());
        
        drawButton.addActionListener(this);
        drawButton.setFont(new Font("Serif", Font.BOLD, 14));
        drawButton.setBackground(Color.lightGray);
        add(drawButton, BorderLayout.SOUTH);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        g2d = (Graphics2D) g;
        
        int xStep = 10;
        
        g2d.setColor(Color.RED);
        
        for ( int toX = 10; toX <= 350; toX += xStep )
        {
            g2d.drawLine(0, 0, toX, frameHeight);
        }
        
        if ( buttonClicked )
        {
            g2d.setColor(Color.BLUE);

            for (int toX = frameWidth; toX >= 0; toX -= xStep)
            {
                g2d.drawLine(frameWidth, 0, toX, frameHeight);
            }
        }
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new CUNPO1Prog17();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == drawButton )
        {
            buttonClicked = true;
            repaint();
        }
    }
}