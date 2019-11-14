
/**
 * Write a description of class nodeTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class nodeTester
{
    public static void main(String[] args){
        int[] v1= {10,10,10,10};
        int[] vPit = {0,0,0,0};
        int[] vPit2 = {20,20,20,20};
        nodesForMaze n1 = new nodesForMaze(1,1,v1,vPit);
        // System.out.println(n1.row);
        n1.isItNode(1,1,v1,vPit);
        
        n1.isItNode(2,2,v1,vPit2);
        v1[0] = 0;
        v1[1] = 0;

        
        n1.isItNode(3,3,v1,vPit2);
        
        n1.isItNode(4,4,v1,vPit);
        System.out.println(nodesForMaze.nodes);
    }
}
