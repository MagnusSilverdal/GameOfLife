/**
 * This is a class
 * Created 2019-12-02
 *
 * @author Magnus Silverdal
 */
public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void update(int neighbours) {
        if (isAlive) {
            if (neighbours<2 || neighbours>3) {
                isAlive = false;
            }
        } else {
            if (neighbours == 3) {
                isAlive = true;
            }
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

}
