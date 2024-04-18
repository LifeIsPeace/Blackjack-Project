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
    private boolean hasButtonBeenHit;
    
    public StandButton(int x, int y, int z){
        super("STAND", x, y, z);
        hasButtonBeenHit = false;
    }
    
    public StandButton(int x, int y){
        super("STAND", x, y);
        hasButtonBeenHit = false;
    }
    
    public StandButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            hasButtonBeenHit = true;
        }
    }
}
