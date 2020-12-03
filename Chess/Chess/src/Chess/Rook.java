package Chess;



public class Rook extends ChessFigure implements Movable {


    public Rook(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2656' : '\u265c', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        System.out.println("Rook is moving");
        int localX = this.getX();
        int localY = this.getY();
        if (Math.abs(localX - to_x) > 0 && Math.abs(localY - to_y) > 0) return false;
        else if (Math.abs(localX - to_x) == 0 && Math.abs(localY - to_y) == 0) return false;
        else if(Main.Field[to_x][to_y].isColor() != this.isColor() || Main.Field[to_x][to_y].isState()==false){
            if (Math.abs(localX - to_x) > 0 && Math.abs(localY - to_y) == 0) {
            if (localX > to_x) {
                for (int i = localX - 1; i > to_x; i--) {
                    if (Main.Field[i][localY].isState() != false) return false;
                }
                return true;
            } else {
                for (int i = localX + 1; i < to_x; i++) {
                    if (Main.Field[i][localY].isState() != false) return false;
                }
                return true;
            }

            }
            else if (Math.abs(localX - to_x) == 0 && Math.abs(localY - to_y) > 0) {
                if (localY > to_y) {
                    for (int i = localY - 1; i > to_y; i--) {
                        if (Main.Field[localX][i].isState() != false) return false;
                    }
                    return true;
                }
                else {
                    for (int i = localY + 1; i < to_y; i++) {
                        if (Main.Field[localX][i].isState() != false) return false;
                    }
                    return true;
                }
            }
            else return false;
        }
        else return false;
    }


    @Override
    public void MoveTo(int to_x, int to_y) {
        super.MoveTo(to_x, to_y);
    }
}
