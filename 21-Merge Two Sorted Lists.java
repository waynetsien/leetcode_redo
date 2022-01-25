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
    // Recursion 递归的思想
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 迭代，遍历两个list，找出最小的放入新的list中，剩余的则直接追加到后面
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), curNode = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // ===============================================================================================================
    /**
     * 不用递归的思想，直接在两个链表间串联，由于是有序的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        // 定义新链表的头节点
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode pre = head;
        ListNode cur1 = head.next;
        ListNode cur2 = head == l1 ? l2 : l1;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }

        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    // ===============================================================================================================
}