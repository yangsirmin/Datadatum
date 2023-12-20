package org.example.table;

public class ReversalTable {
}

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 双指针解法
 */
class Solution7 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;//临时指针，保存下一个节点
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
