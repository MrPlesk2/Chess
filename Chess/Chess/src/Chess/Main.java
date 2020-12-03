package Chess;

import java.util.Scanner;


public class Main {

    public static ChessFigure[][] Field;
    static Scanner sc;
    static boolean logs = true;
    static int[] Coor;

    public static void main(String[] args) {
        Coor = new int[4];
        sc = new Scanner(System.in);
        NewGame();
        while (true) {
            DrawField();
            if (readInputData())
                if (Field[Coor[0]][Coor[1]].CanMove(Coor[2], Coor[3]))
                    Step(Coor[0], Coor[1], Coor[2], Coor[3]);

        }

        // a7-a6
        // en-gn - ракировка короткая
        // en-cn - ракировка длинная
    }

    static void DrawField() {
        System.out.println("----------------------------");
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++)
                System.out.printf("%2s", Field[j][7 - i].toString() );
            System.out.println();
        }
        System.out.println("----------------------------");

    }

    static void NewGame() {
        Field = new ChessFigure[8][8];
        for (int i = 0; i < Field.length; i++)
            for (int j = 0; j < Field[i].length; j++)
                Field[i][j] = new Empty(i, j);

        for (int i = 0; i < Field.length; i++) {
            Field[i][1] = new Pawn(i, 1, true);
            Field[i][6] = new Pawn(i, 6, false);
        }
        Field[0][0] = new Rook(0, 0, true);
        Field[7][0] = new Rook(7, 0, true);
        Field[0][7] = new Rook(0, 7, false);
        Field[7][7] = new Rook(7, 7, false);

        Field[1][0] = new Knight(1, 0, true);
        Field[6][0] = new Knight(6, 0, true);
        Field[1][7] = new Knight(1, 7, false);
        Field[6][7] = new Knight(6, 7, false);

        Field[2][0] = new Bishop(2, 0, true);
        Field[5][0] = new Bishop(5, 0, true);
        Field[2][7] = new Bishop(2, 7, false);
        Field[5][7] = new Bishop(5, 7, false);

        Field[3][0] = new Queen(3, 0, true);
        Field[3][7] = new Queen(3, 7, false);

        Field[4][0] = new King(4, 0, true);
        Field[4][7] = new King(4, 7, false);
    }

    static void Step(int from_x, int from_y, int to_x, int to_y) {
        Field[to_x][to_y] = Field[from_x][from_y];
        Field[from_x][from_y] = new Empty(from_x, from_y);
        Field[to_x][to_y].MoveTo(to_x, to_y);
    }

    static boolean readInputData() {
        boolean flag = true;
        String input = sc.nextLine().toLowerCase();
        if(input.length()==5) {
            if (input != null) {
                Coor[0] = input.charAt(0) - 'a';// from X
                Coor[1] = input.charAt(1) - '1';// from Y
                Coor[2] = input.charAt(3) - 'a';// to X
                Coor[3] = input.charAt(4) - '1';// to Y
                for (byte i = 0; i < Coor.length; i++)
                    if (Coor[i] < 0 || Coor[i] > 7)
                        flag = false;
                if (logs) {
                    System.out.println(input);
                    for (byte i = 0; i < Coor.length; i++)
                        System.out.print(Coor[i] + "; ");
                    System.out.println();
                }
                return flag;
            }
            return false;
        }
        return false;
    }
    static void PawnOnEnd(int to_x, int to_y, boolean colour) {

        DrawField();
        System.out.println("Which figure do you want?(write only number): \n 1)Knight \n 2)Bishop \n 3)Rook \n 4)Queen");
        String input = sc.nextLine();
        int choose = ((int)(input.charAt(0)) - 48);
        System.out.println(choose);
        switch(choose){
            case 1: Field[to_x][to_y] = new Knight(to_x,to_y, colour);
                break;
            case 2: Field[to_x][to_y] = new Bishop(to_x,to_y, colour);
                break;
            case 3: Field[to_x][to_y] = new Rook(to_x,to_y, colour);
                break;
            case 4: Field[to_x][to_y] = new Queen(to_x,to_y, colour);
                break;
        }
    }
    static boolean Roque(boolean lenght, boolean colour){
        int lineX;
        char rookSymbol;
        if(colour){ lineX = 0;
        rookSymbol = '\u2656';
        }
        else {lineX = 7;
        rookSymbol = '\u265c';
        }
            if(lenght){
                if (Field[5][lineX].isState() == false)
                    if (Field[6][lineX].isState() == false)
                        if (Field[7][lineX].getSymbol() == rookSymbol){
                            Step(7,lineX,5,lineX);
                            return true;
                        }
                return false;
                }
            else {
                if (Field[3][lineX].isState() == false)
                    if (Field[2][lineX].isState() == false)
                        if (Field[1][lineX].isState() == false)
                            if (Field[0][lineX].getSymbol() == rookSymbol){
                                Step(0,lineX,3,lineX);
                                return true;
                        }
            }
        return false;
    }
}
