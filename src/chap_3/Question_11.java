package chap_3;

/**
 * Created by Citrix on 2019-01-01.
 */
public class Question_11 {
    /*
    * 这道题只能想到类似的题目，但是连和前后两个指针值进行比较都没有想到，之后的一系列判断也没有想到，很生疏
    * */
    public int minNumberInRotateArray(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;//考虑到可能是没有翻转的情况，其初始值不能是中间值
        while (array[index1] >= array[index2]) {//判断条件可不是用指针大小比较
            if (index2 - index1 == 1) {
                indexMid = index2;//这个地方是后面那个呀
                break;
            }
            indexMid = index1 + (index2 - index1) / 2;//这个地方居然也写错

            if (array[index1] == array[index2] && array[index1] == array[indexMid]) {
                return minOrder(array, index1, index2);//要考虑到首尾和mid都相等的情况，这个时候就只能乖乖的顺序遍历了
            } else if (array[indexMid] >= array[index1]) {//等于号也是一个考点
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    private int minOrder(int[] array, int index1, int index2) {
        int res = array[index1];
        for (int i = index1; i < index2; i++) {
            if (array[i] < res) {
                res = array[i];
            }
        }
        return res;
    }
}
