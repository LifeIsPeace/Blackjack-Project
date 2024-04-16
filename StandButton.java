import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StandButton here.
 * 
 * @author Brejon T
 * @version 4.16.24
 */
public class StandButton extends Button
{
    static final int DEFAULT_X = 99;
    static final int DEFAULT_Y = 547;
    
    public StandButton(int x, int y, int z){
        super("STAND", x, y, z);
    }
    
    public StandButton(int x, int y){
        super("STAND", x, y);
    }
    
    public StandButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
