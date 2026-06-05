import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 720, 1); 
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Add game over label
        Label gameOver = new Label("Game Over", 80);
        addObject(gameOver, 280, 150);
        gameOver.setFillColor(new Color(170, 51, 106));
        gameOver.setLineColor(new Color(170, 51, 106)); 
        
        
    }
}
