import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitButton here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class HitButton extends Button
{
    static final int DEFAULT_X = 64;
    static final int DEFAULT_Y = 610;
    
    public HitButton(int x, int y, int z){
        super("HIT", x, y, z);
    }
    
    public HitButton(int x, int y){
        super("HIT", x, y);
    }
    
    public HitButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this)){
            
        }
    }
}
