package chap2;

/**
 * Created by Citrix on 2019-01-02.
 */
public class Question_13 {
    /*
     * 机器人移动我能想到的是dp题，这里额外的还需要对其进行剪枝，错啦
     * 应该是用回溯的方法,这种图的渗透基本都是靠上下左右helper函数完成的
     * */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }*/
        //默认就是false的，不需要进行赋值
        int count = help(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int help(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + help(threshold, rows, cols, row + 1, col, visited)
                    + help(threshold, rows, cols, row, col + 1, visited)
                    + help(threshold, rows, cols, row - 1, col, visited)
                    + help(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigit(row) + getDigit(col) <= threshold && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private int getDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;//这个地方出现了小问题
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question_13 question_13 = new Question_13();

        System.out.println(question_13.movingCount(5,10,10));
    }
}
