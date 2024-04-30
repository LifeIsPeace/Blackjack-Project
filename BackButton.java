import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    private BlackJackRunner bjr;
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;
    public BackButton(BlackJackRunner bjr){
        this(DEFAULT_X, DEFAULT_Y);
        this.bjr = bjr;
    }

    public BackButton(int x, int y, int z){
        super("BACK", x, y, z);
    }

    public BackButton(int x, int y){
        super(new GreenfootImage("images//back1.png"), x, y);
    }

    public void act(){
        animate("back");
        if(Greenfoot.mouseClicked(this)){
            this.getWorld().stopped();
            Greenfoot.setWorld(bjr);
        }
    }
}
