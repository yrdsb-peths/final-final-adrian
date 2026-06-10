import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// This class is a subclass of world. It is the title screen of the game
public class TitleScreen extends World
{
    
    // Constructor
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 720, 1); 
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // These labels display the title of the screen
        Label titleLabel1 = new Label("Block", 100);
        Label titleLabel2 = new Label("Fall", 100);
        
        // Add the title of the game
        addObject(titleLabel1, 280, 250);
        addObject(titleLabel2, 280, 350);
        
        // Set colors for labels
        titleLabel1.setLineColor(Color.WHITE);
        titleLabel2.setFillColor(new Color(170, 51, 106));
        titleLabel2.setLineColor(new Color(170, 51, 106)); 
        
        // Add play button which leads to the main game
        Button playButton = new Button("game", "Play");
        addObject(playButton, 280, 520);
        
        // Add tutorial button which leads to the tutorial
        Button tutorialButton = new Button("tutorial", "Tutorial");
        addObject(tutorialButton, 280, 600);
        
    }
    
}
