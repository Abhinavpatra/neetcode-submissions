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
        // 0, n-1, 1, n-2, 2, n-3
        
        // length = 7 : 0 6 1 5 2 4 3
        // length = 8 : 0 8 1 7 2 6 3 5 4
        // length = 9 : 0 9 1 8 2 7 3 6 4 5
        List<Integer> res= new ArrayList<>();

        int count = 0;
        ListNode temp = head;
        while(temp != null){
            res.add(temp.val);
            count++;
            temp = temp.next;
        }
        
        ListNode temp2 = head;
        int index = 0;
        while(temp2 != null){
            temp2.val = res.get(index);
            temp2 = temp2.next;
            if(temp2 == null) break;

            temp2 = temp2.next;            
            index++;
        }

        ListNode temp3 = head.next;
        count--;
        while(temp3 != null){
            temp3.val = res.get(count);
            temp3 = temp3.next;
            if(temp3 == null) break;
            temp3 = temp3.next;
            count--;
        }

    }
}
