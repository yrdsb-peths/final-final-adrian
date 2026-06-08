import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextPageButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextPageButton extends Actor
{
    private TutorialScreen tutorialScreen;
    private boolean isBackButton;
    
    public NextPageButton(TutorialScreen tutorialScreen, boolean isBackButton)
    {
        this.tutorialScreen = tutorialScreen;
        this.isBackButton = isBackButton;
        
        // Create the button image
        GreenfootImage buttonImage = new GreenfootImage("images/Button.png");
        buttonImage.scale(200,70);
        
        // Create the text image
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
    
    /**
     * Act - do whatever the NextPageButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
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
