package com.zain.leetcode;

import java.util.HashMap;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/12 - 10 - 12 - 22:25
 * @Description: com.zain.leetcode
 * @version: 1.0
 */

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//思路:
// 1.建立一个辅助数据结构HashMap存放键值对<整数值,该值对应的所在数组的下标>
// 2.遍历数组, 检查HashMap中存不存在key:(target - 当前整数值),
//       如果存在说明找到了,返回 找到key对应的值 和 当前下标即可;
//       如果不存在 将键值对<整数值,该值对应的所在数组的下标>插入HashMap中
// (注意是先检查再存)
public class Lesson1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if(numsMap.containsKey(value)){
                return new int[]{numsMap.get(value), i};
            }
            numsMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] result = new Lesson1().twoSum(new int[]{2,7,11,5},9);
        System.out.println(result[0] + "," + result[1]);
    }
}
