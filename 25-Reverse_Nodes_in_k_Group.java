/**
 * K个节点组内逆序调整
 *
 * @source https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 此处的目的是要返回最后全部反转过后的链表
        head = end;
        // 此时，第一个K组get到了，开始反转
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            // 重复上面的操作，找出下一个K个节点的组，然后反转
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            // 注意需要调整每个组的最后一个节点的next指针位置，要指向下一个被反转后的组的头节点
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    // 寻找每K个节点一组的，每组最后一个节点的位置，用于后面的链表反转
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    // 反转K个节点内部的链表结构
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode curNode = start;

        while (curNode != end) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        start.next = end;
    }
}
