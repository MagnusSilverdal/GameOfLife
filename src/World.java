/**
 * This is a class
 * Created 2019-12-02
 *
 * @author Magnus Silverdal
 */
public class World {
    private int width;
    private int height;

    private Cell[] cells;
    private int[] livingNeighbours;

    public World(int w, int h) {
        this.width = w;
        this.height = h;
        this.cells = new  Cell[this.width*this.height];
        this.livingNeighbours = new int[this.width*this.height];
        repopulate();
        updateNeighbours();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void update() {
        for (int i = 0 ; i < cells.length ; i++) {
            cells[i].update(livingNeighbours[i]);
        }
        updateNeighbours();
    }

    public boolean getCellStatusAt(int x, int y) {
        return cells[y*width+x].isAlive();
    }

    private void updateNeighbours() {
        for(int i = 0 ; i < livingNeighbours.length ; i++) {
            int sum = 0;
            int x=i%width;
            int y=i/width;
            for (int dx = -1 ; dx < 2 ; dx++) {
                for (int dy = -1 ; dy < 2 ; dy++) {
                    if (dx==0 && dy==0) {
                        continue;
                    }
                    if ((x + dx)>=0 && (x+dx) < width && (y+dy) >= 0 && (y+dy) < height) {
                        if (cells[(y+dy)*width+x+dx].isAlive()) {
                            sum++;
                        }
                    }
                }
            }
            livingNeighbours[i] = sum;
        }
    }

    private void repopulate() {
        for (int i = 0 ; i < cells.length ; i++) {
            cells[i] = new Cell(Math.random() > 0.65);
        }
    }


}
