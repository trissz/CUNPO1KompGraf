package pathfinder_a_star;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import static pathfinder_a_star.Pathfinder_A_star.end;
import static pathfinder_a_star.Pathfinder_A_star.start;
import static pathfinder_a_star.Pathfinder_A_star.diagonal_is_allowed;
import static pathfinder_a_star.Pathfinder_A_star.perform_with_heuristics;
import static pathfinder_a_star.Pathfinder_A_star.BUTTON_BORDER_COLOR;

public class Point implements ActionListener
{
    public JButton button;
    public int row_coordinate;
    public int column_coordinate;
    public double local_score = Double.POSITIVE_INFINITY;
    public double global_score = Double.POSITIVE_INFINITY;
    
    public int parent_row;
    public int parent_column;
    
    Point(int row, int column)
    {
        button = new JButton();
        button.addActionListener(this);
        
        button.setBorder(BorderFactory.createLineBorder(BUTTON_BORDER_COLOR, 1)); //Vonal keret
        //button.setBorder(BorderFactory.createEtchedBorder(0)); //Minimális kerettel
        //button.setBorder(BorderFactory.createEmptyBorder()); //Üres keret
        
        this.row_coordinate = row;
        this.column_coordinate = column;
                
        button.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                if ( ( row_coordinate != start.row_coordinate || column_coordinate != start.column_coordinate ) && ( row_coordinate != end.row_coordinate || column_coordinate != end.column_coordinate ) )
                {
                    if ( SwingUtilities.isLeftMouseButton(e) )
                    {
                        Pathfinder_A_star.object_points.add(Point.this);
                    }else if ( SwingUtilities.isRightMouseButton(e) )
                    {
                        Pathfinder_A_star.object_points.remove(Point.this);
                    }

                    Pathfinder_A_star.performAstar(start, end, diagonal_is_allowed, perform_with_heuristics);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == button )
        {
            if ( ( row_coordinate != start.row_coordinate || column_coordinate != start.column_coordinate ) && ( row_coordinate != end.row_coordinate || column_coordinate != end.column_coordinate ) )
            {
                if ( Pathfinder_A_star.object_points.contains(this) )
                {
                    Pathfinder_A_star.object_points.remove(this);
                }else Pathfinder_A_star.object_points.add(this);
                
                Pathfinder_A_star.performAstar(start, end, diagonal_is_allowed, perform_with_heuristics);
            }
        }
    }
}
