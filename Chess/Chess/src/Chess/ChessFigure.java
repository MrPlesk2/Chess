package Chess;

abstract public class ChessFigure {
    static private boolean logs = !true;
    static private int count = 0;
    private int x, y, id_f;
    private char symbol;
    private boolean color, state;//color: true = white, false = black

    public ChessFigure(int x, int y, boolean color, char symbol, boolean state) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = color;
        this.state = state;
        this.id_f = count++;
    }

    public void MoveTo(int to_x, int to_y) {
        this.x = to_x;
        this.y = to_y;
    }

    public abstract boolean CanMove(int to_x, int to_y);


    @Override
    public String toString() {
        if (logs) return String.valueOf(this.symbol) + " " +
                String.valueOf(this.x) + " " +
                String.valueOf(this.y) + " " +
                String.valueOf(this.getClass()) + " " +
                String.valueOf(this.isState());
        else return String.valueOf(this.symbol);
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public boolean isState() { return state; }

    public boolean isColor() {return color;}

    public char getSymbol() {return symbol;}
}
