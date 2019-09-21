public class Solution {
    int count = 0;
    public int InversePairs(int [] array) {
        if(array.length==0){
            return 0;
        }
        mergeSort(array,0,array.length-1);
        return count;
    }
    private void mergeSort(int [] array, int left,int right){
        if(left>=right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    private void merge(int [] array, int left,int mid, int right){
        int[] tmp = new int[right - left + 1];//point
        int i = left, j = mid + 1, k = 0;//point必须要把i,j,k定义在外面
        while (i <= mid && j <= right) {//point
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                count += mid - i + 1;//core point
                count%=1000000007;
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= right) {
            tmp[k++] = array[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            array[left + k] = tmp[k];
        }
    }

}