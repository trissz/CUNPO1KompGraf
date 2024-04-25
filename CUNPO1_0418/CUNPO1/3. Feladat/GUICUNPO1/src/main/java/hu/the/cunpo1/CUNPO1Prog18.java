package hu.the.cunpo1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class CUNPO1Prog18 extends JFrame implements ActionListener, MouseMotionListener 
{   
    public JPanel drawingPanel;
    public Color drawColor = Color.black; // Default draw color
    public Color bgColor = Color.white;
    public int lineWidth = 3, lineHeight = 3;
    
    CUNPO1Prog18()
    {
        setTitle("Szabadkézi Rajzolás");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        
        drawingPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(bgColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        drawingPanel.setLayout(new BorderLayout());
        drawingPanel.setBackground(bgColor);
        drawingPanel.addMouseMotionListener((MouseMotionListener) this);
        add(drawingPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton clearButton = new JButton("Törlés");
        JButton drawcolorButton = new JButton("Rajzszín");
        JButton bgcolorButton = new JButton("Háttérszín");
        
        clearButton.addActionListener(this);
        drawcolorButton.addActionListener(this);
        bgcolorButton.addActionListener(this);
        
        buttonPanel.add(clearButton);
        buttonPanel.add(drawcolorButton);
        buttonPanel.add(bgcolorButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new CUNPO1Prog18();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getActionCommand().equals("Törlés") )
        {
            drawingPanel.repaint();
        }
        
        if ( e.getActionCommand().equals("Rajzszín") )
        {
            drawColor = JColorChooser.showDialog(this, "Válassza ki a rajz színét", drawColor);
        }
        
        if ( e.getActionCommand().equals("Háttérszín") )
        {
            bgColor = JColorChooser.showDialog(this, "Válassza ki a háttér színét", bgColor);
            drawingPanel.setBackground(bgColor);
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        Graphics2D g2d = (Graphics2D) drawingPanel.getGraphics();
        g2d.setColor(drawColor);
        g2d.fillRect(x, y, lineWidth, lineHeight);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}