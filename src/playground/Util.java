package playground;

/**
 * Created by Citrix on 2019-03-07.
 */
public class Util {
    public boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (num > rev) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return (num == rev || num == rev / 10);
    }

    public int reverseInt(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }
}
