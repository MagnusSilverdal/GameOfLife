import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This is a class
 * Created 2019-12-03
 *
 * @author Magnus Silverdal
 */
public class GameOfLifeSwing extends Canvas implements Runnable{
    public static String title = "GameOfLife";

    //private Thread thread;
    //private boolean running = false;

    private JFrame frame;
    private BufferedImage image;
    private int[] pixels;
    private int scale = 4;

    private World w;

    public GameOfLifeSwing(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        Dimension size = new Dimension(scale*w, scale*h);
        setPreferredSize(size);
        frame = new JFrame();
        this.w = new World(w,h);
    }

    private void draw() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        update();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        //g.setRGB(0, 0, width, height, pixels,0,width);
        g.dispose();
        bs.show();
    }

    private void update() {
        for (int y = 0 ; y < w.getHeight() ; y++) {
            for (int x = 0; x < w.getWidth(); x++) {
                pixels[y*w.getWidth()+x] = ((w.getCellStatusAt(x,y)?0x000000:0xFFFFFF));
            }
        }
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long lastUpdate = startTime;
        long i = 0;
        while (true) {
            if (System.currentTimeMillis()-lastUpdate > 40) {
                draw();
                frame.setTitle("GameOfLife " + (System.currentTimeMillis()-startTime)/1000 + "s, " + i + " iterations");
                i++;
                w.update();
                lastUpdate = System.currentTimeMillis();
            }
        }
    }

    public static void main(String[] args) {
        GameOfLifeSwing game = new GameOfLifeSwing(475,270);
        //game.frame.setResizable(false);
        game.frame.setTitle("GameOfLife");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        game.run();
    }
}
