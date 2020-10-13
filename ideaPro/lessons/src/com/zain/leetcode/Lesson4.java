package com.zain.leetcode;

import java.util.ArrayList;
import java.util.List;

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
// 1.将两个数组归并排序
// 2.分奇偶情况 取中值

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
    }
}
