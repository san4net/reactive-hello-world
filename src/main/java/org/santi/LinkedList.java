package org.santi;

public class LinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode rev( ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode head =  rev(node.next);
        // take next node
        ListNode nextNode = node.next;
        //break the link
        node.next = null;
        nextNode.next = node;
        // return the head node
        return head;

    }

    private ListNode reverseIterative(ListNode head){
        if(head == null) return null;
         ListNode cur = head;
         ListNode prev = null;
         ListNode next = null;

         while(cur != null){
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
         }
         return prev;
    }
}
