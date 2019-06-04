import java.util.Arrays;

public class Main {
    int m;
    int n;
    int[][] pat = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        //Arrays.fill(visited, false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearch(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordSearch(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[x][y];
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + pat[i][0];
                int newy = y + pat[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (wordSearch(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Main main = new Main();
        char[][] board = {{'b'}, {'a'}, {'b'}};
        String word = "bbabab";
        System.out.println(main.exist(board, word));

    }
}