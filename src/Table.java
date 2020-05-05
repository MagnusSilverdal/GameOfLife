import java.awt.*;

/**
 * This is a class
 * Created 2020-01-21
 *
 * @author Magnus Silverdal
 */
public class Table {
    private int width;
    private int height;
    private int numBalls;
    private Ball[] balls;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        int numBalls = 10;
        balls = new Ball[numBalls];
        balls[0] = new Ball(200,200,100,100,50, Color.RED);
        balls[1] = new Ball(100,100,-100,-100,50, Color.BLUE);
        balls[2] = new Ball(100,200,100,100,50, Color.GREEN);
        balls[3] = new Ball(200,100,200,100,50, Color.PINK);
        balls[4] = new Ball(300,200,100,200,50, Color.CYAN);
        balls[5] = new Ball(200,300,100,100,50, Color.WHITE);
        balls[6] = new Ball(300,300,-200,-200,50, Color.YELLOW);
        balls[7] = new Ball(400,100,100,100,50, Color.ORANGE);
        balls[8] = new Ball(200,400,200,100,50, Color.MAGENTA);
        balls[9] = new Ball(500,500,100,200,50, Color.LIGHT_GRAY);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.width, this.height);
        for (int i = 0; i < balls.length; i++) {
            g.setColor(balls[i].getColor());
            int r = balls[i].getSize();
            g.fillOval(balls[i].getX() - r / 2, balls[i].getY() - r / 2, balls[i].getSize(), balls[i].getSize());
        }
    }

    public void update(double t) {
        for (int i = 0; i < balls.length; i++) {
            balls[i].update(t);
            balls[i].collide(width, height);
        }
    }
}
