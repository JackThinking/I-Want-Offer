package chap_3;

/**
 * Created by Citrix on 2019-01-02.
 */
public class Question_10_plus {
    public int JumpFloor(int target) {
        if(target<2){
            return target;
        }
        int pre = 0;
        int now = 1;
        int curr = 0;
        for (int i = 2; i <= target+1; i++) {
            curr = pre + now;
            pre = now;
            now = curr;
        }
        return curr;
    }
}
