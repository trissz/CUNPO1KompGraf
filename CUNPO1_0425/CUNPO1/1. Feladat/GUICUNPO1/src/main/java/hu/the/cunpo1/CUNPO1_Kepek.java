package hu.the.cunpo1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;

public class CUNPO1_Kepek extends JFrame
{
    public Graphics gd;
    public JPanel imagePanel;
    public int frameWidth, frameHeight;
    public int img1PosX = 5, img1PosY = 5;
    public int img1Width, img1Height;
    public int img2PosX = 80, img2PosY = 5;
    public int img2Width, img2Height;
    public int img3PosX = 220, img3PosY = 5;
    public int img3Width, img3Height;
    
    CUNPO1_Kepek()
    {
        setTitle("Képek méretezése");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        
        ImageIcon imgIcon = new ImageIcon("C:\\BTGit\\CUNPO1KompGraf\\CUNPO1_0425\\CUNPO1\\1. Feladat\\GUICUNPO1\\src\\main\\resources\\cardImages\\THE.jpg");
        Image img = imgIcon.getImage();
        
        setVisible(true);
        
        frameWidth = getContentPane().getWidth();
        frameHeight = getContentPane().getHeight();
        
        int iconWidth = imgIcon.getIconWidth();
        int iconHeight = imgIcon.getIconHeight();
        
        float resize_helper = frameHeight / iconHeight;
        
        img1Width = (int)(iconWidth / 4 * resize_helper);
        img1Height = (int)(iconHeight / 4 * resize_helper);
        
        img2Width = (int)(iconWidth / 2 * resize_helper);
        img2Height = (int)(iconHeight / 2 * resize_helper);
        
        img3Width = (int)(iconWidth * resize_helper);
        img3Height = (int)(iconHeight * resize_helper);
        
        imagePanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics gd)
            {
                super.paintComponent(gd);
                
                gd.drawImage(img, img1PosX, img1PosY, img1Width, img1Height, this);
                gd.drawImage(img, img2PosX, img2PosY, img2Width, img2Height, this);
                gd.drawImage(img, img3PosX, img3PosY, img3Width, img3Height, this);
            }
        };

        add(imagePanel);
        
        repaint();
    }
    
    @Override
    public void paint(Graphics gd)
    {
        super.paint(gd);
        
        gd.setColor(Color.BLUE);
        gd.drawRect(10, 33, frameWidth - 5, frameHeight - 6);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1_Kepek();
    }
}