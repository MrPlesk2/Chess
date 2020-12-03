package Chess;

public class King extends ChessFigure implements Movable {
    private boolean move = true;
    public King(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2654' : '\u265A', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        int localX = this.getX();
        int localY = this.getY();
        if (Main.Field[to_x][to_y].isColor() || !Main.Field[to_x][to_y].isState()) {
            if (Math.abs(localX - to_x) <= 1 && Math.abs(localY - to_y) <= 1) return true;
            else if (move) {
                if (to_x - localX == 2 && to_y - localY == 0) {
                    if (Main.Roque(true, this.isColor())) return true;

                }
                else if (to_x - localX == -2 && to_y - localY == 0) {
                        if (Main.Roque(false, this.isColor())) return true;

                }
            }
            return false;
        }
        return false;
    }
    @Override
    public void MoveTo(int to_x, int to_y) {
        move = false;
        super.MoveTo(to_x, to_y);
    }
}
