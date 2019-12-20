package Algorithm;

/**
 * Created by zengyouzu on 2019/12/20.
 * 给定一个字符串，找出其没有重复字符的最大子序列的长度。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int head = 0, index = 0, maxLen = 0;
        boolean[] exist = new boolean[256];
        for (boolean e : exist)
            e = false;
        while (index < len) {
            if (exist[s.charAt(index)]) {
                maxLen = Math.max(maxLen, index - head);
                while (s.charAt(head) != s.charAt(index)) {
                    exist[s.charAt(head)] = false;
                    head++;
                }
                head++;
                index++;
            } else {
                exist[s.charAt(index)] = true;
                index++;
            }
        }
        maxLen = Math.max(maxLen, len - head);
        System.out.println("最长无重复字符串长度为:" + maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("1548427669945");
    }
}
