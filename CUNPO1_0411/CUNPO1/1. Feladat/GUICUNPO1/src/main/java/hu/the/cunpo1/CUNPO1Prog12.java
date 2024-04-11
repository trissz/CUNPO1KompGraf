package hu.the.cunpo1;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CUNPO1Prog12 extends JFrame implements ActionListener
{
    public JButton buttonExit = new JButton("Kilépés");
    public JButton buttonDouble = new JButton("Dupláz");
    public JTextField textField = new JTextField(10);
    
    CUNPO1Prog12()
    {    
        setTitle("Számolás");
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        buttonExit.setBounds(20, 20, 80, 30);
        buttonDouble.setBounds(130, 20, 80, 30);
        textField.setBounds(20, 60, 50, 30);
        
        buttonExit.addActionListener(this);
        buttonDouble.addActionListener(this);
        
        add(buttonExit);
        add(buttonDouble);
        add(textField);
        
        setSize(300, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.blue );
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == buttonExit )
        {
            System.exit(0);
        }
        else
        {
            if ( e.getSource() == buttonDouble )
            {
                String input = textField.getText();
                String regex = "\\d+";
                
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                
                if ( matcher.matches() )
                {
                    textField.setText(Integer.toString(Integer.parseInt(input) * 2));
                }else System.out.println("A beviteli mező értéke nem megfelelő. . . . .");
            }
        }
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog12();
    }
}