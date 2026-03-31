package br.unicesumar.projeto_1.bst;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public void insert(int value){
        if (root == null){
            this.root = new Node(value);
            return;
        }

        Node current = this.root;

        while (true) {
            if (value < current.value && current.left == null) {
                current.left = new Node(value);
                break;
            } else if (value > current.value && current.right == null) {
                current.right = new Node(value);
                break;
            } else if (value == current.value) {
                System.out.println("Valor já existe, não será inserido.");
                break;
            } else {
                if (value > current.value) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
        }
    }

    public Node search(int value){
        Node current = this.root;

        while (current != null){
            if (value < current.value){
                current = current.left;
            } else if (value > current.value){
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public int calculateHeight(){
        return calculateHeight(this.root);
    }

    private int calculateHeight(Node current){
        if (current == null){
            return -1;
        }
        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void remove(int value){
        this.root = remove(this.root, value);
    }

    private Node remove(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = remove(current.left, value);
        }
        else if (value > current.value) {
            current.right = remove(current.right, value);
        }
        else {
            // folha
            if (current.left == null && current.right == null) {
                return null;
            }

            // um filho
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // dois filhos
            Node successor = smallestValue(current.right);
            current.value = successor.value;
            current.right = remove(current.right, successor.value);
        }

        return current;
    }

    private Node smallestValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printTree(){
        printTree(this.root);
    }
    private void printTree(Node current){
        if (current == null)
            return;
        printTree(current.left);
        System.out.print(current.value + " ");
        printTree(current.right);
    }

    public void printByLevel() {
        if (root == null) return;

        int height = calculateHeight() + 1; // ajuste porque sua altura começa em -1
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = (int) Math.pow(2, height) - 1;

        for (int level = 0; level < height; level++) {
            int levelSize = queue.size();

            int spaces = maxWidth / (int) Math.pow(2, level + 1);

            // espaço inicial
            printSpaces(spaces);

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current == null) {
                    System.out.print("n");
                    queue.add(null);
                    queue.add(null);
                } else {
                    System.out.print(current.value);
                    queue.add(current.left);
                    queue.add(current.right);
                }

                // espaço entre nós
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
}