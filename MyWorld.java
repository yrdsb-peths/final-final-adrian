import greenfoot.*;

public class MyWorld extends World {
    
    // Timer that increases ever frame
    private int blockSpawnTimer = 0;
    
    // Stores the users score
    private Counter scoreCounter;
    
    
    public MyWorld() {
        super(600, 750, 1);
        
        scoreCounter = new Counter();
        addObject(scoreCounter, 100, 40);
        
        Player ball = new Player();
        addObject(ball, 300, 420);
        
        PointBlock b = new PointBlock("Point", 3);
        addObject(b, 300, 420);
        
        
    }
    
    
    public void act()
    {
        spawnBlocks();
    }
    
    // spawns block every 70 frames
    public void spawnBlocks()
    {
        blockSpawnTimer ++;
        
        if(blockSpawnTimer % 70 == 0)
        {
            // Sets random x position except for some space on the edges of screen
            int posX = Greenfoot.getRandomNumber((getWidth() - 120 ) + 60);
            int posY = 30;
            
            // Generates a random number used to determine which block spawns
            int random = Greenfoot.getRandomNumber(100);
            
            // Spawn block
            if(random < 70)
            {
                addObject(new Block("Red", 5), posX, posY);
            }
            else if(random > 71)
            {
                addObject(new PointBlock("Point", 5), posX, posY);
            }
        }
        
        
    }
    
    public void addScore(int points)
    {
        scoreCounter.add(points);
    }
}
