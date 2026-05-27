import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialScreen extends World
{
    private int pageNum = 0;
    /**
     * Constructor for objects of class TutorialScreen.
     * 
     */
    public TutorialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 720, 1); 
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Add how to play label
        Label tutorialLabel = new Label("How to play", 100);
        addObject(tutorialLabel, 280, 50);
        
        tutorialLabel.setLineColor(Color.WHITE);
    }
    
    public void loadPage()
    {
        // Remove all old objects in the world
        removeObjects(getObjects(null));
        
        if(pageNum == 0)
        {
            
        }
    }
}
