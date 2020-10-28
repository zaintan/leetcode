package com.zain.lessons;

import java.util.HashMap;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/28 - 10 - 28 - 17:31
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */

/*
根据一棵树的中序遍历与后序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        中序遍历 inorder = [9,3,15,20,7]
        后序遍历 postorder = [9,15,7,20,3]
        返回如下的二叉树：

        3
        / \
        9  20
        /  \
        15   7

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Lesson106 {


    public TreeNode process(int[] inorder,int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer,Integer> helpMap){
        if(pstart > pend)
            return null;
        if(pstart == pend)
            return new TreeNode(postorder[pend]);

        int curNodeIndex = helpMap.get(postorder[pend]);

        int rightCount = 0;
        int rightIndex = -1;
        for (int i = pend-1; i >= pstart; i--){
            int value = postorder[i];
            if(helpMap.get(value) > curNodeIndex){
                rightCount++;
                rightIndex = i;
            }else{
                break;
            }
        }

        TreeNode node = new TreeNode(postorder[pend]);
        if(rightCount == 0) {
            node.right = null;
            node.left  = process(inorder,istart,iend,postorder,pstart,pend-1,helpMap);
        }
        else {
            node.right = process(inorder, istart, iend, postorder, rightIndex, pend - 1, helpMap);
            node.left  = process(inorder,istart,iend,postorder,pstart,rightIndex-1,helpMap);
        }
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)
            return null;

        HashMap<Integer,Integer> inorderIndexMap = new HashMap<Integer,Integer>();
        for (int i = 0 ; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return process(inorder, 0 , inorder.length-1, postorder, 0, postorder.length-1, inorderIndexMap);
    }

    public static void main(String[] args) {
        TreeNode node = new Lesson106().buildTree(new int[]{2,1},new int[]{2,1});
        TreeNode node2 = new Lesson106().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        TreeNode node3 = null;//
    }
}
