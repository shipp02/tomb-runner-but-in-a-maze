import java.util.*;
/**
 * Write a description of class nodesForMaze here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class nodesForMaze
{
    
    int row,col,posDir;
    ArrayList<Integer> nodesInt = new ArrayList<>();
    
    static ArrayList<nodesForMaze> nodes = new ArrayList<>();
    public nodesForMaze(int r,int c,int[] dirValuesWalk,int[] dirValuesPit){
        row = r;
        col = c;
        //System.out.println(row+ " , " + col);
    }
    
    
    public void isItNode(int row,int col,int[] dirValues,int[] dirValuesPit,boolean pit){
        int sumWalk = -10;
        int sumPit = -30;
        
        if(nodesInt.contains(depthFirstSearch.grid[row][col])){
            
        }
        else{
            for(int i = 0;i<4;i++){
                sumWalk = sumWalk + dirValues[i];
                
                sumPit = sumPit + dirValuesPit[i];
            }
            if(sumWalk >=20 && !(pit)){
                
                posDir = sumWalk%10;
                
                nodesForMaze node = new nodesForMaze(row,col,dirValues,dirValuesPit);
                System.out.println("ItIsNode");
                nodes.add(node);
                nodesInt.add(depthFirstSearch.grid[row][col]);
            }
            else if(sumPit>=10 && pit){
                nodesForMaze node = new nodesForMaze(row,col,dirValues,dirValuesPit);
                System.out.println("ItIsNode");
                nodes.add(node);
            }
        }
    }
    
    
    int numMoves = 1;
    public boolean isMovePossible(int row,int col,int[] dirValues,int[] dirValuesPit){
        int sumWalk = -10;
        int sumPit = -30;
        for(int i = 0;i<4;i++){
            sumWalk = sumWalk + dirValues[i];
            
            sumPit = sumPit + dirValuesPit[i];
        }
        
        if(numMoves == 1){
            numMoves++;
            return false;
        }
        else if(sumWalk == 0){
            System.out.println("Move is not possible");
            return true;
        }
        
        else{
            System.out.println("Move is possible");
            numMoves++;
            return false;
        }
        
    }
    nodesForMaze lastNode;
    int nodesJumped  = 1;
    public nodesForMaze lastNode(){
        lastNode = nodes.get(nodes.size() - 1);
        nodes.remove(lastNode);
        return lastNode;
    }
    
    public int[] toLoc(){
        int[] loc = {this.row,this.col};
        return loc;
    }
    
    public String toString(){
        return "row: " + this.row + " col: " + this.col;
    }
    
    public boolean move(){
        posDir--;
        if(posDir == 0){
            return false;
        }
        else if(posDir>0){
            return true;
        }
        else{
            return false;
        }
    }
}
