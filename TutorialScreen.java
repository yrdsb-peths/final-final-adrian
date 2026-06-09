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
    
    // Timer that controls how many frames before a block spawns
    private int blockSpawnTimer = 0;
    
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
    
    public void act()
    {
        if(pageNum == 2)
        {
            // Spawns tutorial red blocks randomly
            int posX = Greenfoot.getRandomNumber((getWidth() - 300 ) + 150);
            int posY = 30;
            
            blockSpawnTimer ++;
            if(blockSpawnTimer % 70 == 0)
            {
                addObject(new TutorialRedBlock("Red", 5), posX, posY);
            }
        }
        else if(pageNum == 3)
        {
            // Spawns point blocks randomly on page 4 of the tutorial world
            int posX = Greenfoot.getRandomNumber((getWidth() - 300 ) + 150);
            int posY = 30;
            
            blockSpawnTimer ++;
            if(blockSpawnTimer % 70 == 0)
            {
                addObject(new PointBlock("Point", 5), posX, posY);
            }
        }
    }
    
    // Loads a new page
    public void loadPage()
    {
        // Remove all old objects in the world first
        removeObjects(getObjects(null));
        
        // Displays corresponding information depending on what page the user is on
        if(pageNum == 0)
        {
            // This page is an intro
            // Add this is the tutorial label and press next to start label
            Label tutorialLabelOne = new Label("This is the tutorial", 60);
            addObject(tutorialLabelOne, 280, 50);
            tutorialLabelOne.setLineColor(Color.WHITE);
            
            Label tutorialLabelTwo = new Label("press next to start", 60);
            addObject(tutorialLabelTwo, 280, 150);
            tutorialLabelTwo.setLineColor(Color.WHITE);
            
            // Adds next page button 
            addObject(new NextPageButton(this, false), 450, 650);
            
            // Add back button that goes back to the title screen world
            Button backButton = new Button("title", "Back");
            addObject(backButton, 100, 650);
        }
        else if(pageNum == 1)
        {
            // This page shows the user how the movement in this game works
            // Add player movement label
            Label playerMovement = new Label("Player movement", 80);
            addObject(playerMovement, 280, 50);
            playerMovement.setLineColor(Color.WHITE);
            
            // Add press space label
            Label space = new Label("Press space to change direction", 40);
            addObject(space, 280, 550);
            space.setLineColor(Color.WHITE);
            
            // Adds next page button 
            addObject(new NextPageButton(this, false), 450, 650);
            // Adds back page button
            addObject(new NextPageButton(this, true), 100, 650);
            
            // Add player instance as an example
            Player ball = new Player(140, 280, 300, 0.055);
            addObject(ball, 280, 390); 
        }
        else if(pageNum == 2)
        {
            // This page shows the user what block they should dodge
            // Dodge red blocks label
            Label dodge = new Label("Dodge red blocks", 80);
            addObject(dodge, 280, 50);
            dodge.setLineColor(Color.WHITE);
            
            // Adds next page button 
            addObject(new NextPageButton(this, false), 450, 650);
            
            // Adds back page button
            addObject(new NextPageButton(this, true), 100, 650);
            
            // Add player instance as an example
            Player ball = new Player(140, 280, 300, 0.055);
            addObject(ball, 280, 390);
            
        }
        else if(pageNum == 3)
        {
            // This page shows the user what block they should get
            // Get point blocks label
            Label pointOne = new Label("Get these blocks", 80);
            Label pointTwo = new Label("for points", 80);
            addObject(pointOne, 280, 50);
            addObject(pointTwo, 280, 100);
            pointOne.setLineColor(Color.WHITE);
            pointTwo.setLineColor(Color.WHITE);
            
            // Adds next page button 
            addObject(new NextPageButton(this, false), 450, 650);
            
            // Adds back page button
            addObject(new NextPageButton(this, true), 100, 650);
            
            // Add player instance as an example
            Player ball = new Player(140, 280, 300, 0.055);
            addObject(ball, 280, 390);            
        }
        else if(pageNum == 4)
        {
            // This page explains the streak system
            
            // Streak explanation labels
            Label streakExplainationOne = new Label("Higher streak", 80);
            Label equalSign = new Label("=", 80);
            Label streakExplainationTwo = new Label("More points!", 80);
            
            Label streakExplainationThree = new Label("* Streak increases every time", 30); 
            Label streakExplainationFour = new Label("you get a point block", 30);
            Label streakExplainationFive = new Label("* Streak resets if you miss", 30);
            Label streakExplainationSix = new Label("a point block", 30);
            
            addObject(streakExplainationOne, 280, 50);
            addObject(equalSign, 280, 100);
            addObject(streakExplainationTwo, 280, 150);
            addObject(streakExplainationThree, 200, 350);
            addObject(streakExplainationFour, 200, 400);
            addObject(streakExplainationFive, 200, 500);
            addObject(streakExplainationSix, 200, 550);
            
            streakExplainationOne.setLineColor(Color.WHITE);
            equalSign.setLineColor(Color.WHITE);
            streakExplainationTwo.setLineColor(Color.WHITE);
            streakExplainationThree.setLineColor(Color.WHITE);
            streakExplainationFour.setLineColor(Color.WHITE);
            streakExplainationFive.setLineColor(Color.WHITE);
            streakExplainationSix.setLineColor(Color.WHITE);
            
            // Adds back page button
            addObject(new NextPageButton(this, true), 100, 650);
            
            
        }
    }
    
    // These methods updates the pageNum variable accordingly and uses the load page method
    // These methods are called in the NextPageButton class and is used when that object is clicked
    public void nextPage()
    {
        // Update the page number
        pageNum++;
        // Load the current page
        loadPage();
    }
    
    public void prevPage()
    {
        // Update the page number
        pageNum--;
        // Load the current page
        loadPage();
    }
}
