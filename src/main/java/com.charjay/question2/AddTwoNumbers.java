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
        //
        Map map = new HashMap();
        ListNode tempNode1=l1;
        ListNode tempNode2=l2;
        int i=0;
        int sum=0;
        int tempValue=0;
        int jinWei=0;
        do{
            sum+=tempValue+(tempNode1.val+tempNode2.val)%10+jinWei;//求余数
            tempValue=(tempNode1.val+tempNode2.val)/10;//求进位数

            jinWei=jinWei*10;
            map.put(i,tempNode1.val+tempNode2.val);
            i++;
            tempNode1=tempNode1.next;
            tempNode2=tempNode2.next;
        }while (tempNode1!=null);


        System.out.println(sum);
        System.out.println(map);
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        node2.next=node1;
        ListNode node3 = new ListNode(3);
        node3.next=node2;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node5.next=node4;
        ListNode node6 = new ListNode(4);
        node6.next=node5;

        ListNode ret = new AddTwoNumbers().addTwoNumbers(node3, node6);
        System.out.println(ret);
    }
}
