import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextInput extends Actor {
    private String text;
    private GreenfootImage textImg;
    private int x;
    private int y;
    private BlackJackRunner bjr;
    private static final int DEFAULT_FONT_SIZE = 50;
    private static final Color backgroundColor = new Color(78, 72, 250);
    private static final Color textColor = Color.WHITE;
    private static String textTyper = "_";
    private static int timer = 0;

    public TextInput(String text, int x, int y, BlackJackRunner bjr)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.bjr = bjr;
        setLocation(x,y);
    }
    
    private void updateImage() {
        textImg = new GreenfootImage(text + textTyper, DEFAULT_FONT_SIZE, textColor, backgroundColor);
        setImage(textImg);
    }

    public void act() {
        updateImage();
        String key = Greenfoot.getKey();
        if (key != null && bjr.isBetting() && bjr.getTimer() == -1) {
            if (key.equals("backspace") && text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            } else if ((key.equals("1") || key.equals("2") || key.equals("3") || key.equals("4") || key.equals("5") || key.equals("6") || key.equals("7") || key.equals("8") || 
                key.equals("9") || key.equals("0")) && text.length() < 10) {
                text += key;
            }
            
            if (key.equals("enter") && getTextInput() <= bjr.getStartingMoney()) {
                bjr.setStartingMoney(bjr.getStartingMoney() - getTextInput());
                bjr.setBetAmount(getTextInput());
                text = "";
                bjr.setBetting(false);
            }
        }
        timer++;
        
        if (timer > 20 && bjr.isBetting() && bjr.getTimer() == -1) {
            if (textTyper == "_") {
                textTyper = " ";
            }
            else{
                textTyper = "_";
            }
            timer = 0;
        }
        else if (!bjr.isBetting()) {
            textTyper = "";
        }
    }
    
    public int getTextInput() {
        return Integer.parseInt(text);
    }
}
