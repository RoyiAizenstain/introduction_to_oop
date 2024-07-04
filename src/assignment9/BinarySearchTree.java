package assignment9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

// This class represents a binary search tree.
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    public BinarySearchTree() {
        this.root = null;
    }

    // Get the size of the tree
    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            // Recursively calculate the size of the left and right subtrees
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

    public Node<T> getRoot() {
        return this.root;
    }

    // Check if the tree contains a value
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        // Compare the value to the current node
        int cm = value.compareTo(node.getValue());
        if (cm < 0) {
            return contains(node.getLeft(), value);
        } else if (cm > 0) {
            return contains(node.getRight(), value);
        } else {
            return true;
        }
    }

    public T get(T value) {
        return get(root, value);
    }

    private T get(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        // Compare the value to the current node
        int cm = value.compareTo(node.getValue());
        if (cm < 0) {
            return get(node.getLeft(), value);
        } else if (cm > 0) {
            return get(node.getRight(), value);
        } else {
            return node.getValue();
        }
    }

    // Get an iterator for the tree
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    // Add a value to the tree
    public boolean add(T value) {
        return add(root, value);
    }

    private boolean add(Node<T> node, T value) {
        // If the tree is empty, add the value as the root
        if (node == null) {
            root = new Node<>(value);
            return true;
        }
        // Compare the value to the current node
        int cm = value.compareTo(node.getValue());
        if (cm < 0) {
            // If the value is less than the current node, add it to the left subtree
            if (node.getLeft() == null) {
                node.left = new Node<>(value);
                return true;
            } else {
                return add(node.getLeft(), value);
            }
        } else if (cm > 0) {
            // If the value is greater than the current node, add it to the right subtree
            if (node.getRight() == null) {
                node.right = new Node<>(value);
                return true;
            } else {
                return add(node.getRight(), value);
            }
        } else {
            return false;
        }
    }

    private Node<T> root;

    public static class Node<T> {
        // Constructor
        Node(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        // Getters
        public Node<T> getRight() {
            return right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public T getValue() {
            return value;
        }

        // Setters
        private Node<T> right;
        private Node<T> left;
        private T value;
    }

    public static class InOrderIterator<T> implements Iterator<T> {
        // Constructor
        public InOrderIterator(Node<T> root) {
            this.stack = new Stack<>();
            this.current = root;
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Get the next element
        public T next() {
            // If there is no next element, throw an exception
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> node = stack.pop();
            // If the node has a right child, traverse to the leftmost node of the right child
            current = node.getRight();
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            return node.getValue();
        }

        private Stack<Node<T>> stack;
        private Node<T> current;
    }
}
