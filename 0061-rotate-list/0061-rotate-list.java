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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode last = head;
        int n = 1;
        while(last.next != null){
            n++;
            last = last.next;
        } 
        k = k % n;
        if(k == 0) return head;
        int count = 1;
        ListNode t = head; // here t = (n-k), 5-2 = 3 is the last node after rotate by k = 2;
        while(t != null){
            if(count == (n-k)){
                break;
            }
                count++;
                t = t.next;
            }
            last.next = head; //last node ko first se jod do
            ListNode result = t.next; //t = (n-k), t.next = (n-k+1) yhe new head hai
            t.next = null; //t.next ab result me store hogya tho uska next null krdo kyuki wo ab last node h 
            return result;
    }
}