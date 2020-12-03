package Chess;

public class Knight extends ChessFigure implements Movable {

    public Knight(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2658' : '\u265E', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        int localX = this.getX();
        int localY = this.getY();
        if (Main.Field[to_x][to_y].isColor() != this.isColor() || !Main.Field[to_x][to_y].isState()) {
            if (Math.abs(localX - to_x) == 2 && Math.abs(localY - to_y) == 1) return true;
            else if (Math.abs(localX - to_x) == 1 && Math.abs(localY - to_y) == 2) return true;
            else return false;
        }
        else return false;
    }

    @Override
    public void MoveTo(int to_x, int to_y) {
        super.MoveTo(to_x, to_y);
    }
}