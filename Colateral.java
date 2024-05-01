import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Colateral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colateral extends World
{
    /**
     * Constructor for objects of class Colateral.
     * 
     */
    public ColateralItems backpack;
    public ColateralItems watch;
    public ColateralItems phone;
    public ColateralItems shoes;
    public Colateral(BlackJackRunner bjr)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 710, 1);
        GreenfootImage bg = new GreenfootImage("images//background_images//BG.png");
        bg.scale(1260, 710);
        this.setBackground(bg);
        
        backpack = new ColateralItems(530, 400, "bag", bjr, 50);
        watch = new ColateralItems(730, 400, "watch", bjr, 100);
        phone = new ColateralItems(530, 600, "phone", bjr, 300);
        shoes = new ColateralItems(730, 600, "shoe", bjr, 250);
        
        addObject(backpack, backpack.getX(), backpack.getY());
        addObject(watch, watch.getX(), watch.getY());
        addObject(phone, phone.getX(), phone.getY());
        addObject(shoes, shoes.getX(), shoes.getY());
        
    }

    /**
     * This method @Overrides the addObject method in the World class
     * This method will call the setLocation method from the Actor object (Necessary for the Button class)
     * @param object  An Actor object
     * @param x  An integer that represents the Actor's x coordinate
     * @param y  An integer that represents the Actor's y coordinate
     */
    @Override
    public void addObject(Actor object, int x, int y){
        super.addObject(object, x, y);
        object.setLocation(x, y);
    }
    
    public void act(){
        if (!backpack.isActive() && !watch.isActive() && !phone.isActive() && !shoes.isActive()) {
            this.showText("GAME OVER", 630, 630);
        }
    }
    
}
