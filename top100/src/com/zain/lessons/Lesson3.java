package com.zain.lessons;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/14 - 10 - 14 - 12:43
 * @Description: com.zain.lessons
 * @version: 1.0
 */
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lesson3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int MAX_CHAR_NUM = 256;
        int[] map = new int[MAX_CHAR_NUM];
        //初始化
        for (int i = 0; i < MAX_CHAR_NUM; i++) {
            map[i] = -1;
        }
        int result    = 0;
        int preStartIndex  = -1;//记录前一位位置结尾的最长字串 开始坐标
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int index = Math.max(map[curChar], preStartIndex) ;
            result = Math.max(result, i - index);
            preStartIndex = index;
            map[curChar] = i;
        }
        //
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lesson3().lengthOfLongestSubstring("abcabcbb"));
    }
}
