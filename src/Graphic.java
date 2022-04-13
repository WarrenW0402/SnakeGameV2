import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class Graphic extends JPanel implements ActionListener {
    private Timer timer = new Timer(200, this);
    private Snake snake;
    private Food food;
    private Game game;

    public String state;

    public Graphic(Game g){
        timer.start();
        state = "START";
        game = g;
        food = g.getFood();
        snake = g.getSnake();
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        if(state == "START"){
            graphics2D.setColor(Color.black);
            graphics2D.drawString("Press Any Key", Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);
        }
        else if(state == "RUNNING") {


            graphics2D.setColor(Color.BLACK);
            graphics2D.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);

            graphics2D.setColor(Color.green);
            graphics2D.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);
            for (Rectangle r : snake.getBody()) {
                graphics2D.fill(r);
            }
        }
        else {
            graphics2D.setColor(Color.black);
            graphics2D.drawString("Your Score: " + (snake.getBody().size() -3), Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        game.update();
    }
}
