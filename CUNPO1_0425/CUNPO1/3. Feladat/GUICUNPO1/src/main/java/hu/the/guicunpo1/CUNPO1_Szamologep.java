package hu.the.guicunpo1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CUNPO1_Szamologep extends JFrame implements ActionListener
{
    public int windowWidth = 420;
    public int windowHeight = 550;
    public int horizontalGap = 20;
    public int verticalGap = 20;
    JTextField textField;
    JButton numericButtonArr[] = new JButton[10];
    JButton functionButtonArr[] = new JButton[8];
    JButton plusButton, minusButton, divideButton, multiplyButton;
    JButton decimalButton, changeSignButton, calculateButton, clearButton;
    JPanel panel;
    Font font = new Font("Monospaced", Font.BOLD, 30);
    JButton activeOperatorButton;
    Color chromaticGray = new Color(200, 200, 200);
            
    double number1 = 0, number2 = 0, result = 0;
    char operator;
    
    CUNPO1_Szamologep()
    {
        setTitle("Számológép");
        setSize(windowWidth, windowHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(chromaticGray);
        
        textField = new JTextField();
        textField.setBorder(new LineBorder(Color.MAGENTA, 3));
        textField.setBackground(Color.WHITE);
        textField.setBounds(25, 25, 350, 50);
        textField.setFont(font);
        textField.setEditable(false);
        
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        divideButton = new JButton("/");
        multiplyButton = new JButton("*");
        
        decimalButton = new JButton(".");
        changeSignButton = new JButton("+/-");
        calculateButton = new JButton("=");
        clearButton = new JButton("C");
        
        functionButtonArr[0] = plusButton;
        functionButtonArr[1] = minusButton;
        functionButtonArr[2] = divideButton;
        functionButtonArr[3] = multiplyButton;
        functionButtonArr[4] = decimalButton;
        functionButtonArr[5] = changeSignButton;
        functionButtonArr[6] = calculateButton;
        functionButtonArr[7] = clearButton;
        
        Border roundedBorder = new LineBorder(Color.BLACK, 2, true);
        
        for ( int i = 0; i < 8; i ++ )
        {
            functionButtonArr[i].addActionListener(this);
            functionButtonArr[i].setFont(font);
            functionButtonArr[i].setFocusable(false);
            functionButtonArr[i].setBackground(chromaticGray);
            functionButtonArr[i].setBorder(roundedBorder);
        }
        
        for ( int i = 0; i < 10; i ++ )
        {
            numericButtonArr[i] = new JButton(Integer.toString(i));
            numericButtonArr[i].addActionListener(this);
            numericButtonArr[i].setFont(font);
            numericButtonArr[i].setFocusable(false);
            numericButtonArr[i].setBackground(chromaticGray);
            numericButtonArr[i].setBorder(roundedBorder);
        }
        
        changeSignButton.setBounds(25, 430, 175, 70);
        calculateButton.setBounds(205, 430, 175, 70);
        
        panel = new JPanel();
        panel.setBounds(25, 85, 350, 330);
        panel.setLayout(new GridLayout(4, 4,horizontalGap,verticalGap));
        
        panel.add(numericButtonArr[1]);
        panel.add(numericButtonArr[2]);
        panel.add(numericButtonArr[3]);
        panel.add(plusButton);
        panel.add(numericButtonArr[4]);
        panel.add(numericButtonArr[5]);
        panel.add(numericButtonArr[6]);
        panel.add(minusButton);
        panel.add(numericButtonArr[7]);
        panel.add(numericButtonArr[8]);
        panel.add(numericButtonArr[9]);
        panel.add(multiplyButton);
        panel.add(numericButtonArr[0]);
        panel.add(clearButton);
        panel.add(decimalButton);
        panel.add(divideButton);
        
        panel.setBackground(chromaticGray);
        
        add(panel);
        add(changeSignButton);
        add(calculateButton);
        add(textField);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new CUNPO1_Szamologep();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for ( int i = 0; i < 10; i ++ )
        {
            if ( e.getSource() == numericButtonArr[i] )
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        
        if ( e.getSource() == decimalButton )
        {
            if ( textField.getText().indexOf('.') < textField.getText().length() )
            {
                textField.setText(textField.getText().concat("."));
            }
        }
        
        if ( e.getSource() == plusButton )
        {
            if ( !textField.getText().equals("") )
            {
                number1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }

                activeOperatorButton = plusButton;
                activeOperatorButton.setBackground(Color.GREEN);
            }
        }
        
        if ( e.getSource() == minusButton )
        {
            if ( !textField.getText().equals("") )
            {
                number1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }

                activeOperatorButton = minusButton;
                activeOperatorButton.setBackground(Color.GREEN);
            }
        }
        
        if ( e.getSource() == multiplyButton )
        {
            if ( !textField.getText().equals("") )
            {
                number1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }

                activeOperatorButton = multiplyButton;
                activeOperatorButton.setBackground(Color.GREEN);
            }
        }
        
        if ( e.getSource() == divideButton )
        {
            if ( !textField.getText().equals("") )
            {
                number1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }

                activeOperatorButton = divideButton;
                activeOperatorButton.setBackground(Color.GREEN);
            }
        }
        
        if ( e.getSource() == calculateButton )
        {
            if ( !textField.getText().equals("") )
            {
                number2 = Double.parseDouble(textField.getText());

                switch ( operator )
                {
                    case '+':result = number1 + number2;break;
                    case '-':result = number1 - number2;break;
                    case '*':result = number1 * number2;break;
                    case '/':result = number1 / number2;break;
                }

                textField.setText(String.valueOf(result));
                number1 = result;

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }
            }
        }
        
        /*if ( e.getSource() == clearButton ) //All Clear
        {
            number1 = 0;
            number2 = 0;
            result = 0;
            textField.setText("");
        
            if ( activeOperatorButton != null )
            {
                activeOperatorButton.setBackground(chromaticGray);
            }
        }*/
        
        if ( e.getSource() == clearButton )
        {
            textField.setText("");
            
            if ( activeOperatorButton != null )
            {
                activeOperatorButton.setBackground(chromaticGray);
            }
        }
        
        if ( e.getSource() == changeSignButton )
        {
            if ( !textField.getText().equals("") )
            {
                textField.setText(String.valueOf((-1) * Double.parseDouble(textField.getText())));

                if ( activeOperatorButton != null )
                {
                    activeOperatorButton.setBackground(chromaticGray);
                }
            }
        }
    }
}