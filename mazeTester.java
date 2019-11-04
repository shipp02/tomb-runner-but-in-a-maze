import java.util.*;
/**
 * Write a description of class mazeTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class mazeTester
{
    // instance variables - replace the example below with your own
    static String[] directions ={"R","L","U","D"};
     char a = 'A';
    static Maze maze1 = new Maze();
     
    public  static void navigatePit(String UChoice,String UChoiceLong){
          System.out.println("There is pit" + UChoiceLong + "Do you want me to navigate it?");
          
          Scanner input = new Scanner(System.in);
          
          String shouldINavigatePit = input.next();
          if(shouldINavigatePit.equals("Y")){
              maze1.jumpOverPit(UChoice);
        }
        else{
            System.out.println("You may not proceed then.");
        }
      }
    public  void giveDirection(){
            //this method takes user input informs the user of their choice and informs computer  what user has chosen
            Scanner input = new Scanner(System.in);
            
            String keys = input.next();
            //String keys = keys;
            String userChoice;
            
            String userChoiceLong;
            switch(keys) {
                case "A":
                    userChoiceLong = "left";
                    userChoice = "L";
                    if (maze1.canIMoveLeft()){
                        maze1.moveLeft();
                        
                        
                    }
                    else if(maze1.isThereAPit(userChoice)){
                        System.out.println("PIT AHEAD");
                        mazeTester.navigatePit(userChoice,userChoiceLong);
                        
                    }
                    else{
                        System.out.println("Move Not Possible Due To WALL");
                    }
                    break;
                case "D":
                    userChoiceLong = "right";
                    userChoice = "R";
                    
                    if (maze1.canIMoveRight()){
                        maze1.moveRight();
                        
                    }
                    else if(maze1.isThereAPit(userChoice)){
                        System.out.println("PIT AHEAD");
                        mazeTester.navigatePit(userChoice,userChoiceLong);
                        
                    }
                    else{
                        System.out.println("Move Not Possible Due To WALL");
                    }
                    break;
                case "W":
                    userChoiceLong = "above";
                    userChoice = "U";
                    if (maze1.canIMoveUp()){
                        maze1.moveUp();
                        
                    }
                    else if(maze1.isThereAPit(userChoice)){
                        System.out.println("PIT AHEAD");
                        mazeTester.navigatePit(userChoice,userChoiceLong);
                        
                    }
                    else{
                        System.out.println("Move Not Possible Due To WALL");
                    }
                    break;
                case "S":
                    userChoiceLong = "below";
                    userChoice = "D";
                    if (maze1.canIMoveDown()){
                        maze1.moveDown();
                        
                    }
                    else if(maze1.isThereAPit(userChoice)){
                        System.out.println("PIT AHEAD");
                        mazeTester.navigatePit(userChoice,userChoiceLong);
                        
                    }
                    else{
                        System.out.println("Move Not Possible Due To WALL");
                    }
                    break;
                default:
                    System.out.println("Invalid move Direction");
                    //maze1.giveDirection();
                    break;
            }
           
      }
      
      
     public static void main(String[] args){
          mazeTester m = new mazeTester();
          //maze1.fillSolution();
          //Maze maze1 = new Maze();
        while(!maze1.didIWin()){
              m.giveDirection();
              maze1.printMap();
         }
        
    }

    public static String giveDirection(String[] posDir){
            //this method takes user input informs the user of their choice and informs computer  what user has chosen
            Scanner input = new Scanner(System.in);
            boolean inputValid = false;
            
            String userChoice = input.next();
            
            for (int i = 0;i<4;i++){
                if(userChoice.equals(posDir[i]) || userChoice.equals(posDir[i].toLowerCase())){
                    inputValid = true;
                    System.out.println("Input valid");
                    
                }
                
            }
            if(!inputValid){
                 System.out.println("Input Invalid");
                 mazeTester.giveDirection(directions);
                
            }
            return userChoice;
            
        }
        
      
        
}
            
      
      
      