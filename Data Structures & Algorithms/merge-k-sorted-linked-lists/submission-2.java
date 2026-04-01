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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new NodeComparator());
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                heap.offer(node.next);
            }
        }
        return head.next;

    }
}

class NodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b){
        return a.val - b.val;
    }
}


// using heap 