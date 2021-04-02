class LFUCache {

    class Node {
        int key, value;
        Node prev, next;
        int cnt;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int len;

        public DLList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void addHead(Node node) {
            Node next = head.next;
            node.next = next;
            node.prev = head;
            head.next = node;
            next.prev = node;
            map.put(node.key, node);
            len++;
        }

        public void remove(Node node) {
            Node preNode = node.prev;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.prev = preNode;
            map.remove(node.key);
            len--;
        }

        public void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    private Map<Integer, Node> map;
    private Map<Integer, DLList> freq;
    int size, capacity;
    int maxFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int prevFreq = node.cnt;
            DLList  prevList = freq.get(prevFreq);
            prevList.remove(node);

            int curFreq = prevFreq + 1;
            maxFreq = Math.max(maxFreq, curFreq);

            DLList curList = freq.getOrDefault(curFreq, new DLList());
            curList.addHead(node);
            node.cnt++;

            freq.put(prevFreq, prevList);
            freq.put(curFreq, curList);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.get(key) != null) {
            map.get(key).value = value;
            get(key);
        } else {
            Node node = new Node(key, value);
            DLList curList = freq.getOrDefault(1, new DLList());
            curList.addHead(node);
            size++;

            if (size > capacity) {
                if (curList.len > 1) {
                    curList.removeTail();
                } else {
                    for (int i = 2; i <= maxFreq; i++) {
                        if (freq.get(i) != null && freq.get(i).len > 0) {
                            freq.get(i).removeTail();
                            break;
                        }
                    }
                }
                size--;
            }
            freq.put(1,curList);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */