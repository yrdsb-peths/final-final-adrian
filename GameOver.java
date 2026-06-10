import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// This class is a subclass of World. It is a game over world, that opens when the user hits the red block.
public class GameOver extends World
{

    // Constructor. Takes score as a parameter.
    public GameOver(int score)
    {    
        // Create a new world with 560x720 cells with a cell size of 1x1 pixels.
        super(560, 720, 1); 
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Add game over label
        Label gameOver = new Label("Game Over", 80);
        addObject(gameOver, 280, 150);
        gameOver.setFillColor(new Color(170, 51, 106));
        gameOver.setLineColor(new Color(170, 51, 106)); 
        
        // Add score labels and displays the user's score before the game ended
        Label scoreLabel = new Label("Score", 60);
        addObject(scoreLabel, 280, 250);
        scoreLabel.setLineColor(Color.WHITE);
        
        Label userScore = new Label(score, 60);
        addObject(userScore, 280, 300);
        userScore.setFillColor(new Color(170, 51, 106));
        userScore.setLineColor(new Color(170, 51, 106)); 
        
        // Add restart button
        Button restartButton = new Button("game", "Restart");
        addObject(restartButton, 280, 450);

        // Add back to menu button
        Button menuButton = new Button("title", "Menu");
        addObject(menuButton, 280, 550);
        
    }
}
