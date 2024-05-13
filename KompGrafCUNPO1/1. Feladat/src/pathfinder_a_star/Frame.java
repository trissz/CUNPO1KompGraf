package pathfinder_a_star;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame
{
    public JFrame frame;
    
    Frame(Grid grid, int rows, int columns)
    {
        frame = new JFrame();
        
        frame.setTitle("Útvonalkereső");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for ( int i = 0; i < rows; i ++ )
        {
            for ( int j = 0; j < columns; j ++ )
            {
                frame.add(grid.points[i][j].button);
            }
        }
        
        frame.setLayout(new GridLayout(rows, columns));
        frame.setSize(1500, 800);
        frame.setVisible(true);
    }
}
