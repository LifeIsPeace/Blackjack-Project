import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    private static GreenfootImage title;
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 710, 1);
        StartButton startButton = new StartButton(630, 500);
        TutorialButton tutorialButton = new TutorialButton(630, 600);
        title = new GreenfootImage("images//title.png");
        getBackground().drawImage(title, 85, -75);
        addObject(startButton, startButton.getX(), startButton.getY());
        addObject(tutorialButton, tutorialButton.getX(), tutorialButton.getY());

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
/*
 * Or, just instantiate the world class which you want to be the first world interactively,
 * by right-clicking the class and calling the constructor. No need to go editing text files :)
 * Just initiate the title screen as the starting world.
 */
