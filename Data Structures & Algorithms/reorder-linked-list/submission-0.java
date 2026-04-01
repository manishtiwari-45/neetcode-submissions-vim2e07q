/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;


        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null; 

        ListNode prev = null;
        ListNode curr = secondHalf;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode firstHalf = head;
        ListNode reversedHalf = prev;

        while (reversedHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = reversedHalf.next;

            firstHalf.next = reversedHalf;
            reversedHalf.next = temp1;

            firstHalf = temp1;
            reversedHalf = temp2;
        }
    }
}
