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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode curr = head;
        ListNode prev = null;
        int i = 1; // i is the first index here

        while(i < left){
            prev = curr;
            curr = curr.next;
            i++;
        }
// keeping the previous part 
        ListNode beforeLeft = prev;
        ListNode leftNode = curr;

        // now prev and curr are at the right positions
        while(i <= right){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
            i++;
        }

// this part does not makes sense
        if(beforeLeft != null) beforeLeft.next = prev;
        else head = prev;

        leftNode.next = curr;

        return head;

    }
}






