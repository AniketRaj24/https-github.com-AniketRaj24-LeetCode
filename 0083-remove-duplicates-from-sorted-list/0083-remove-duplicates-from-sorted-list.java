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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow.val == fast.val) {
                // Duplicate found, skip it
                fast = fast.next;
            } else {
                // Different value, link and advance slow
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }
        }

        // Cut off any remaining duplicates after the last unique node
        slow.next = null;

        return head;
    }
}