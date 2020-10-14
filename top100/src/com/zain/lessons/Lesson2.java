package com.zain.lessons;

/**
 * @Auther: ZainTan
 * @Date: 2020/10/14 - 10 - 14 - 12:43
 * @Description: com.zain.lessons
 * @version: 1.0
 */
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Lesson2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result  = null;//new ListNode();
        ListNode curNode = null;
        int pre = 0;
        do{
            int cur = pre;
            if(l1 != null){
                cur = cur + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                cur = cur + l2.val;
                l2 = l2.next;
            }

            ListNode tempNode = new ListNode();
            tempNode.val = cur%10;
            pre = (cur - tempNode.val)/10;

            if(curNode != null){
                curNode.next = tempNode;
                curNode = tempNode;
            }else{
                result = tempNode;
                curNode = tempNode;
            }
        }while(l1 != null || l2 != null);


        if(pre != 0){
            ListNode tempNode = new ListNode();
            tempNode.val = pre;
            curNode.next = tempNode;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
