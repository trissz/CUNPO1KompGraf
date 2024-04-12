package hu.the.cunpo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class CUNPO1Prog13 extends JFrame implements AdjustmentListener
{
    public JTextField textField = new JTextField(10);
    public JLabel label1 = new JLabel("1. adat:");
    public JLabel label2 = new JLabel("2. adat:");
    public JLabel label3 = new JLabel("Összeg:");
    public JScrollBar scrollBar1 = new JScrollBar(JScrollBar.HORIZONTAL, 50, 1, 1, 101);
    public JScrollBar scrollBar2 = new JScrollBar(JScrollBar.HORIZONTAL, 50, 1, 1, 101);
    
    CUNPO1Prog13()
    {    
        setTitle("Öszeadó-Scroll");
        
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        setContentPane(mainPanel);
        
        mainPanel.add(label1);
        mainPanel.add(scrollBar1);
        mainPanel.add(label2);
        mainPanel.add(scrollBar2);
        mainPanel.add(label3);
        mainPanel.add(textField);
        
        scrollBar1.setPreferredSize(new Dimension(200, 50));
        scrollBar2.setPreferredSize(new Dimension(200, 50));
        textField.setPreferredSize(new Dimension(200, 50));
        
        scrollBar1.addAdjustmentListener(this);
        scrollBar2.addAdjustmentListener(this);
        
        setSize(300, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.yellow );
        setVisible(true);
    }
    
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        textField.setText(
            Integer.toString(scrollBar1.getValue()) +
            " + " + Integer.toString(scrollBar2.getValue()) +
            " = " + Integer.toString(scrollBar1.getValue() + scrollBar2.getValue())
        );
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog13();
    }
}