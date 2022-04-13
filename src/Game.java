import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener{

    private Snake snake;
    private Food food;
    private Graphic graphics;

    private JFrame window;
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public Game(){
        window = new JFrame();

        window.setTitle("Snake");
        window.setSize(width * dimension, height * dimension);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snake = new Snake();
        food = new Food(snake);
        graphics = new Graphic(this);

        window.add(graphics);
    }


    public void start(){
        graphics.state = "RUNNING";
    }

    public void update(){
        if(graphics.state == "RUNNING"){
            if(checkFoodCollision()) {
                snake.grow();
                food.random_spawn(snake);
            }
            else if(checkWallCollision() || checkSelfCollision()) {
                graphics.state = "END";
            }
            else{
                snake.move();
            }
        }
    }
    private boolean checkWallCollision(){
        if(snake.getBodyFirstelmX() < 0 || snake.getBodyFirstelmX() >= width * dimension
                || snake.getBodyFirstelmY() < 0 || snake.getBodyFirstelmY() >= width * dimension){
            return true;
        }
        return false;
    }

    private boolean checkFoodCollision(){
        if(snake.getBodyFirstelmX() == food.getX() * dimension && snake.getBodyFirstelmY() == food.getY() * dimension){
            return true;
        }
        return false;
    }

    private boolean checkSelfCollision(){
        for(int i = 1; i < snake.getBody().size(); i++){
            if(snake.getBodyFirstelmX() == snake.getBody().get(i).x &&
            snake.getBodyFirstelmY() == snake.getBody().get(i).y){
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(graphics.state == "RUNNING"){


            if(keyCode == KeyEvent.VK_W) {
                snake.up();
            }
            else if(keyCode == KeyEvent.VK_A) {
                snake.left();
            }
            else if(keyCode == KeyEvent.VK_S) {
                snake.down();
            }
            else if (keyCode == KeyEvent.VK_D) {
                snake.right();
            }
        }
        else{
            this.start();
        }
    }



    @Override
    public void keyReleased(KeyEvent e) { }



    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public JFrame getWindow() {
        return window;
    }
}