package Algorithm;

import org.testng.annotations.Test;

import java.math.BigInteger;

/**
 * Created by zengyouzu on 2019/12/12.
 * 递归算法
 */
public class Recursive {
    public int sumA(int i) {
        if (i == 1) {
            return 1;
        }
        return i + sumA(i - 1);
    }

    public BigInteger sumB(int i) {
        if (i == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(i).multiply(sumB(i - 1));
    }

    public void LoopPlus() {
        System.out.println("计算结果：" + sumA(100) + "!");
    }

    public void LoopMultiply(){
        System.out.println("计算结果：" + sumB(10) + "!");
    }

    @Test
    public void test(){
//        LoopPlus();
        LoopMultiply();
    }
}
