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
     void reverse(ListNode left, int times){
        ListNode curr = left;
        ListNode prev = null;
        while(curr != null && times-- > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return;
     } 
    public ListNode reverseKGroup(ListNode head, int k) {
          if(head == null) return null;
        ListNode left = head;
        ListNode res = null;
        ListNode prevLeft = null;
        ListNode right;
        int size = k;

        while(left != null){
            right = left;
            for(int i = 0; i < size-1; i++){
                if(right == null) break;
                right = right.next;
            }
            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left, size);
                left.next = nextLeft;
                if(prevLeft != null){
                    prevLeft.next = right;
                }
                if(res == null){
                    res = right;
                }
                prevLeft = left;
                left = nextLeft;
            }
            else{
                if(prevLeft != null){
                    prevLeft.next = left;
                }
                if(res == null){
                    res = left;
                }
                break;
            }
        }
        return res;
    }
}