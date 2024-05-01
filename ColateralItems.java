import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColateralItems here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class ColateralItems extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 550;
    private boolean active;
    private int value;
    private BlackJackRunner bjr;
    
    public ColateralItems(int x, int y, String image, BlackJackRunner bjr, int value){
        super(new GreenfootImage("images//"+ image +".png"), x, y);
        this.getImage().scale(128, 128);
        this.bjr = bjr;
        this.value = value;
        this.active = true;
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this) && active){
           active = false;
           bjr.setStartingMoney(value);
           Greenfoot.setWorld(bjr);
        }
        else if (!active) {
            this.getWorld().removeObject(this);
        }
    }
    
    public boolean isActive() {
        return active;
    }
}
