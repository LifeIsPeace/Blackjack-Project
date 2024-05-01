import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThousandButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThousandButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;

    public ThousandButton(int x, int y){
        super(new GreenfootImage("images//thousand1.png"), x, y);
    }public ThousandButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    public void animate(String btnType){
        
    }
    public void act()
    {
    }
}
