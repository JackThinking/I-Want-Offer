package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2019-04-26.
 */
public class N_Queen {
    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return res;
        }
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> path = new ArrayList<>();
        findQueen(n, path, 0);
        return res;
    }

    private void findQueen(int n, List<Integer> path, int index) {
        if (index == n) {
            res.add(convertBoard(new ArrayList<>(path), n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i + index] && !dia2[i - index + n - 1]) {
                col[i] = true;
                dia1[i + index] = true;
                dia2[i - index + n - 1] = true;
                path.add(i);
                findQueen(n, path, index + 1);
                col[i] = false;
                dia1[i + index] = false;
                dia2[i - index + n - 1] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    private List<String> convertBoard(List<Integer> path, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == path.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
}
