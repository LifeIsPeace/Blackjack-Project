import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TutorialButton(int x, int y, int z){
        super("TUTORIAL", x, y, z);
    }

    public TutorialButton(int x, int y){
        super(new GreenfootImage("images//tutorial3.png"), x, y);
    }

    public void act(){
        animate("tutorial");
        if(Greenfoot.mouseClicked(this)){
            this.getWorld().stopped();
            Greenfoot.setWorld(new TutorialScreen());
        }
    }
}
