package Chess;

public interface Movable {

    boolean CanMove(int to_x, int to_y);

    void MoveTo(int to_x, int to_y);

}
