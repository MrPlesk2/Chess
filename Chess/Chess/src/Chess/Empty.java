package Chess;

public class Empty extends ChessFigure {

    public Empty(int x, int y) {
        super(x, y, true, '\u2B1C', false);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        return false;
    }
}
