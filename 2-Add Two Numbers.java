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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while(l1 != null) {
            sum = l1.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            node = node.next;
        }

        while(l2 != null) {
            sum = l2.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            node = node.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return dummy.next;
    }
}