import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private World nextWorld;
    private String text;
    
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(World nextWorld, String text)
    {
        this.nextWorld = nextWorld;
        this.text = text;
        
        // Create the button image
        GreenfootImage buttonImage = new GreenfootImage("images/Button.png");
        buttonImage.scale(200,70);
        
        // Create the text image
        GreenfootImage textImage = new GreenfootImage(text, 40, Color.WHITE, new Color(0,0,0,0));
        
        // Center the text image onto the button image
        int textX = ((buttonImage.getWidth() - textImage.getWidth()) / 2) + 5;
        int textY = ((buttonImage.getHeight() - textImage.getHeight()) / 2 - 2);
        
        // Draw the text image right onto the button image
        buttonImage.drawImage(textImage, textX, textY);
        
        // Set the new button image with text
        setImage(buttonImage);
        
    }
    
    
    public void act()
    {
        // Add your action code here.
        checkForClick();
    }
    
    public void checkForClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(nextWorld);
        }
    }
}
