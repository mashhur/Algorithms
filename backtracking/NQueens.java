package backtracking;

public class NQueens {

    int size = 0;
    char[][] board;

    public NQueens(int n) {
        this.size = n;
        board = new char[n][n];
    }

    public void place() {
        board[0][0] = 'Q';
        for (int i = 0; i < this.size; i++) {
            for (int k = 0; k < this.size; k++) {
                if (isSafe(i, k))
                    board[i][k] = 'Q';
            }
        }
    }

    private boolean isSafe(int n, int m) {
        if (board[n][m] == 'Q')
            return false;

        // check for horizontal / vertical
        for (int i = 0; i < this.size; i++) {
            if (board[n][i] == 'Q')
                return false;
            if (board[i][m] == 'Q')
                return false;
        }

        // check for \ diagonal
        int hor = n, ver = m;
        while (hor >= 0 && ver >= 0) {
            if (board[hor][ver] == 'Q')
                return false;
            hor--;
            ver--;
        }

        hor = n; ver = m;
        while (hor < size && ver < size) {
            if (board[hor][ver] == 'Q')
                return false;
            hor++;
            ver++;
        }

        // check for / diagonal
        hor = n; ver = m;
        while (hor >= 0 && ver < size) {
            if (board[hor][ver] == 'Q')
                return false;
            hor--;
            ver++;
        }

        hor = n; ver = m;
        while (hor < size && ver >= 0) {
            if (board[hor][ver] == 'Q')
                return false;
            hor++;
            ver--;
        }

        return true;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int k = 0; k < this.size; k++) {
                if (board[i][k] == 'Q')
                    System.out.print('Q');
                else
                    System.out.print('-');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens(8);
        queens.place();
        queens.print();
    }
}
