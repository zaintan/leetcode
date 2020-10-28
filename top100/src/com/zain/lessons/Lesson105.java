package com.zain.lessons;

import java.util.HashMap;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/28 - 10 - 28 - 19:06
 * @Description: com.zain.lessons
 * @version: 1.0
 */
/*
根据一棵树的前序遍历与中序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：

        3
        / \
        9  20
        /  \
        15   7

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Lesson105 {
    public TreeNode process(int istart, int iend,int[] preorder, int pstart, int pend, HashMap<Integer,Integer> helpMap){
        if(pstart > pend)
            return null;
        if(pstart == pend)
            return new TreeNode(preorder[pend]);

        int curNodeIndex = helpMap.get(preorder[pstart]);
        TreeNode node = new TreeNode(preorder[pstart]);
        node.left = process(istart,curNodeIndex-1, preorder, pstart+1,  pstart + curNodeIndex - istart, helpMap);
        node.right = process(curNodeIndex+1,iend, preorder, pstart+curNodeIndex-istart+1, pend, helpMap );
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || inorder.length != preorder.length || inorder.length == 0)
            return null;

        HashMap<Integer,Integer> inorderIndexMap = new HashMap<Integer,Integer>();
        for (int i = 0 ; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return process(0,inorder.length-1,preorder, 0, preorder.length-1, inorderIndexMap);
    }
}
