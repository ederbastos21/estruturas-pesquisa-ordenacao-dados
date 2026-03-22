package br.unicesumar.projeto_1.bst;

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

    public void printTree(){
        printTree(this.root);
    }

    private void printTree(Node current){
        if (current == null) return;
        printTree(current.left);
        System.out.print(current.value + " ");
        printTree(current.right);
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
}