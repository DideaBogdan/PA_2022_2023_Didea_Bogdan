import java.util.Arrays;
import java.util.List;

public class Board {
    private String [][] board = new String[15][15];

    public Board() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = "N";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String resp = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                resp = resp + board[i][j] + " ";
            }
            resp = resp + "\n";
        }
        return resp;
    }
}
