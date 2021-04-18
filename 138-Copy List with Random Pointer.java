/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
 * 方法一：使用先copy再提炼的思想
 * 方法二：使用hashMap存放原链表所有节点(key)和新copy的链表所有节点(value)
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // loop1: copy each node and set after original node, link them e.g. 1 2 3 transfer 1 '1' 2 '2' 3 '3'
        Node curNode = head;
        while (curNode != null) {
            Node copyNode = new Node(curNode.val);
            Node next = curNode.next;
            curNode.next = copyNode;
            copyNode.next = next;
            curNode = next;
        }

        // assign random pointers for the copy nodes.
        curNode = head;
        while (curNode != null) {
            if (curNode.random != null) {
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }

        // extract the copy list from head
        curNode = head;
        Node dummy = new Node(0);
        Node newNode = dummy;
        while (curNode != null) {
            newNode.next = curNode.next;
            newNode = newNode.next;
            curNode.next = curNode.next.next;
            curNode = curNode.next;
        }

        return dummy.next;
    }

    /**
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node,Node> map = new HashMap<>();
        Node curNode = head;

        // copy all node
        while (curNode != null) {
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }

        curNode = head;
        // assign next and random pointers
        while (curNode != null) {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }

        return map.get(head);
    }
     */
}