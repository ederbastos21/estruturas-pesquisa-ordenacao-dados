package br.unicesumar.projeto_1.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    Node root;

    public int calculateHeight(Node node){
        if (node == null){
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int height (Node node){
        if (node == null){
            return 0;
        } else {
            return node.height;
        }
    }

    public Node rotateLeft (Node node){
        Node temp = node.right;
        Node temp2 = temp.left;

        temp.left = node;
        node.right = temp2;

        updateHeight(node);
        updateHeight(temp);
        return temp;
    }

    public Node rotateRight (Node node){
        Node temp = node.left;
        Node temp2 = temp.right;

        temp.right = node;
        node.left = temp2;

        updateHeight(node);
        updateHeight(temp);
        return temp;
    }

    public void updateHeight (Node node){
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    public int getBalanceFactor (Node node){
        if (node == null){
            return 0;
        } else {
            return height(node.left) - height(node.right);
        }
    }

    public Node search(int key){
        Node current = root;

        while (current != null) {
            if (current.key == key) {
                return current;
            }

            if (key > current.key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return null;
    }
    public void insert(int key){
        root = insert (root, key);
    }

    public Node insert (Node node, int key){
        if (node == null){
            return new Node(key);
        }

        if (key < node.key){
            node.left = insert(node.left, key);
        } else if (key > node.key){
            node.right = insert (node.right, key);
        } else {
            return node;
        }

        updateHeight(node);

        int balance = getBalanceFactor(node);

        //left-left
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        //right-right
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        //left-right
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        //right-left
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void remove(int value){
        this.root = remove(this.root, value);
    }

    public void printTree(){
        printTree(this.root);
    }

    private void printTree(Node current){
        if (current == null)
            return;
        printTree(current.left);
        System.out.print(current.key + " ");
        printTree(current.right);
    }

    public void printByLevel() {
        if (root == null) return;

        int height = calculateHeight(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = (int) Math.pow(2, height) - 1;

        for (int level = 0; level < height; level++) {
            int levelSize = queue.size();

            int spaces = maxWidth / (int) Math.pow(2, level + 1);

            printSpaces(spaces);

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current == null) {
                    System.out.print("n");
                    queue.add(null);
                    queue.add(null);
                } else {
                    System.out.print(current.key);
                    queue.add(current.left);
                    queue.add(current.right);
                }

                printSpaces(spaces * 2 + 1);
            }

            System.out.println();
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.key) {
            node.left = remove(node.left, value);
        }
        else if (value > node.key) {
            node.right = remove(node.right, value);
        }
        else {
            // folha
            if (node.left == null && node.right == null) {
                return null;
            }

            // um filho
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // dois filhos
            Node successor = smallestValue(node.right);
            node.key = successor.key;
            node.right = remove(node.right, successor.key);
        }

        updateHeight(node);

        int balance = getBalanceFactor(node);

        // left-left
        if (balance > 1 && getBalanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        // left-right
        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // right-right
        if (balance < -1 && getBalanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        // right-left
        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node smallestValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
