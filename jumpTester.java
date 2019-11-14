
/**
 * Write a description of class jumpTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class jumpTester
{
    // instance variables - replace the example below with your own
    static Maze m = new Maze();
    public static void main(String[] args){
        m.printMap();
        m.jump(19,19);
        m.printMap();
    }
}
