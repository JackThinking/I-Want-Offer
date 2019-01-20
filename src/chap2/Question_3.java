package chap2;

/**
 * Created by Citrix on 2019-01-20.
 */
public class Question_3 {
    /*
     * 1.先排序；2.哈希表；3.使用下标和本身值的比较
     * */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    public void swap(int numbers[], int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        Question_3 q = new Question_3();
        int numbers[] = {2, 1, 3, 1, 4};
        int dup[] = new int[1];
        System.out.println(q.duplicate(numbers, 5,dup));

    }
}
