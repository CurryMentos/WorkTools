package Algorithm;

import java.util.*;

/**
 * Created by zengyouzu on 2019/12/23.
 * 求两个数组的交集
 */
public class FindIntersectionBetweenTwoArrays {
    //算法一：暴力搜索，时间复杂度O(n^2)，空间复杂度O(1)
    public ArrayList<Integer> getIntersection(int[] arr, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length == 0 || arr2 == null || arr2.length == 0) {
            return res;
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr2[j] == temp && !res.contains(temp)) {
                    res.add(temp);
                    break;
                }
            }
        }
        return res;
    }

    //算法二：先排序，然后定义两个指针，时间复杂度O(nlogn) (排序)，空间复杂度O(1)
    public ArrayList<Integer> getIntersection2(int[] arr, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length == 0 || arr2 == null || arr2.length == 0) {
            return res;
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] < arr2[j]) {
                i++;
            } else if (arr[i] > arr2[j]) {
                j++;
            } else {
                if (!res.contains(arr[i])) {
                    res.add(arr[i]);
                }
                i++;
                j++;
            }
        }
        return res;
    }

    //算法三：map计数，时间复杂度O(n)，空间复杂度O(n)，空间换时间
    public ArrayList<Integer> getIntersection3(int[] arr, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length == 0 || arr2 == null || arr2.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                value++;
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            if (map.containsKey(key) && !res.contains(key)) {
                res.add(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 3, 3, 4};
        int[] arr2 = {2, 3, 3, 4, 5, 6};
        FindIntersectionBetweenTwoArrays fb = new FindIntersectionBetweenTwoArrays();
        List<Integer> res = fb.getIntersection3(arr1, arr2);
        System.out.println(res);

    }
}
