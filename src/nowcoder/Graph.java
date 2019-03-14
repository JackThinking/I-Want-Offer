package nowcoder;

/**
 * Created by Citrix on 2019-03-10.
 */
public class Graph {
    /*
    *   Input:
        11110
        11010
        11000
        00000
        Output: 1
    * */
    private int res = 0;
    private int m,n;
    private int[][] pat = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return res;
        }
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]&&grid[i][j]=='1'){
                    res++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newx = x+pat[k][0];
            int newy = y+pat[k][1];
            if (inArea(newx,newy) && grid[newx][newy] == '1' && !visited[newx][newy]){
                dfs(grid, visited, newx, newy);
            }
        }
    }

    private boolean inArea(int newx, int newy) {
        if (newx>=0 && newx<m && newy>=0 && newy<n){
            return true;
        }else {
            return false;
        }
    }
}
