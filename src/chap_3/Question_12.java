package chap_3;

/**
 * Created by Citrix on 2019-01-03.
 */
public class Question_12 {
    /*
     * dfs上下左右，visited数组，要注意这个贪吃蛇的轨迹是要二维数组里面都吃一次的，还有就是此处的visited需要更新的
     * */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || str == null) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int count = 0;//主要需要一个count值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashCorePath(matrix, rows, cols, i, j, str, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hashCorePath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int count) {
        if (count == str.length - 1) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[count]) {
            visited[row * cols + col] = true;
            count++;
            hasPath = hashCorePath(matrix, rows, cols, row - 1, col, str, visited, count)
                    || hashCorePath(matrix, rows, cols, row, col - 1, str, visited, count)
                    || hashCorePath(matrix, rows, cols, row + 1, col, str, visited, count)
                    || hashCorePath(matrix, rows, cols, row, col + 1, str, visited, count);
            /*
            * 这个代码块要放在里面的
            * */
            if (!hasPath) {
                count--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;//这个地方出错了
    }

    public static void main(String[] args) {
        Question_12 question_12 = new Question_12();
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        System.out.println(question_12.hasPath(matrix, 3, 4, str));
    }
}
