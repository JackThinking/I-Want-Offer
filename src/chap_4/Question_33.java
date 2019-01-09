package chap_4;

/**
 * Created by Citrix on 2019-01-09.
 */
public class Question_33 {
    /*
     * 数组不好分的话，建立子函数进行迭代，加入start和end指针
     * */
    public boolean VerifySquenceOfBST(int[] sequence) {
        /*
        * 数组为空当然用length为0来判断呀，怎么会用null来判断呢？
        * */
        if (sequence.length == 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;//应该是return true的
        }
        int i = start;//骚操作吧，要是我就之间另外取一个index了
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        //end也要-1啊，尾巴去掉一个
        return helper(sequence, start, i - 1) && helper(sequence, i, end - 1);
    }
}
