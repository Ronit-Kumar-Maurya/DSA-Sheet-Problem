import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    HashMap<Integer, Node> map = new HashMap<>();
    int limit;

    public LRUCache(int capacity) {
        limit = capacity;

        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node newNode) {
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    void delNode(Node oldNode) {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node oldNode = map.get(key);

            delNode(oldNode);
            map.remove(key);
        }

        if (map.size() == limit) {

            // Delete LRU data
            Node lruNode = tail.prev;

            map.remove(lruNode.key);
            delNode(lruNode);
        }

        Node newNode = new Node(key, value);

        addNode(newNode);
        map.put(key, newNode);
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node ansNode = map.get(key);
        int ans = ansNode.val;

        map.remove(key);
        delNode(ansNode);

        addNode(ansNode);
        map.put(key, ansNode);

        return ans;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */