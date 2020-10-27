package com.zain.lessons;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/14 - 10 - 14 - 12:43
 * @Description: com.zain.lessons
 * @version: 1.0
 */
/**
 * @Auther: ZainTan
 * @Date: 2020/10/13 - 10 - 13 - 15:26
 * @Description: com.zain.leetcode
 * @version: 1.0
 */

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//思路:
// 简单解法1.将两个数组归并排序,分奇偶情况 取中值
// 解法2.(优化),不用归并,只要遍历比较取到中间位置即可
class Solution2 {
    public int[] find2NumByOverIndex(int[] num1, int[] num2, int overIndex){

        int preNum = -1;
        int curNum = -1;

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i <= overIndex; i++) {
            boolean useNum1 = false;
            if((index1 < num1.length) && (index2 >= num2.length || num1[index1] < num2[index2])){//index1
                preNum = curNum;
                curNum = num1[index1];
                index1++;
            }else{
                preNum = curNum;
                curNum = num2[index2];
                index2++;
            }
        }
        return new int[]{preNum, curNum};
    }



    public  double findMedianSortedArrays(int[] num1, int[] num2){
        if(num1.length == 0 && num2.length == 0){
            return 0.0d;
        }
        int len = num1.length + num2.length;
        int []result = find2NumByOverIndex(num1,num2, len/2);
        if(len % 2 == 0){
            return (result[0] + result[1])/2.0;
        }else{
            return result[1];
        }
    }
}
public class Lesson4 {
    public int[] mergeArrays(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;
        while (resultIndex < result.length ){

            if(index2 >= nums2.length){
                result[resultIndex] = nums1[index1];
                index1++;
                resultIndex++;
                continue;
            }
            if(index1 >= nums1.length){
                result[resultIndex] = nums2[index2];
                index2++;
                resultIndex++;
                continue;
            }

            if(nums1[index1] < nums2[index2]){
                result[resultIndex] = nums1[index1];
                index1++;
                resultIndex++;
            }else{
                result[resultIndex] = nums2[index2];
                index2++;
                resultIndex++;
            }

        }
        return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0.0d;
        }
        int[] mergedArr = mergeArrays(nums1,nums2);
        if(mergedArr.length % 2 == 0){
            int index = mergedArr.length/2;
            return (mergedArr[index] + mergedArr[index-1])/2.0;
        }else{
            return mergedArr[mergedArr.length/2];
        }
    }


    public static void main(String[] args) {
        System.out.println(new Lesson4().findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(new Solution2().findMedianSortedArrays(new int[]{}, new int[]{1}));

        //StringBuffer
    }
}