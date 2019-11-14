
/**
 * Write a description of class node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class node
{
    // instance variables - replace the example below with your own
    int row;
    int col;
    
    /**
     * Constructor for objects of class node
     */
    public node(int r,int c)
    {
        // initialise instance variables
        row = r;
        
        col = c;
        
    }

    
    public String toString(){
        
        
        return "row: " + row + "col: " + col;
        
    }
}
