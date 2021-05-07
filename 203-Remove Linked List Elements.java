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
    // solution 1 递归思想 从后往前每一个元素与val值比较 推荐
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    // solution 2 从前往后每一个元素和val值进行比较
    public ListNode removeElements(ListNode head, int val) {
        // 用于解决链表的前半部分有等于val的情况，一定要从第一个不是val的值开始
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(dummy != null && dummy.next != null) {
            if (dummy.next.val != val) {
                dummy = dummy.next;
            } else {
                dummy.next = dummy.next.next;
            }
        }
        return head;
    }
}