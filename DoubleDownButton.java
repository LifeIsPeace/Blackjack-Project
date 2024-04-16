import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoubleDownButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleDownButton extends Button
{
    static final int DEFAULT_X = 188;
    static final int DEFAULT_Y = 675;
    
    public DoubleDownButton(int x, int y, int z){
        super("DOUBLE DOWN", x, y, z);
    }
    
    public DoubleDownButton(int x, int y){
        super("DOUBLE DOWN", x, y);
    }
    
    public DoubleDownButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
