/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 直接将要删除节点的下一个节点的值覆盖前一个节点的值，然后将下一个节点删除即可
        node.val = node.next.val;
        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
    }
}