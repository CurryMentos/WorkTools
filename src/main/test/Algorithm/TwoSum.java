package Algorithm;

import java.util.HashMap;

/**
 * Created by zengyouzu on 2019/12/20.
 * 给定一个整型数组，找出能相加起来等于一个特定目标数字的两个数。
 * 函数 twoSum 返回这两个相加起来等于目标值的数字的索引，且 index1 必须小于 index2。
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int searched = target - nums[i];
            if (map.containsKey(searched) && map.get(searched) != i) {
                int index = map.get(searched);
                if (index < i) {
                    result[0] = map.get(searched) + 1;
                    result[1] = i + 1;
                } else {
                    result[0] = i + 1;
                    result[1] = map.get(searched) + 1;
                }
            }
        }
        System.out.println("数组中第" + result[0] + "个元素");
        System.out.println("数组中第" + result[1] + "个元素");
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 8, 11, 20};
        int target = 19;
        twoSum(nums, target);
    }
}
