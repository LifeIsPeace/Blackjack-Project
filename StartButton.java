import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author Brejon T
 * @version 4.14.24
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StartButton(String message, int x, int y){
        super(message, x, y);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld( new BlackJackRunner());
        }
    }
}
