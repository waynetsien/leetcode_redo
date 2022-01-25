/**
 * 单链表构建队列和栈
 */
public class LinkedListToQueueAndStack {

    public static class Node<V> {
        private V value;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
            this.next = null;
        }
    }

    // Queue
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(V value) {
            Node<V> curNode = new Node<>(value);
            if (tail != null) {
                tail.next = curNode;
                tail = curNode;
            } else {
                head = curNode;
                tail = curNode;
            }
            size++;
        }

        public V pop() {
            V returnVal = null;
            if (head != null) {
                returnVal = head.value;
                head = head.next;
                size--;
            } else {
                tail = null;
            }
            return returnVal;
        }

        public V peek() {
            return head != null ? head.value : null;
        }
    }

    // Stack
    public static class MyStack<V> {
        private Node<V> head;
        private int size;

        public MyStack() {
            this.head = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(V value) {
            Node<V> curNode = new Node<>(value);
            if (head != null) {
                curNode.next = head;
                head = curNode;
            } else {
                head = curNode;
            }
            size++;
        }

        public V pop() {
            V returnVal = null;
            if (head != null) {
                returnVal = head.value;
                head = head.next;
                size--;
            }
            return returnVal;
        }

        public V peek() {
            return head != null ? head.value : null;
        }
    }
}
