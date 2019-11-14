import java.util.*;
/**
 * Write a description of class depthFirstSeach here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class depthFirstSearch
{
    // instance variables - replace the example below with your own
    
    static int[] v1= {10,10,10,10};
    static int[] vPit = {0,0,0,0};
    static nodesForMaze node = new nodesForMaze(0,0,v1,vPit);
    
    private int x;
    static Maze myMaze = new Maze();
    //private int[][] discovered = new int[20][20];
    static private int[][] goUp = new int[20][20];
    static private int[][] goDown = new int[20][20];
    static private int[][] goRight = new int[20][20];
    static private int[][] goLeft = new int[20][20];
    private ArrayList<Integer> discovered = new ArrayList<>();
    char[] directions = {'R','L','U','D'};
    int numOfMoves = 0;
    // 10 is you can move
    //20 is there is a pit
    //11 is that direction has already been moved in
    //21 is that the pit has already been jumped over
    static int[][] grid = new int[20][20];
   
    
    /*This method is called once at the start of the program to assign numbers in increasing order to all points
     * to various locations on the node it avoids a lot of problems later in the program
     * I thelps inrfrencing which locations have been visited and which have not been visited
    */
   public void label(){
        
        for(int i = 0;i<20;i++){
            for(int j = 0;j<20;j++){
                
                grid[i][j] = x;
                x++;
                
            }
            
        }
   }
    
    
   
   /*When a location is passed to this method
    * it adds the appropriate location refrence number to the discovered arreaylist
    */
   public void setDiscovered(int[] loc){
       discovered.add(grid[loc[0]][loc[1]]); 
   }
    
    
    /*This method checks if we can move in a direction 
     * it has  four 2d arrays one for each directon of movement
     * if we can move in the direction it sets the correspondin 2d array to value 10
     * if ther is pit the direction value is set to 20
     */
    public void dicoverer(int[] location)
    {
        depthFirstSearch search  = new depthFirstSearch();
        boolean pit = false;
        

        
        if(myMaze.canIMoveRight()){
            goRight[location[0]][location[1]] = 10;
        }
        else if(myMaze.isThereAPit("R")){
            goRight[location[0]][location[1]] = 20;
            pit = true;
        }
        
        
        if(myMaze.canIMoveLeft()){
            goLeft[location[0]][location[1]] = 10;
        }
        else if(myMaze.isThereAPit("L")){
            goLeft[location[0]][location[1]] = 20;
            pit = true;
        }
        
        if(myMaze.canIMoveDown()){
            goDown[location[0]][location[1]] = 10;
        
        }
        else if(myMaze.isThereAPit("D")){
            goDown[location[0]][location[1]] = 20;
            pit = true;
        }
        
        if(myMaze.canIMoveUp()){
            goUp[location[0]][location[1]] = 10;
        }
        else if(myMaze.isThereAPit("U")){
            goUp[location[0]][location[1]] = 20;
            pit = true;
        }
        int[] dirValues = {goRight[location[0]][location[1]],goLeft[location[0]][location[1]],goDown[location[0]][location[1]],
            goUp[location[0]][location[1]]};
        int[] dirValueJump = {goRight[location[0]][location[1]],goLeft[location[0]][location[1]],goDown[location[0]][location[1]],
            goUp[location[0]][location[1]]};
        
        node.isItNode(location[0],location[1],dirValues,dirValueJump,pit);
    }
    
    
    public boolean move(int[] location){
        depthFirstSearch search  = new depthFirstSearch();
        //int[] temp = {goRight[location[0]][location[1]],goRight[location[0]][location[1]],goUp[location[0]][location[1]],goDown[location[0]][location[1]]};
        int[] dirValues = {goRight[location[0]][location[1]],goLeft[location[0]][location[1]],goDown[location[0]][location[1]],
            goUp[location[0]][location[1]]};
        int[] dirValueJump = {goRight[location[0]][location[1]],goLeft[location[0]][location[1]],goDown[location[0]][location[1]],
            goUp[location[0]][location[1]]};
            
        int nodeJumps = 1;
        //This block of if satements is pesponsible for moving in the direction that is available to move at the time
        //This bloch is only for making the first move.It is an exception to the normal form that if sumValues is 
        
        
        if(!(node.isMovePossible(location[0],location[1],dirValues,dirValueJump))){
            if(goRight[location[0]][location[1]] == 10 &&  !(discovered.contains(grid[location[0]][location[1]]+1))){
                goRight[location[0]][location[1]] = 11;
                System.out.println("moving R");
                myMaze.moveRight();
                return true;
            }
            else if(goLeft[location[0]][location[1]] == 10  && !(discovered.contains(grid[location[0]][location[1]]-1))){
                goLeft[location[0]][location[1]] = 11;
                System.out.println("moving L");
                myMaze.moveLeft();
                return true;
            }
            else if(goUp[location[0]][location[1]] == 10 && !(discovered.contains(grid[location[0]][location[1]]-20))){
                goUp[location[0]][location[1]] = 11;
                System.out.println("moving U");
                myMaze.moveUp();
                return true;
            }
            else if(goDown[location[0]][location[1]] == 10 && !(discovered.contains(grid[location[0]][location[1]]+20))){
                goDown[location[0]][location[1]] = 11;
                System.out.println("moving D");
                myMaze.moveDown();
                return true;
            }
            numOfMoves++;
            return false;
        }
        else{
            return false;
            
        }
    }
    
    //*This method jumps over pits 
    public static boolean pitNavigation(int[] location){
        System.out.print("Right: " + goRight[location[0]][location[1]]);
        System.out.print("Left : " + goLeft[location[0]][location[1]]);
        System.out.print("Up: " + goUp[location[0]][location[1]]);
        System.out.println("Down: " + goDown[location[0]][location[1]]);
        if(goRight[location[0]][location[1]] == 20){
            goRight[location[0]][location[1]] = 21;
            System.out.println("jumping R");
            myMaze.jumpOverPit("R");
            return true;
        }
        else if(goRight[location[0]][location[1]] == 20){
            goLeft[location[0]][location[1]] = 21;
            System.out.println("jumping L");
            myMaze.jumpOverPit("L");
            return true;
        }
        else if(goUp[location[0]][location[1]] == 20){
            goUp[location[0]][location[1]] = 21;
            System.out.println("jumping U");
            myMaze.jumpOverPit("U");
            return true;
        }
        else if(goDown[location[0]][location[1]] == 20){
            goDown[location[0]][location[1]] = 21;
            System.out.println("jumping D");
            myMaze.jumpOverPit("D");
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void jumpToPrevNode(){
        int jumpAmount = 1;
        nodesForMaze lastNode = node.lastNode();
        
        System.out.println("jumpingToPrevNode");
        if(!(lastNode.move())){
            int row = lastNode.row;
            int col = lastNode.col;
            System.out.println("Last Node at"+row + "," + col);
            myMaze.jump(row,col);
            //nodeJumps++;
            
        }
            
    }
    
    public static void main(String[] args){
        depthFirstSearch search  = new depthFirstSearch();
        search.label();
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<50;i++){
            
                
            int[] loc = myMaze.getCurrentLoc();
            
            search.setDiscovered(loc);
            search.dicoverer(loc);
            
            boolean didIMove = search.move(loc);
            boolean didIJump = search.pitNavigation(loc);
            System.out.println(didIMove + ", "+didIJump);
            if(!(didIMove || didIJump)){
                search.jumpToPrevNode();
            }
            
            System.out.println(nodesForMaze.nodes);
            myMaze.printMap();
            
        
            
        }
        
    }
}
