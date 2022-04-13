import java.awt.*;
import java.util.ArrayList;


public class Snake {
    private ArrayList<Rectangle> body;
    private int width = Game.width;
    private int height = Game.height;
    private int dimension = Game.dimension;
    // Directions: Nothing, left, right, down, up
    private String move;


    public Snake() {
        body = new ArrayList<>();

        Rectangle tempbody = new Rectangle(Game.dimension, Game.dimension);

        /* Spawn the snake at the middle */
        tempbody.setLocation(width / 2 * dimension, height / 2 * dimension);
        body.add(tempbody);

        tempbody = new Rectangle(dimension,dimension);
        tempbody.setLocation((width / 2 -1) * dimension, (height / 2) * dimension);
        body.add(tempbody);

        tempbody = new Rectangle(dimension,dimension);
        tempbody.setLocation((width / 2 -2) * dimension, (height / 2) * dimension);
        body.add(tempbody);

        move = "NOTHING";
    }
    public void move(){
        if(move != "NOTHING"){
            Rectangle firstbody = body.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if (move == "UP"){
                temp.setLocation(firstbody.x, firstbody.y - Game.dimension);
            }
            else if (move == "DOWN"){
                temp.setLocation(firstbody.x, firstbody.y + Game.dimension);
            }
            else if (move == "LEFT"){
                temp.setLocation(firstbody.x - Game.dimension, firstbody.y );
            }
            else if (move == "RIGHT"){
                temp.setLocation(firstbody.x + Game.dimension, firstbody.y);
            }
            body.add(0, temp);
            body.remove(body.size()-1);
        }
    }

    public void grow(){
        Rectangle firstbody = body.get(0);
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if (move == "UP"){
            temp.setLocation(firstbody.x, firstbody.y - Game.dimension);
        }
        else if (move == "DOWN"){
            temp.setLocation(firstbody.x, firstbody.y + Game.dimension);
        }
        else if (move == "LEFT"){
            temp.setLocation(firstbody.x - Game.dimension, firstbody.y );
        }
        else if (move == "RIGHT"){
            temp.setLocation(firstbody.x + Game.dimension, firstbody.y);
        }
        body.add(0, temp);
    }


    public ArrayList<Rectangle> getBody(){
        return body;
    }

    public void setBody(ArrayList<Rectangle> body){
        this.body = body;
    }

    public int getBodyFirstelmX(){
        return body.get(0).x;
    }

    public int getBodyFirstelmY(){
        return body.get(0).y;
    }

    public void up(){
        if(move != "DOWN") {
            move = "UP";
        }
    }
    public void down(){
        if(move != "UP"){
            move = "DOWN";
        }
    }
    public void left(){
        if(move != "RIGHT") {
            move = "LEFT";
        }
    }
    public void right(){
        if(move != "LEFT") {
            move = "RIGHT";
        }
    }




}
