import java.awt.*;

public class Food {

    private int x;
    private int y;

    public Food(Snake player) {
        this.random_spawn(player);
    }

    public void random_spawn(Snake player) {
        x = (int) (Math.random() * Game.width);
        y = (int) (Math.random() * Game.height);

        boolean ifOnSnake = true;
        while(!ifOnSnake){
            x = (int) (Math.random() * Game.width - 1);
            y = (int) (Math.random() * Game.height - 1);

            for (Rectangle r : player.getBody()){
                if(r.x == x && r.y == y){
                    ifOnSnake = false;
                }
            }
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
