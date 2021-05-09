class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> newList = new LinkedList<>();
        ListNode newHead = new ListNode(0);
        ListNode curNode = newHead;

        while (head != null) {
            newList.add(head.val);
            head = head.next;
        }

        reverse(newList, left - 1, right - 1);

        for (int i = 0; i < newList.size(); i++) {
            curNode.next = new ListNode(newList.get(i));
            curNode = curNode.next;
        }

        return newHead.next;
    }

    private void reverse(List<Integer> list, int i, int j) {
        while (i < j) {
            int temp = list.get(i);
            list.set(i++, list.get(j));
            list.set(j--, temp);
        }
    }
}