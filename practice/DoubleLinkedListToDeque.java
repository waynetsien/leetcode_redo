/**
 * 双链表构建双端队列
 */
public class DoubleLinkedListToDeque {

    public static class Node<V> {
        private V value;
        private Node<V> last;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
            this.last = null;
            this.next = null;
        }
    }

    // Queue
    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque() {
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

        public void pushHead(V value) {
            Node<V> curNode = new Node<>(value);
            if (head != null) {
                curNode.next = head;
                head.last = curNode;
                head = curNode;
            } else {
                head = curNode;
                tail = curNode;
            }
            size++;
        }

        public void pushTail(V value) {
            Node<V> curNode = new Node<>(value);
            if (head != null) {
                tail.next = curNode;
                curNode.last = tail;
                tail = curNode;
            } else {
                head = curNode;
                tail = curNode;
            }
            size++;
        }

        public V pollHead() {
            V returnVal = null;
            if (head == null) {
                return returnVal;
            }
            size--;
            returnVal = head.value;
            if (head == tail) {
               head = null;
               tail = null;
            } else {
                head.next.last = null;
            }
            return returnVal;
        }

        public V pollTail() {
            V returnVal = null;
            if (tail == null) {
                return returnVal;
            }
            size--;
            returnVal = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail.last.next = null;
            }
            return returnVal;
        }
    }
}
