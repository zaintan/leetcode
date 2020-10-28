package com.zain.lessons;

import java.util.*;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/28 - 10 - 28 - 22:45
 * @Description: com.zain.lessons
 * @version: 1.0
 */

/*
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Lesson116 {
    //public List<List<Node>> l = null;


    //迭代解法
    public Node connect2(Node root) {
        if(root == null)
            return root;
        LinkedList<Node> que = new LinkedList<Node>();
        que.add(root);
        while (!que.isEmpty()){
            //串联
            for(int i = 0;i < que.size()-1;i++){
               que.get(i).next = que.get(i+1);
            }

            int i = que.size();
            while (i > 0){
                Node n = que.remove();
                if(n.left != null)
                    que.add(n.left);
                if(n.right != null)
                    que.add(n.right);
                i--;
            }
        }
        return root;
    }
    //递归解法
    public void dfs(Node node){
        if(node == null)
            return;

        Node left = node.left;
        Node right = node.right;

        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(node.left);
        dfs(node.right);
    }
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
}
