package hu.the.cunpo1;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class CUNPO1Prog11 extends JFrame
{
    public DefaultListModel<String> name_list_model = new DefaultListModel<>();
    public JList<String> name_list;
    
    CUNPO1Prog11 ()
    {
        setSize(220, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PTI");
        getContentPane().setBackground( Color.GRAY );
        
        initializeList();
        
        name_list = new JList<>(name_list_model);
        
        JScrollPane scroll_pane = new JScrollPane(name_list);
        
        getContentPane().add(scroll_pane);
        
        revalidate();
        repaint();
        
        setVisible(true);
    }
    
    public void initializeList()
    {
        name_list_model.addElement("Laczkó Lajos");
        name_list_model.addElement("Veres Zoltán");
        name_list_model.addElement("Mihály Károly");
        name_list_model.addElement("Papp Kevin");
        name_list_model.addElement("Fejér Zakariás");
        name_list_model.addElement("Bárdos Triszten");
    }
    
    public static void main(String[] args)
    {
        new CUNPO1Prog11();
    }
}
