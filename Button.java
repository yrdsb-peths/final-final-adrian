import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    // Stores a string that is used to determine what world does this button lead to
    private String nextWorld;
    // Stores a string which is the text displayed on the button
    private String text;
    
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Constructor, takes two strings, one is the next world, and the other is the text displayed on the button
    public Button(String nextWorld, String text)
    {
        // Sets instance variables
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
        // Constantly checks if the button if clicked
        checkForClick();
    }
    
    // Checks if the user clicks the button
    public void checkForClick()
    {
        // Goes to the corresponding world
         if(Greenfoot.mouseClicked(this))
        {
            if(nextWorld.equals("title"))
            {
                Greenfoot.setWorld(new TitleScreen());
            }
            else if(nextWorld.equals("tutorial"))
            {
                Greenfoot.setWorld(new TutorialScreen());
            }
            else if(nextWorld.equals("game"))
            {
                Greenfoot.setWorld(new MyWorld());
            }
        }
    }
}
