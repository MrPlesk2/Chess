package Chess;

public class Bishop extends ChessFigure implements Movable {

    public Bishop(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2657' : '\u265D', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        int localX = this.getX();
        int localY = this.getY();
        System.out.println("Bishop is moving");
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

    @Override
    public void MoveTo(int to_x, int to_y) {
        super.MoveTo(to_x, to_y);
    }
}
