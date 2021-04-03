class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache = new HashMap();
    int size, capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public void addHead(Node node) {
        Node nextNode = head.next;
        node.prev = head;
        node.next = nextNode;
        head.next = node;
        nextNode.prev = node;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void removeTail() {
        Node prevTail = tail.prev;
        remove(prevTail);
        cache.remove(prevTail.key);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            get(key);
        } else {
            Node newNode = new Node(key, value);
            addHead(newNode);
            size++;

            if (size > capacity) {
                removeTail();
                size--;
            }
            cache.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */