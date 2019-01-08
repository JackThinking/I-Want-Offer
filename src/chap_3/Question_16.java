package chap_3;

/**
 * Created by Citrix on 2019-01-08.
 */
public class Question_16 {
    /*
    * 要考虑很多条件，这种题目自己还是有点生疏
    * */
    public double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            /*
             * 可以抛异常，设置全局变量，返回值，这边是抛异常
             * */
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }
        if (base == 0) {
            return 1;
        }
        int exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }
        double result = PowerHelper(base, exp);
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double PowerHelper(double base, int exponent) {
        if (exponent == 0) {
            return 0;
        }
        if (exponent == 1) {
            return base;
        }
        double result = PowerHelper(base, exponent >> 1);//这边有个小点
        result = result * result;
        if (exponent % 2 == 1) {
            result = result * base;
        }
        return result;
    }
}
