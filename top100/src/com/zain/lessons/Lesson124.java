package com.zain.lessons;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/27 - 10 - 27 - 23:57
 * @Description: com.zain.lessons
 * @version: 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Lesson124 {
    public int minVal = 0;
    public int oneSideMax(TreeNode node){
        if(node == null)
            return 0;
        //int val  = node.val;
        int left = Math.max(0, oneSideMax(node.left));
        int right = Math.max(0, oneSideMax(node.right));
        minVal = Math.max(minVal, left+right+node.val);
        return Math.max(right+node.val, left+node.val);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        minVal = Integer.MIN_VALUE;
        oneSideMax(root);
        return minVal;
    }
}
