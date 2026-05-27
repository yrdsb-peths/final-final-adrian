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
        
        loadPage();
        
    }
    
    
    public void loadPage()
    {
        // Remove all old objects in the world
        removeObjects(getObjects(null));
        
        // Adds next page button
        addObject(new NextPageButton(this), 400, 650);
        
        if(pageNum == 0)
        {
            // Add how to play label
            Label tutorialLabelOne = new Label("This is the tutorial", 80);
            addObject(tutorialLabelOne, 280, 50);
            tutorialLabelOne.setLineColor(Color.WHITE);
            
            Label tutorialLabelTwo = new Label("press next to start", 80);
            addObject(tutorialLabelTwo, 280, 150);
            tutorialLabelTwo.setLineColor(Color.WHITE);
        }
        else if(pageNum == 1)
        {
            // Add player movement label
            Label playerMovement = new Label("Player movement", 80);
            addObject(playerMovement, 280, 50);
            playerMovement.setLineColor(Color.WHITE);
            
            // Add press space label
            Label space = new Label("Press space to change direction", 40);
            addObject(space, 280, 550);
            space.setLineColor(Color.WHITE);
            
            // Add player instance as an example
            Player ball = new Player(140, 280, 300, 0.055);
            addObject(ball, 280, 390); 
        }
    }
    
    public void nextPage()
    {
        // Update the page number
        pageNum++;
        // Load the current page
        loadPage();
    }
}
