package hu.the.cunpo1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CUNPO1Prog14 extends JFrame implements ActionListener
{
    public JFrame frameSecondary;
    public Button startProcessButton = new Button("CUNPO1 Párbeszédablak");
    public Button cancelButton = new Button("Mégse");
    public Button setButton = new Button("Beállít");
    public JTextArea textArea = new JTextArea();
    public JTextField textField = new JTextField(30);
    public JLabel label = new JLabel("Kérek egy szöveget");
    
    CUNPO1Prog14()
    {
        setTitle("CUNPO1 Párbeszédablak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 140);
        
        setLayout(new BorderLayout());
        
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startProcessButton);

        add(buttonPanel, BorderLayout.SOUTH);
        
        startProcessButton.addActionListener(this);
        cancelButton.addActionListener(this);
        setButton.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == startProcessButton )
        {
            showSecondaryFrame();
        }
        else
        {
            if ( e.getSource() == cancelButton )
            {
                textField.setText("");
                frameSecondary.dispose();
            }
            else
            {
                if ( e.getSource() == setButton )
                {
                    textArea.setText(textField.getText());
                    textField.setText("");
                    frameSecondary.dispose();
                }
            }
        }
    }
    
    public void showSecondaryFrame()
    {
        frameSecondary = new JFrame();
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(label);
        panel.add(textField);
        panel.add(cancelButton);
        panel.add(setButton);

        frameSecondary.add(panel);
        frameSecondary.setTitle("CUNPO1 Párbeszédablak");
        frameSecondary.setSize(450, 120);
        frameSecondary.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameSecondary.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new CUNPO1Prog14());
    }
}