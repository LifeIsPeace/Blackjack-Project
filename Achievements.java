import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Achievements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    /**
     * Constructor for objects of class Achievements.
     * 
     */
    public static GreenfootImage AchievementsMenu;
    public Achievements(BlackJackRunner bjr)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 710, 1);
        GreenfootImage AchievementsMenu = new GreenfootImage("images//background_images//BG.png");
        AchievementsMenu.scale(1260, 710);
        this.setBackground(AchievementsMenu);
        
        BackButton backButton = new BackButton(bjr);
        addObject(backButton,120,80);
        
        BrokeButton brokeButton = new BrokeButton();
        addObject(brokeButton,150,220);
        
        DrinkingageButton drinkingageButton = new DrinkingageButton();
        addObject(drinkingageButton,320,220);
        
        DrumsButton drumsButton = new DrumsButton();
        addObject(drumsButton,490,220);
        
        ThousandButton thousandButton = new ThousandButton();
        addObject(thousandButton,710,220);
        
        TwinsButton twinsButton = new TwinsButton();
        addObject(twinsButton,920,220);
        
        YikesButton yikesButton = new YikesButton();
        addObject(yikesButton,1130,220);
    
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
    
}
