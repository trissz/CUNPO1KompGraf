package pathfinder_a_star;

public class Grid
{
    public int number_of_rows, number_of_columns;
    public Point points[][];
    
    Grid(int number_of_rows, int number_of_columns)
    {
        this.number_of_rows = number_of_rows;
        this.number_of_columns = number_of_columns;
        this.points = new Point[this.number_of_rows][this.number_of_columns];
        
        for ( int i = 0; i < this.number_of_rows; i ++ )
        {
            for ( int j = 0; j < this.number_of_columns; j ++ )
            {
                this.points[i][j] = new Point(i,j);
            }
        }
    }
}
