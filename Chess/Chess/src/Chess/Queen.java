package Chess;

public class Queen extends ChessFigure implements Movable {

    public Queen(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2655' : '\u265B', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        if(RookMove(to_x,to_y)||BishopMove(to_x, to_y)) return true;
        return false;
    }

    @Override
    public void MoveTo(int to_x, int to_y) {
        super.MoveTo(to_x, to_y);
    }

    private boolean RookMove(int to_x, int to_y){
        int localX = this.getX();
        int localY = this.getY();
        if(Main.Field[to_x][to_y].isColor() != this.isColor() || Main.Field[to_x][to_y].isState()==false){
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
        return false;
    }

    private boolean BishopMove(int to_x, int to_y){
        int localX = this.getX();
        int localY = this.getY();
        if(Math.abs(localX - to_x) == Math.abs(localY - to_y)){
            if(localX>to_x && localY>to_y){
                int j = localY - 1;
                for(int i = localX - 1; i != to_x; i--){
                    if(Main.Field[i][j].isState()) return false;
                    j--;
                }
                return true;
            }
            if(localX>to_x && localY<to_y){
                int j = localY + 1;
                for(int i = localX - 1; i != to_x; i--){
                    if(Main.Field[i][j].isState()) return false;
                    j++;
                }
                return true;
            }
            if(localX<to_x && localY>to_y){
                int j = localY - 1;
                for(int i = localX + 1; i != to_x; i++){
                    if(Main.Field[i][j].isState()) return false;
                    j--;
                }
                return true;
            }
            if(localX<to_x && localY<to_y){
                int j = localY + 1;
                for(int i = localX + 1; i != to_x; i++){
                    if(Main.Field[i][j].isState()) return false;
                    j++;
                }
            }
            return true;
        }
        return false;
    }
}
