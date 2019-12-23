package Algorithm;

import org.testng.annotations.Test;

import java.math.BigInteger;

/**
 * Created by zengyouzu on 2019/12/12.
 * 递归算法
 */
public class Recursive {
    public int getValueA(int i) {
        if (i == 1) {
            return 1;
        }
        return i + getValueA(i - 1);
    }

    public BigInteger getValueB(int i) {
        if (i == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(i).multiply(getValueB(i - 1));
    }

    public int getValueC(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return getValueC(i - 1) + getValueC(i - 2);
    }

    public int getValueD(int x, int y) {
        if (y <= x && y >= 0) {
            if (y == 0 || x == y) {
                return 1;
            } else {
                return getValueD(x - 1, y - 1) + getValueD(x - 1, y);
            }
        }
        return -1;

    }

    //阶加
    public void LoopPlus(int i) {
        System.out.println("计算结果：" + getValueA(i) + "!");
    }

    //阶乘
    public void LoopMultiply(int i) {
        System.out.println("计算结果：" + getValueB(i) + "!");
    }

    //斐波那契数列
    public void Fibonacci(int i) {
        System.out.println("计算结果：" + getValueC(i) + "!");
    }

    //杨辉三角
    public void PascalTriangle(int x, int y) {
        System.out.println("计算结果：" + getValueD(x, y) + "!");
    }

    @Test
    public void test() {
//        LoopPlus();
//        LoopMultiply();
//        Fibonacci(5);
        PascalTriangle(10,8);
    }
}
