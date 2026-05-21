import greenfoot.*;

public class MyWorld extends World {

    private int blockSpawnTimer = 0;
    
    public MyWorld() {
        super(600, 750, 1);
        
        Player ball = new Player();
        addObject(ball, 300, 420);
        
        Block obstacle = new Block("Red", 3);
        addObject(obstacle, 300, 200);
    }
    
    
    public void act()
    {
        spawnBlocks();
    }
    
    public void spawnBlocks()
    {
        blockSpawnTimer ++;
        
        if(blockSpawnTimer % 70 == 0)
        {
            int posX = Greenfoot.getRandomNumber((getWidth() - 120 ) + 60);
            int posY = 30;
            
            addObject(new Block("Red", 3), posX, posY);
        }
        
        
    }
}
