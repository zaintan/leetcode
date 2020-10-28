package com.zain.lessons;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/28 - 10 - 28 - 14:31
 * @Description: com.zain.lessons
 * @version: 1.0
 */
/*
给定一个二叉树，检查它是否是镜像对称的。

         

        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
        / \
        2   2
        / \ / \
        3  4 4  3
         

        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
        / \
        2   2
        \   \
        3    3

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/symmetric-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

public class Lesson101 {
    public boolean isEqual(TreeNode l, TreeNode r){
        if(  l == null && r == null)
            return true;
        if( l == null || r == null)
            return false;
        if(l.val != r.val)
            return false;
        return isEqual(l.left,r.right) && isEqual(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isEqual(root.left, root.right);
    }
}
