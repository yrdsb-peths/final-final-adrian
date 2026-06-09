import greenfoot.*;

// This class is a subclass of World. It is the main game where the user dodges red blocks and aims for the stone blocks.
public class MyWorld extends World {
    
    // Timer that increases ever time act method is called, keeps track of how long the program has been running
    private int blockSpawnTimer = 0;
    
    // Timer that controls how long before a block will spawn
    private int timeBeforeBlockSpawn = 70;
    
    // Stores the users score
    private int score = 0;
    
    // Label of the score
    private Label scoreLabel;
    
    // Label of the streak
    private Label streakLabel;
    
    // Stores the player streak
    private int streak = 0;
    
    
    public MyWorld() {
        super(560, 720, 1);
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Creates the score label and starts it at 0
        scoreLabel = new Label("0",120);
        addObject(scoreLabel, 280, 80);
        scoreLabel.setFillColor(Color.PINK);
        scoreLabel.setLineColor(Color.PINK); 
        
        // Creates the streak label and starts it at 0
        streakLabel = new Label("Streak: 0", 60);
        addObject(streakLabel, 280, 150);
        streakLabel.setFillColor(Color.PINK);
        streakLabel.setLineColor(Color.PINK);
        
        // Creates the path (ring) that the user follows
        Path playerPath = new Path();
        addObject(playerPath, 280, 390);
        
        // Creates the player instance
        Player ball = new Player(181, 280, 390, 0.055);
        addObject(ball, 280, 390); 
        
    }
    
    // Continiously spawns blocks. Every 10 blocks spawned, blocks start spawning faster.
    public void act()
    {
        spawnBlocks();
        
        if(blockSpawnTimer % 700 == 0)
        {
            timeBeforeBlockSpawn = timeBeforeBlockSpawn - 5;
        }
    }
    
    // spawns block every 70 act method calls
    public void spawnBlocks()
    {
        blockSpawnTimer ++;
        
        if(blockSpawnTimer % timeBeforeBlockSpawn == 0)
        {
            // Sets random x position except for some space on the edges of screen
            int posX = 98 + Greenfoot.getRandomNumber(365);
            // Sets starting y position of the block
            int posY = 30;
            
            // Generates a random number used to determine which block spawns with bias towards the red (obstacle block)
            int random = Greenfoot.getRandomNumber(100);
            
            // Spawns either red, point or dizzy block depending on the random number generated above
            if(random < 70 && random > 10)
            {
                addObject(new Block("Red", 5), posX, posY);
            }
            else if(random > 71)
            {
                addObject(new PointBlock("Point", 5), posX, posY);
            }
            else if(random <= 10)
            {
                addObject(new DizzyBlock("Dizzy", 4), posX, posY);
            }
        }
        
        
    }
    
    // This method updates the score. It is called in the point block class (in the checkCollision method)
    public void addScore()
    {
        // Updates streak
        streak++;
        
        // Updates streak label
        streakLabel.setValue("Streak: " + streak);
        
        // How much points the user will gain when getting the point block
        int points = 1;
        
        if(streak >= 20)
        {
            points = 4;
        }
        else if(streak >= 10)
        {
            points = 2;
        }
        
        // Updates score and score label
        score += points;
        scoreLabel.setValue("" + score);
    }
    
    /* This method resets the players streak when a point block falls off the screen. 
    It is called in the point block class (in the removeIfOffScreen method) */
    public void resetStreak()
    {
        // Reset streak to 0
        streak = 0;
        // Updates streak label to display 0
        streakLabel.setValue("Streak: 0");
    }
    
    /* This method sets the world to GameOver screen when collided with the Red obstacle block. 
    This method is called in the Block class (in the checkCollisions method) */
    public void gameOver()
    {
        Greenfoot.setWorld(new GameOver(score));
    }
}
