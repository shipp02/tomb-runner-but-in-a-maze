import java.util.*;
/**
 * Write a description of class arrrayNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class arrrayNode
{
    // instance variables - replace the example below with your own
    private int x;
    ArrayList<node> Nodes = new ArrayList<>();
    static int j = 10;
    
    public static void main(String[] args){
        ArrayList<node> Nodes = new ArrayList<>();
        int[] loc = new int[2];
        for(int i = 0;i<4;i++){
            //System.out.println(j);
            loc[0]=j;
            loc[1] = j;
            node newNode = new node(j,j);
            Nodes.add(newNode);
            //System.out.println(Nodes);
            j = j+10;
        }
        System.out.println(Nodes);
            // for(int i = 0;i<4;i++){
                // System.out.println(Nodes.get(i));
                
            // }
    }
}
