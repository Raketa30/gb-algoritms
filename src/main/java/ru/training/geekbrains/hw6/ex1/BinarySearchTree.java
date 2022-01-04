package ru.training.geekbrains.hw6.ex1;

import java.util.Stack;

public class BinarySearchTree<V extends Comparable<? super V>> implements ITree<V> {
    private Node<V> root;
    private int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    @Override
    public boolean add(V value) {
        Node<V> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node<V> current = root;
        while (!current.value.equals(value)) {
            if (value.compareTo(current.value) < 0) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    size += 1;
                    return true;
                } else {
                    current = current.leftChild;
                }
            } else if (value.compareTo(current.value) > 0) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    size += 1;
                    return true;
                } else {
                    current = current.rightChild;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.root = null;
        size = 0;
    }

    @Override
    public boolean contains(V value) {
        Node<V> current = root;
        while (!current.value.equals(value)) {
            if (value.compareTo(current.value) < 0) {
                current = current.leftChild;
            } else if (value.compareTo(current.value) > 0) {
                current = current.rightChild;
            }
        }

        return current != null;
    }

    @Override
    public void display() {
        Stack<Node<V>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<V>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<V> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.value);
                    localStack.push(tempNode.leftChild);
                    localStack.push(tempNode.rightChild);
                    if (tempNode.leftChild != null || tempNode.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public V maxValue() {
        return max(root);

    }

    @Override
    public V minValue() {
        return min(root);
    }

    @Override
    public boolean remove(V value) {
        Node<V> current = root;
        Node<V> parent = root;
        while (!current.value.equals(value)) {
            if (value.compareTo(current.value) < 0) {
                parent = current;
                current = current.leftChild;
            } else if (value.compareTo(current.value) > 0) {
                parent = current;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            removeLeafNode(value, parent);

        } else if (current.leftChild == null || current.rightChild == null) {
            removeNodeWithOneLeaf(value, current, parent);

        } else {
            removeNodeWithBothLeaf(value, current, parent);
        }
        size--;
        return true;
    }

    private void removeNodeWithBothLeaf(V value, Node<V> current, Node<V> parent) {
        Node<V> successor = getSuccessor(current);

        if (value.equals(root.value)) {
            root = successor;
        } else if (successor == parent.leftChild) {

        } else {

        }
//        current.value = successor.value;
    }

    private void removeNodeWithOneLeaf(V value, Node<V> current, Node<V> parent) {
        Node<V> child = current.leftChild == null ? current.rightChild : current.leftChild;
        if (root.value.equals(value)) {
            root = child;
        } else if (parent.leftChild.value.equals(value)) {
            parent.leftChild = child;
        } else {
            parent.rightChild = child;
        }
    }

    private void removeLeafNode(V value, Node<V> parent) {
        if (root.value.equals(value)) {
            root = null;
        } else if (parent.leftChild.value.equals(value)) {
            parent.leftChild = null;
        } else {
            parent.rightChild = null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private Node<V> getSuccessor(Node<V> node) {
        Node<V> successorParent = node;
        Node<V> successor = node;
        Node<V> current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    private int height(Node<V> node) {
        return node == null ? 0 : 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private boolean isBalanced(Node<V> node) {
        return (node == null) ||
                isBalanced(node.leftChild) &&
                        isBalanced(node.rightChild) &&
                        Math.abs(height(node.leftChild) - height(node.rightChild)) <= 1;
    }

    private V max(Node<V> root) {
        Node<V> current = root;
        Node<V> last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    private V min(Node<V> root) {
        Node<V> current = root;
        Node<V> last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    static class Node<V> {
        V value;
        Node<V> leftChild;
        Node<V> rightChild;

        public Node(V value) {
            this.value = value;
        }
    }
}
