import java.awt.*;

/**
 * This is a class
 * Created 2020-01-21
 *
 * @author Magnus Silverdal
 */
public class Ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private int size;
    private Color color;

    public Ball(int x, int y, double vx, double vy, int size, Color color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = 250;
        this.ay = 250;
        this.size = size;
        this.color = color;
    }

    public int getX() {
        return (int)Math.round(this.x);
    }

    public int getY() {
        return (int)Math.round(this.y);
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void update(double t) {
        x += vx*t;
        y += vy*t;
        vx += ax*t;
        vy += ay*t;
    }

    public void collide(int width, int height) {
        if (x < 0+size/2) {
            x=0+size/2;
            vx = -vx;
        } else if (x > width-size/2) {
            x=width-size/2;
            vx = -vx;
        }
        if (y < 0+size/2) {
            y=0+size/2;
            vy = -vy;
        } else if (y > height-size/2) {
            y=height-size/2;
            vy = -vy;
        }
    }
}
