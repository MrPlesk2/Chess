package Chess;

import java.util.Scanner;

public class Pawn extends ChessFigure implements Movable {
    private int stepCount = 0;
    public Pawn(int x, int y, boolean color) {
        super(x, y, color, color ? '\u2659' : '\u265f', true);
    }

    @Override
    public boolean CanMove(int to_x, int to_y) {
        int localX = this.getX();
        int localY = this.getY();
        if (localX - to_x == 0 && Math.abs(localY - to_y) > 0) {
                if (this.stepCount == 0) {
                    if(Math.abs(localY-to_y)==2){
                        if(Main.Field[to_x][to_y].isState())return false;
                        if(this.isColor()){
                            if(Main.Field[localX][localY+1].isState())return false;
                        }
                        else if(Main.Field[localX][localY-1].isState())return false;
                    }
                    else if(Main.Field[to_x][to_y].isState()) return false;
                    if (this.isColor()) return (to_y - localY <= 2) && (to_y - localY > 0);
                    else return (localY - to_y) <= 2 && (localY - to_y > 0);
                } else {
                    if (!Main.Field[to_x][to_y].isState()) {
                        if (this.isColor()) return (to_y - localY <= 1) && (to_y - localY > 0);
                        else return (localY - to_y <= 1) && (localY - to_y > 0);
                    }
                }
        }
        if(Math.abs(localX - to_x) == 1 && Math.abs(localY - to_y) == 1){
            if(Main.Field[to_x][to_y].isColor() != this.isColor() && Main.Field[to_x][to_y].isState()!=false) return true;
            else return false;
        }
        else return false;
    }

    @Override
    public void MoveTo(int to_x, int to_y) {
        this.stepCount++;
        super.MoveTo(to_x, to_y);
        if(to_y == 7){
            Main.PawnOnEnd(to_x,to_y, true);
        }
        if(to_y == 0){
            Main.PawnOnEnd(to_x,to_y, false);
        }
    }
}
