public class MyHashMap {

    private static class Node {

        private int key;
        private int value;
        private Node next;

        Node(int key, int value, MyHashMap.Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    private static final int BUCKET_COUNT = 1000;

    private final Node[] buckets;

    public MyHashMap() {
        this.buckets = new Node[BUCKET_COUNT];
    }

    public void put(int key, int value) {
        int hash = hashCode(key);
        Node previous = null;
        Node node = buckets[hash];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            previous = node;
            node = node.next;
        }
        if (previous != null) {
            previous.next = new Node(key, value, null);
        } else {
            buckets[hash] = new Node(key, value, null);
        }
    }

    public int get(int key) {
        int pos = hashCode(key);
        Node node = buckets[pos];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hashCode(key);
        Node previous = null;
        Node node = buckets[hash];
        while (node != null) {
            if (node.key == key) {
                if (previous != null) {
                    previous.next = node.next;
                } else {
                    buckets[hash] = node.next;
                }
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    private static int hashCode(int key) {
        return key % BUCKET_COUNT;
    }

}
