package hu.the.cunpo1;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class CUNPO1Prog9 extends JFrame implements ActionListener, ItemListener
{
    public JButton button = new JButton("Törlés");
    public JCheckBox checkbox1 = new JCheckBox("Kék/Piros");
    public JCheckBox checkbox2 = new JCheckBox("Kisbetű/Nagybetű");
    public JLabel label = new JLabel("Szöveg");
    public JTextField textfield = new JTextField(10);
    
    
    CUNPO1Prog9()
    {
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        
        add(label);
        add(textfield);
        add(button);
        add(checkbox1);
        add(checkbox2);
        
        button.addActionListener(this);
        checkbox1.addItemListener(this);
        checkbox2.addItemListener(this);
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
        if ( e.getSource() == checkbox1 )
        {
            if ( checkbox1.isSelected() )
            {
                textfield.setForeground(java.awt.Color.BLUE);
            }
            else
            {
                textfield.setForeground(java.awt.Color.BLACK);
            }
        }
        else if ( e.getSource() == checkbox2 )
        {
            if ( checkbox2.isSelected() )
            {
                textfield.setText(textfield.getText().toUpperCase());
            }
            else
            {
                textfield.setText(textfield.getText().toLowerCase());
            }
        }
    }

    public static void main(String[] args)
    {
        new CUNPO1Prog9();
    }
}