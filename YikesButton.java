import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YikesButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YikesButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;

    public YikesButton(int x, int y){
        super(new GreenfootImage("images//yikes1.png"), x, y);
    }public YikesButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    public void act()
    {animate("yikes");
    }
}
