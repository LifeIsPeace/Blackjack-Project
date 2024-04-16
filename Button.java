import greenfoot.*;
/**
 * A should be abstract class that is the blueprint to buttons
 * Concrete only for experimentation purposes
 * 
 * @author Brejon T 
 * @version 4.13.24
 */

public abstract class Button extends Actor
{
    // instance variables - replace the example below with your own
    private GreenfootImage message;
    private int x;
    private int y;
    private static final int DEFAULT_FONT_SIZE = 50;

    /**
     * Constructor for objects of class Button
     */
    public Button(String message, int x, int y)
    {
        this.message = new GreenfootImage(message, DEFAULT_FONT_SIZE, Color.WHITE, new Color(78,72,250));
        setImage(this.message);
        this.x = x;
        this.y = y;
        setLocation(x,y);
    }
    public Button(String message,int x, int y, int fontSize){
        this.message = new GreenfootImage(message, fontSize, Color.RED, Color.GREEN);
        setImage(this.message);
        this.x = x;
        this.y = y;
    }
    /**
     * This initalizes a button object that has a specific image to pair with it
     * @param picture   A GreenfootImage that serves as the image of the button
     * @param x   The x coordinate of the button
     * @param y   The y coordinate of the button
     */
    public Button(GreenfootImage picture, int x, int y){
        this.message = picture;
        setImage(this.message);
        this.x = x;
        this.y = y;
    }
    /**
     * Sets the location of the actor AND updates the x and y coordinate of the button object 
     */
    @Override
    public void setLocation(int x, int y){
        super.setLocation(x, y);
        this.x = x;
        this.y = y;
    }
    
    /**
     * This methods allows a Button object to have an x coordinate before being added to a world.
     */
    @Override
    public int getX(){
        return x;
    }
    
    /**
     * This methods allows a Button object to have an y coordinate before being added to a world.
     */
    @Override
    public int getY(){
        return y;
    }
    
    public void changeX(int x){
        this. x = x;
    }
    
    public void changeY(int y){
        this.y = y;
    }
    
    public abstract void act();
}
    

/*
 * Buttons will NEVER move or turn therefore only certain methods will need to be overriden
 * A method (such as turnTowards) will not need to be overriden to update the instance x and y values
 * as it will never need to use those methods
 */
