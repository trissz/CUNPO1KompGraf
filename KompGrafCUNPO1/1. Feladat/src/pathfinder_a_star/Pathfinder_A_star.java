package pathfinder_a_star;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JFrame;

public class Pathfinder_A_star
{
    public static final int NUMBER_OF_ROWS = 15;
    public static final int NUMBER_OF_COLUMNS = 30;
    
    public static Color PATH_TILE_COLOR = Color.blue;
    public static Color START_TILE_COLOR = Color.yellow;
    public static Color END_TILE_COLOR = Color.black;
    public static Color DEFAULT_TILE_COLOR = new Color(155, 199, 228);
    public static Color OBJECT_TILE_COLOR = new Color(0, 100, 0);
    public static Color BUTTON_BORDER_COLOR = Color.black;
    
    public static Grid grid = new Grid(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    
    public static Set <Point> object_points = new HashSet<>();
    public static Set <Point> path_points = new HashSet<>();
    
    public static Point start = new Point(0, 0);
    public static Point end = new Point(NUMBER_OF_ROWS - 1, NUMBER_OF_COLUMNS - 1);
    
    public static JFrame frame = new Frame(grid, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    
    public static boolean diagonal_is_allowed = true;
    public static boolean perform_with_heuristics = true;
    
    public static void main(String[] args) throws InterruptedException
    {
        //generateRandomObjects();
        
        performAstar(start, end, diagonal_is_allowed, perform_with_heuristics);
    }
    
    static void performAstar(Point start, Point end, boolean diagonal_is_allowed, boolean perform_with_heuristics)
    {
        grid.points[start.row_coordinate][start.column_coordinate].button.setBackground(START_TILE_COLOR);
        grid.points[end.row_coordinate][end.column_coordinate].button.setBackground(END_TILE_COLOR);
        grid.points[start.row_coordinate][start.column_coordinate].local_score = 0;
        grid.points[start.row_coordinate][start.column_coordinate].global_score = euclideanDistanceBetweenTwoPoints(start.row_coordinate, start.column_coordinate, end.row_coordinate, end.column_coordinate);
        
        Set <Point> visited_points_set = new HashSet <>();
        ArrayList <Point> queue = new ArrayList <>();
        
        visited_points_set.add(grid.points[start.row_coordinate][start.column_coordinate]);
        queue.add(grid.points[start.row_coordinate][start.column_coordinate]);
        
        while ( !queue.isEmpty() )
        {
            if ( queue.get(0).row_coordinate - 1 >= 0 && !object_points.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate]) ) //UP
            {
                if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate]) )
                {
                    visited_points_set.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate]);
                    queue.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate]);
                }
                
                if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].local_score )
                {
                    grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].parent_row = queue.get(0).row_coordinate;
                    grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].parent_column = queue.get(0).column_coordinate;
                    grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                    grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].global_score = grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate - 1, queue.get(0).column_coordinate, end.row_coordinate, end.column_coordinate);
                }
            }
            
            if ( queue.get(0).row_coordinate + 1 < NUMBER_OF_ROWS && !object_points.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate]) ) //DOWN
            {
                if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate]) )
                {
                    visited_points_set.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate]);
                    queue.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate]);
                }
                
                if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].local_score )
                {
                    grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].parent_row = queue.get(0).row_coordinate;
                    grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].parent_column = queue.get(0).column_coordinate;
                    grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                    grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].global_score = grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate + 1, queue.get(0).column_coordinate, end.row_coordinate, end.column_coordinate);
                }
            }
            
            if ( queue.get(0).column_coordinate - 1 >= 0 && !object_points.contains(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1]) ) //LEFT
            {
                if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1]) )
                {
                    visited_points_set.add(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1]);
                    queue.add(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1]);
                }
                
                if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].local_score )
                {
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].parent_row = queue.get(0).row_coordinate;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].parent_column = queue.get(0).column_coordinate;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].global_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate - 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate, queue.get(0).column_coordinate - 1, end.row_coordinate, end.column_coordinate);
                }
            }
            
            if ( queue.get(0).column_coordinate + 1 < NUMBER_OF_COLUMNS && !object_points.contains(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1]) ) //RIGHT
            {
                if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1]) )
                {
                    visited_points_set.add(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1]);
                    queue.add(grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1]);
                }
                
                if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].local_score )
                {
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].parent_row = queue.get(0).row_coordinate;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].parent_column = queue.get(0).column_coordinate;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                    grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].global_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate + 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate, queue.get(0).column_coordinate + 1, end.row_coordinate, end.column_coordinate);
                }
            }
            
            //Átlós közlekedés
            
            if ( diagonal_is_allowed )
            {
                if ( queue.get(0).row_coordinate - 1 >= 0 && queue.get(0).column_coordinate - 1 >= 0 && !object_points.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1]) ) //TOP-LEFT
                {
                    if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1]) )
                    {
                        visited_points_set.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1]);
                        queue.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1]);
                    }

                    if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].local_score )
                    {
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].parent_row = queue.get(0).row_coordinate;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].parent_column = queue.get(0).column_coordinate;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].global_score = grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate - 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate - 1, queue.get(0).column_coordinate - 1, end.row_coordinate, end.column_coordinate);
                    }
                }

                if ( queue.get(0).row_coordinate - 1 >= 0 && queue.get(0).column_coordinate + 1 < NUMBER_OF_COLUMNS && !object_points.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1]) ) //TOP-RIGHT
                {
                    if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1]) )
                    {
                        visited_points_set.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1]);
                        queue.add(grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1]);
                    }

                    if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].local_score )
                    {
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].parent_row = queue.get(0).row_coordinate;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].parent_column = queue.get(0).column_coordinate;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                        grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].global_score = grid.points[queue.get(0).row_coordinate - 1][queue.get(0).column_coordinate + 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate - 1, queue.get(0).column_coordinate + 1, end.row_coordinate, end.column_coordinate);
                    }
                }

                if ( queue.get(0).row_coordinate + 1 < NUMBER_OF_ROWS && queue.get(0).column_coordinate - 1 >= 0 && !object_points.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1]) ) //BOTTOM-LEFT
                {
                    if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1]) )
                    {
                        visited_points_set.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1]);
                        queue.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1]);
                    }

                    if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].local_score )
                    {
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].parent_row = queue.get(0).row_coordinate;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].parent_column = queue.get(0).column_coordinate;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].global_score = grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate - 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate + 1, queue.get(0).column_coordinate - 1, end.row_coordinate, end.column_coordinate);
                    }
                }

                if ( queue.get(0).row_coordinate + 1 < NUMBER_OF_ROWS && queue.get(0).column_coordinate + 1 < NUMBER_OF_COLUMNS && !object_points.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1]) ) //BOTTOM-RIGHT
                {
                    if ( !visited_points_set.contains(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1]) )
                    {
                        visited_points_set.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1]);
                        queue.add(grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1]);
                    }

                    if ( grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0 < grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].local_score )
                    {
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].parent_row = queue.get(0).row_coordinate;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].parent_column = queue.get(0).column_coordinate;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].local_score = grid.points[queue.get(0).row_coordinate][queue.get(0).column_coordinate].local_score + 1.0;
                        grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].global_score = grid.points[queue.get(0).row_coordinate + 1][queue.get(0).column_coordinate + 1].local_score + euclideanDistanceBetweenTwoPoints(queue.get(0).row_coordinate + 1, queue.get(0).column_coordinate + 1, end.row_coordinate, end.column_coordinate);
                    }
                }
            }
            
            if ( !queue.isEmpty() )
            {
                queue.remove(0);
            }
            
            ///Heurisztika alkalmazása:
            
            if ( perform_with_heuristics )
            {
                for ( int i = 0; i < queue.size() - 1; i ++ )
                {
                    for ( int j = i + 1; j < queue.size(); j ++ )
                    {
                        if ( queue.get(i).global_score > queue.get(j).global_score )
                        {
                            Point P = queue.get(i);
                            queue.set(i, queue.get(j));
                            queue.set(j, P);
                        }
                    }
                }

                //Az adatok rendezése: Collections.sort(queue);

                if ( visited_points_set.contains(grid.points[end.row_coordinate][end.column_coordinate]) )
                {
                    break;
                }
            }
        }
        
        int actual_row = end.row_coordinate, actual_column = end.column_coordinate;
        int next_row = grid.points[actual_row][actual_column].parent_row, next_column = grid.points[actual_row][actual_column].parent_column;
        
        while ( actual_row != start.row_coordinate || actual_column != start.column_coordinate )
        {
            next_row = grid.points[actual_row][actual_column].parent_row;
            next_column = grid.points[actual_row][actual_column].parent_column;
            
            actual_row = next_row;
            actual_column = next_column;
            
            if ( actual_row != start.row_coordinate || actual_column != start.column_coordinate )
            {
                path_points.add(grid.points[actual_row][actual_column]);
            }
        }
        
        for ( int i = 0; i < NUMBER_OF_ROWS; i ++ )
        {
            for ( int j = 0; j < NUMBER_OF_COLUMNS; j ++ )
            {
                if ( object_points.contains(grid.points[i][j]) )
                {
                    grid.points[i][j].button.setBackground(OBJECT_TILE_COLOR);
                }else if ( path_points.contains(grid.points[i][j]) )
                {
                    grid.points[i][j].button.setBackground(PATH_TILE_COLOR);
                }
                else if ( start.row_coordinate == grid.points[i][j].row_coordinate && start.column_coordinate == grid.points[i][j].column_coordinate )
                {
                    grid.points[i][j].button.setBackground(START_TILE_COLOR);
                }else if ( end.row_coordinate == grid.points[i][j].row_coordinate && end.column_coordinate == grid.points[i][j].column_coordinate )
                {
                    grid.points[i][j].button.setBackground(END_TILE_COLOR);
                }else grid.points[i][j].button.setBackground(DEFAULT_TILE_COLOR);
            }
        }
        
        Pathfinder_A_star.path_points.clear();
        
        for ( int i = 0; i < NUMBER_OF_ROWS; i ++ )
        {
            for ( int j = 0; j < NUMBER_OF_COLUMNS; j ++ )
            {
                grid.points[i][j].local_score = Double.POSITIVE_INFINITY;
                grid.points[i][j].global_score = Double.POSITIVE_INFINITY;
                grid.points[i][j].parent_row = 0;
                grid.points[i][j].parent_column = 0;
            }
        }
    }
    
    static double euclideanDistanceBetweenTwoPoints(int x1, int y1, int x2, int y2) //Heurisztika
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    static void generateRandomObjects()
    {
        /* Random generált */
        
        Random random = new Random();
        
        for ( int i = 0; i < NUMBER_OF_ROWS; i ++ )
        {
            for ( int j = 0; j < NUMBER_OF_COLUMNS; j ++ )
            {
                if ( ( start.row_coordinate != i || start.column_coordinate != j ) && ( end.row_coordinate != i || end.column_coordinate != j ) && random.nextBoolean() && random.nextBoolean() ) //2-szer generálás, hogy kevesebb objektum legyen
                {
                    object_points.add(grid.points[i][j]);
                }
            }
        }
    }
}