import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrinkingageButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrinkingageButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;

    public DrinkingageButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public DrinkingageButton(int x, int y){
        super(new GreenfootImage("images//drinkingage1.png"), x, y);
    }
    public void animate(String btnType){
        
    }
    public void act()
    {
    }
}
