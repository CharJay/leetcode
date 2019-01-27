package com.charjay.question2;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode1=l1;
        ListNode tempNode2=l2;
        int tempValue=0;
        int jin=0;
        int yu=0;

        ListNode sumNode = null;
        ListNode retNode = null;
        do{
            if(tempNode1 == null){
                tempNode1 = new ListNode(0);
            }
            if(tempNode2 == null){
                tempNode2 = new ListNode(0);
            }
            yu = (tempNode1.val + tempNode2.val + jin) % 10;//求余数
            tempValue = yu;// + jin + jinTemp
            jin=(tempNode1.val+tempNode2.val + jin)/10;//求进位数

            //重新计算

            if(sumNode == null){
                sumNode = new ListNode(tempValue);
                retNode = sumNode;
            }else {
                while (sumNode.next !=null){
                    sumNode = sumNode.next;
                }
                sumNode.next = new ListNode(tempValue);
            }
            tempNode1=tempNode1.next;
            tempNode2=tempNode2.next;
        }while (tempNode1!=null || tempNode2!=null);

        if(jin>0){
            while (sumNode.next !=null){
                sumNode = sumNode.next;
            }
            sumNode.next = new ListNode(jin);
        }

        return retNode;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(4);
//        node2.next=node1;
//        ListNode node3 = new ListNode(3);
//        node3.next=node2;
//
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        node5.next=node4;
//        ListNode node6 = new ListNode(4);
//        node6.next=node5;


        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        node2.next=node1;
        ListNode node3 = new ListNode(8);
        node3.next=node2;

        ListNode node4 = new ListNode(2);


        ListNode ret = new AddTwoNumbers().addTwoNumbers(node3, node4);
        System.out.print(ret.val+"->");
        while (ret.next !=null){
            System.out.print(ret.next.val+"->");
            ret = ret.next;
        }
//        System.out.println(ret.val+"->"+ret.next.val+"->"+ret.next.next.val);
    }
}
