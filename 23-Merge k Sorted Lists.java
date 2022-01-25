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

    /**
     * 依赖最小堆的思想，每次入队列，然后取出其中的值挨个和之前的比较
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        // 创建优先队列，传入一个比较器
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        if (heap.isEmpty()) {
            return null;
        }
       // 先找出最小的节点，作为head节点
        ListNode head = heap.poll();
        ListNode pre = head;
        // 每出来一个节点，就将其下一个节点(不为空)入队列
        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode curNode = heap.poll();
            pre.next = curNode;
            pre = curNode;
            if (curNode.next != null) {
                heap.add(curNode.next);
            }
        }

        return head;
    }

    // 定义一个自定义的ListNode比较器
    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
}