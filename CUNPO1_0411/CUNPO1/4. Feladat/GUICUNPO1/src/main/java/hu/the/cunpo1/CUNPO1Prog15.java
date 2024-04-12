package hu.the.cunpo1;

import javax.swing.JFrame;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CUNPO1Prog15 extends JFrame implements ActionListener
{
    JMenuBar menuBar = new JMenuBar();
    JMenu dataMenu = new JMenu("Adatbevitel");
    JMenu calculationsMenu = new JMenu("Számítások");
    JMenuItem AItem = new JMenuItem("A oldal");
    JMenuItem BItem = new JMenuItem("B oldal");
    JMenuItem areaItem = new JMenuItem("Terület");
    JMenuItem perimeterItem = new JMenuItem("Kerület");
    JMenuItem exitItem = new JMenuItem("Kilépés");
    
    public Integer a, b;
    
    CUNPO1Prog15()
    {
        setTitle("CUNPO1 Menü");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 140);

        dataMenu.add(AItem);
        dataMenu.add(BItem);
        calculationsMenu.add(areaItem);
        calculationsMenu.add(perimeterItem);
        calculationsMenu.addSeparator();
        calculationsMenu.add(exitItem);

        menuBar.add(dataMenu);
        menuBar.add(calculationsMenu);

        setJMenuBar(menuBar);

        exitItem.addActionListener(this);
        AItem.addActionListener(this);
        BItem.addActionListener(this);
        areaItem.addActionListener(this);
        perimeterItem.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == exitItem )
        {
            System.exit(0);
        }
        else if ( e.getSource() == AItem )
        {
            String userInput = JOptionPane.showInputDialog(null, "A téglalap a oldala:");
            String regex = "\\d+";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userInput);
            
            if ( matcher.matches() )
            {
                a = Integer.parseInt(userInput);
            }else System.out.println("Nem megfelelő típusú adat");
        }
        else if ( e.getSource() == BItem )
        {
            String userInput = JOptionPane.showInputDialog(null, "A téglalap b oldala:");
            String regex = "\\d+";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userInput);
            
            if ( matcher.matches() )
            {
                b = Integer.parseInt(userInput);
            }else System.out.println("Nem megfelelő típusú adat");
            
            b = Integer.parseInt(userInput);
        }
        else if ( e.getSource() == areaItem )
        {
            if ( a != null && b != null )
            {
                JOptionPane.showMessageDialog(null, "A téglalap területe: " + Integer.toString(a * b));
            }
        }
        else if ( e.getSource() == perimeterItem )
        {
            if ( a != null && b != null )
            {
                JOptionPane.showMessageDialog(null, "A téglalap kerülete: " + Integer.toString(2 * ( a + b )));
            }
        }
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog15();
    }
}