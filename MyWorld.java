import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // 1920 by 1080 is too big
        super(1320, 710, 1); 
        Button test = new Button("Hello", 960, 540);
        addObject(test, test.getX(), test.getY());
    }
}
