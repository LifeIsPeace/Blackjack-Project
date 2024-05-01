import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrumsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrumsButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;
    
    public DrumsButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public DrumsButton(int x, int y){
        super(new GreenfootImage("images//drums1.png"), x, y);
    }
    public void act()
    {animate("drums");
    }
}
