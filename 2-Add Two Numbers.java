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

    // ============================================================================================================
    /**
     * 以下方法：不需要创建额外的链表，就在长链表的基础上进行修改
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = listLength(l1);
        int len2 = listLength(l2);
        ListNode curLong = len1 >= len2 ? l1 : l2;
        ListNode curShort = curLong == l1 ? l2 : l1;
        ListNode dummy = curLong;
        // lastNode为了最后新的链表的返回
        ListNode lastNode = curLong;
        int curNum = 0;
        int carry = 0;
        // 从短链表开始遍历相加
        while(curShort != null) {
            curNum = curShort.val + curLong.val + carry;
            curLong.val = (curNum % 10);
            carry = curNum / 10;
            lastNode = curLong;
            curLong = curLong.next;
            curShort = curShort.next;
        }
        // 短链表遍历结束后，遍历长链表
        while(curLong != null) {
            curNum = curLong.val + carry;
            curLong.val = (curNum % 10);
            carry = curNum / 10;
            lastNode = curLong;
            curLong = curLong.next;
        }
        // 长链表遍历结束后，如果有carry值，需要新建一个节点，然后连上
        if (carry != 0) {
            lastNode.next = new ListNode(carry);
        }
        return dummy;
    }

    public int listLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    // ============================================================================================================
}