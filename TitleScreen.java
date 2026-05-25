import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel1 = new Label("Block", 100);
    Label titleLabel2 = new Label("Fall", 100);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 720, 1); 
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Add title
        addObject(titleLabel1, 280, 250);
        addObject(titleLabel2, 280, 350);
        
        titleLabel1.setLineColor(Color.WHITE);
        
        titleLabel2.setFillColor(new Color(170, 51, 106));
        titleLabel2.setLineColor(new Color(170, 51, 106)); 
        
        // Add play button
        Button playButton = new Button(new MyWorld(), "Play");
        addObject(playButton, 280, 550);
    
    }
}
