import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 750, 1);
        
        Player ball = new Player();
        addObject(ball, 300, 420);
        
        Block obstacle = new Block("Red");
        addObject(obstacle, 300, 200);
    }
}
