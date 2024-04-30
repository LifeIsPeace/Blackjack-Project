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
    public StartButton(int x, int y, int z){
        super("START", x, y, z);
    }
    
    public StartButton(int x, int y){
        super(new GreenfootImage("images//start3.png"), x, y);
    }
    
    public void act(){
        animate("start");
        if(Greenfoot.mouseClicked(this)){
            this.getWorld().stopped();
            Greenfoot.setWorld(new BlackJackRunner(500, 1, 4, 30, 25));
        }
    }
}
