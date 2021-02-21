/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

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
        ListNode head = new ListNode();
        mergeKNodes(head, lists);
        return head.next;
    }
    
    private void mergeKNodes(ListNode node, ListNode[] lists) {
        boolean allNull = true;
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                allNull = false;
                break;
            }
        }
        if (allNull) {
            return;
        }
        //find min value
        int index = 0; 
        int min = Integer.MAX_VALUE;
        for (int i=0; i<lists.length; i++) {
            if ((lists[i] != null) && (lists[i].val <= min)) {
                index = i;
                min = lists[i].val;
            }
        }
        
        //add it to list and advance
        node.next = lists[index];
        lists[index] = lists[index].next;
        
        //call recursive method
        mergeKNodes(node.next, lists);
    }
}