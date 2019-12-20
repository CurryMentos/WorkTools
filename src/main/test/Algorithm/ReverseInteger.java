package Algorithm;

/**
 * Created by zengyouzu on 2019/12/20.
 * 翻转一个整型数
 */
public class ReverseInteger {
    public static int reverseInteger(int x) {
        if (x == Integer.MIN_VALUE) {
            System.out.println(Integer.MIN_VALUE);
            return x;
        }

        int num = Math.abs(x);
        int res = 0;
        while (num != 0) {
            if (res > (Integer.MAX_VALUE - num % 10) / 10) {
                if (x > 0) {
                    System.out.println("超出最大整数型");
                    return Integer.MAX_VALUE;
                } else {
                    System.out.println("超出最小整数型");
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + num % 10;
            num /= 10;
        }
        if (x > 0) {
            System.out.println(res);
            return res;
        } else {
            System.out.println(-res);
            return -res;
        }
    }

    public static void main(String[] args) {
        reverseInteger(2147483647);
    }
}
