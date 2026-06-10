import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/* This class is a button specifically for the tutorial world. Instead of the other button class that leads to another world.
   This button just updates a pageNum variable in the TutorialScreen class. */
public class NextPageButton extends Actor
{
    // Stores a instance of tutorial screen
    private TutorialScreen tutorialScreen;
    // Stores whether or not this button leads to the next page or the previous page
    private boolean isBackButton;
    
    // Constructor that takes in a instance of tutorialScreen and a boolean
    public NextPageButton(TutorialScreen tutorialScreen, boolean isBackButton)
    {
        // Sets up instance variables
        this.tutorialScreen = tutorialScreen;
        this.isBackButton = isBackButton;
        
        // Create the button image
        GreenfootImage buttonImage = new GreenfootImage("images/Button.png");
        buttonImage.scale(200,70);
        
        // Create the text image depending on if its a back or next button
        GreenfootImage textImage;
        if(isBackButton)
        {
            textImage = new GreenfootImage("Back", 40, Color.WHITE, new Color(0,0,0,0));
        }
        else
        {
            textImage = new GreenfootImage("Next", 40, Color.WHITE, new Color(0,0,0,0));
        }
        
        // Center the text image onto the button image
        int textX = ((buttonImage.getWidth() - textImage.getWidth()) / 2) + 5;
        int textY = ((buttonImage.getHeight() - textImage.getHeight()) / 2 - 2);
        
        // Draw the text image right onto the button image
        buttonImage.drawImage(textImage, textX, textY);
        
        // Set the new button image with text
        setImage(buttonImage);
    }
    
    // Constantly checks if this object is clicked
    public void act()
    {
        // Depending on if this object is a backButton or not, pageNum variable in TutorialScreen class increases or decreases
        
        if(Greenfoot.mouseClicked(this))
        {
            if(isBackButton)
            {
                tutorialScreen.prevPage();
            }
            else
            {
                tutorialScreen.nextPage();
            }
        }
    }
}
