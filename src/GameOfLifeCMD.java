/**
 * This is a class
 * Created 2019-12-02
 *
 * @author Magnus Silverdal
 */
public class GameOfLifeCMD implements Runnable{
    private World w;

    public GameOfLifeCMD(int w, int h) {
        this.w = new World(w,h);
    }

    private void draw(World w) {
        for (int y = 0 ; y < w.getHeight() ; y++) {
            String s = "";
            for (int x = 0; x < w.getWidth(); x++) {
                s += (""+(w.getCellStatusAt(x,y)?"X":"."));
            }
            System.out.println(s);
        }
        System.out.println();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long lastUpdate = startTime;
        while (System.currentTimeMillis()-startTime < 10000) {
            if (System.currentTimeMillis()-lastUpdate > 200) {
                draw(w);
                w.update();
                lastUpdate = System.currentTimeMillis();
            }
        }
    }

    public static void main(String[] args) {
        GameOfLifeCMD game = new GameOfLifeCMD(10,10);
        game.run();
    }
}
