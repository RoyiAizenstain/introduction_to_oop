package assignment9;

public class Map<K extends Comparable<K>, V> {
    private final BinarySearchTree<Entry<K, V>> bst;

    public Map() {
        bst = new BinarySearchTree<>();
    }

    public boolean add(K key, V value) {
        return bst.add(new Entry<>(key, value));
    }

    public V get(K key) {
        Entry<K, V> entry = bst.get(new Entry<>(key, null));
        return entry != null ? entry.getValue() : null;
    }

    public int size() {
        return bst.size();
    }

    public boolean contains(K key) {
        return bst.contains(new Entry<>(key, null));
    }

    public static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(Entry<K, V> other) {
            return this.key.compareTo(other.getKey());
        }
    }
}
