package assignment9;

// This class represents a map that stores key-value pairs.
public class Map<K extends Comparable<K>, V> {
    // The binary search tree
    private final BinarySearchTree<CompEntry<K, V>> bst;

    // Constructor
    public Map() {
        bst = new BinarySearchTree<>();
    }

    // Add a key-value pair to the map
    public boolean add(K key, V value) {
        return bst.add(new CompEntry<>(key, value));
    }

    // Get the value associated with a key
    public V get(K key) {
        // Get the entry with the key
        CompEntry<K, V> compEntry = bst.get(new CompEntry<>(key, null));
        return compEntry != null ? compEntry.getValue() : null;
    }

    // Get the size of the map
    public int size() {
        return bst.size();
    }

    // Check if the map contains a key
    public boolean contains(K key) {
        return bst.contains(new CompEntry<>(key, null));
    }

    // This class represents a key-value pair that is comparable by the key
    public static class CompEntry<K extends Comparable<K>, V> implements Comparable<CompEntry<K, V>> {
        // The key and value
        private K key;
        private V value;

        // Constructor
        public CompEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Get the key
        public K getKey() {
            return key;
        }

        // Get the value
        public V getValue() {
            return value;
        }

        // Set the value
        @Override
        public int compareTo(CompEntry<K, V> other) {
            return this.key.compareTo(other.getKey());
        }
    }
}
