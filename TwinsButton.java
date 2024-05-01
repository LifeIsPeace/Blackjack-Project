import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TwinsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwinsButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;

    public TwinsButton(int x, int y){
        super(new GreenfootImage("images//twins1.png"), x, y);
    }public TwinsButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    public void act()
    {animate("twins");
    }
}
