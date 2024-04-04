package hu.the.cunpo1;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class CUNPO1Prog10 extends JFrame implements ActionListener, ItemListener
{
    public JButton button = new JButton("Törlés");
    public JRadioButton radiobutton1 = new JRadioButton("Kék");
    public JRadioButton radiobutton2 = new JRadioButton("Piros");
    public JRadioButton radiobutton3 = new JRadioButton("Kisbetű");
    public JRadioButton radiobutton4 = new JRadioButton("Nagybetű");
    public JLabel label = new JLabel("Szöveg");
    public JTextField textfield = new JTextField(10);
    
    
    CUNPO1Prog10()
    {
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        
        add(label);
        add(textfield);
        add(button);
        add(radiobutton1);
        add(radiobutton2);
        add(radiobutton3);
        add(radiobutton4);
        
        button.addActionListener(this);
        radiobutton1.addItemListener(this);
        radiobutton2.addItemListener(this);
        radiobutton3.addItemListener(this);
        radiobutton4.addItemListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == button )
        {
            textfield.setText("");
        }
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        if ( e.getSource() == radiobutton1 )
        {
            if ( radiobutton1.isSelected() )
            {
                textfield.setForeground(java.awt.Color.BLUE);
            }
        }
        
        if ( e.getSource() == radiobutton2 )
        {
            if ( radiobutton2.isSelected() )
            {
                textfield.setForeground(java.awt.Color.RED);
            }
        }
        
        if ( e.getSource() == radiobutton3 )
        {
            if ( radiobutton3.isSelected() )
            {
                textfield.setText(textfield.getText().toLowerCase());
            }
        }
        
        if ( e.getSource() == radiobutton4 )
        {
            if ( radiobutton4.isSelected() )
            {
                textfield.setText(textfield.getText().toUpperCase());
            }
        }
    }

    public static void main(String[] args)
    {
        new CUNPO1Prog10();
    }
}