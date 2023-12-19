package org.example;

public class DesignSingleTable {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);              // 返回 3
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val=val;
    }
}
/**
 * 单链表中的节点应该具备两个属性：val 和 next 。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 实现 MyLinkedList 类：
 * 1.MyLinkedList() 初始化 MyLinkedList 对象。
 * 2.int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * 3.void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * 4.void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * 5.void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
 *   如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * 6.void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
class MyLinkedList {
    //链表长度
    int size;
    //虚拟头节点
    ListNode head;

    //初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index > size - 1 || index < 0){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.next.val;
    }

    public void addAtHead(int val) {
        ListNode newListNode = new ListNode(val);
        newListNode.next = head.next;
        head.next = newListNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode TailListNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = TailListNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        //if (index > size - 1){}  错误  若为size - 1，则不能进行末尾的插入
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        //可以添加，size++
        size++;
        ListNode newListNode = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        newListNode.next = cur.next;
        cur.next = newListNode;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0){
            return;
        }
        //可以删除，size--
        size--;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
