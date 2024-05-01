import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrokeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrokeButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;

    public BrokeButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public BrokeButton(int x, int y){
        super(new GreenfootImage("images//broke1.png"), x, y);
    }
    public void act()
    {animate("broke");
    }
}
