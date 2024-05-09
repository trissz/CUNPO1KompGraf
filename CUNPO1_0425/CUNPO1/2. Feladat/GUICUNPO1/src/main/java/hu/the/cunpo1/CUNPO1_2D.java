package hu.the.cunpo1;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class CUNPO1_2D extends JFrame
{
    public JPanel drawingPanel;
    public int frameWidth, frameHeight;
    public float imgResizeHelper;
    
    CUNPO1_2D()
    {
        setTitle("2D JAVA Grafika");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        ImageIcon imgIcon = new ImageIcon("C:\\BTGit\\CUNPO1KompGraf\\CUNPO1_0425\\CUNPO1\\2. Feladat\\GUICUNPO1\\src\\main\\resources\\cardImages\\THE.jpg");
        Image img = imgIcon.getImage();
        
        setVisible(true);
        
        frameWidth = getContentPane().getWidth();
        frameHeight = getContentPane().getHeight();
        
        int iconWidth = imgIcon.getIconWidth();
        int iconHeight = imgIcon.getIconHeight();
        
        drawingPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics gd)
            {
                super.paintComponent(gd);
                Graphics2D g2d = (Graphics2D) gd.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
                int ox = getSize().width / 2;
                int oy = getSize().height / 2;

                g2d.translate(ox, oy);

                int ellipse1_posX = -230;
                int ellipse1_posY = -150;
                double ellipse1_width = 500.0d;
                double ellipse1_height = 250.0d;

                int ellipse2_posX = -250;
                int ellipse2_posY = -500;
                double ellipse2_width = 350.0d;
                double ellipse2_height = 450.0d;

                g2d.rotate(Math.toDegrees((-1) * Math.PI / 8));

                Shape clipShape = g2d.getClip();

                Ellipse2D ellipse1 = new Ellipse2D.Double(ellipse1_posX, ellipse1_posY, ellipse1_width, ellipse1_height);
                Ellipse2D ellipse2 = new Ellipse2D.Double(ellipse2_posX, ellipse2_posY, ellipse2_width, ellipse2_height);

                g2d.setClip(ellipse1);

                int gradientSpacing = 10;

                g2d.setPaint(Color.BLUE);
                g2d.setStroke(new BasicStroke(7));
                g2d.draw(ellipse2);
                g2d.setPaint(Color.GREEN);
                g2d.fill(ellipse2);

                g2d.setClip(clipShape);
                
                double startAngle = Math.toDegrees((-1) * Math.PI / 2.4);
                double endAngle = Math.toDegrees(Math.PI / 2.4);
                
                Arc2D arc = new Arc2D.Double(
                    ellipse1_posX,
                    ellipse1_posY,
                    ellipse1_width,
                    ellipse1_height,
                    startAngle,
                    endAngle - startAngle,
                    Arc2D.OPEN
                );
                
                GradientPaint gradientPaint2 = new GradientPaint((int)(ellipse1_posX - ellipse1_width / 2), (int)(ellipse1_posY - ellipse1_height / 2), Color.BLUE, (int)(ellipse1_posX - ellipse1_width / 2) + gradientSpacing, (int)(ellipse1_posY - ellipse1_height / 2) + gradientSpacing, Color.YELLOW, true);
                g2d.setPaint(gradientPaint2);
                g2d.fill(arc);

                int imgPosX = ( getWidth() - iconWidth ) / 2 - 290;
                int imgPosY = ( getHeight() - iconHeight ) / 2 - 310;
                float imgSizeMul = 1.3f;
                g2d.rotate(Math.toDegrees((-1) * Math.PI / 8) + 0.5);
                float opacity = 0.8f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(img, imgPosX, imgPosY, (int)(iconWidth * imgSizeMul), (int)(iconHeight * imgSizeMul), this);
                
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                
                String label = "Tokaj Hegyalja Egyetem";
                Font font = new Font("Times New Roman", Font.BOLD, 30);
                g2d.setFont(font);
                FontMetrics metrics = g2d.getFontMetrics(font);
                int labelWidth = metrics.stringWidth(label);
                int labelHeight = metrics.getHeight();
                int labelPosX = imgPosX + (iconWidth - labelWidth) / 2;
                int labelPosY = imgPosY + iconHeight + labelHeight + 50;
                
                GradientPaint gradientPaint1 = new GradientPaint(labelPosX, labelPosY, Color.BLACK, labelPosX + labelWidth, labelPosY + labelHeight, Color.RED);
                g2d.setPaint(gradientPaint1);
                
                g2d.drawString(label, labelPosX, labelPosY);
                
                g2d.dispose();
            }
        };
        
        drawingPanel.setBackground(Color.lightGray);

        add(drawingPanel);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1_2D();
    }
}