package br.unicesumar.projeto_1.bst;

public class BinarySearchTree {
    public void insert(int choice, Node current){
        while (true) {
            if (choice < current.value && current.left == null) {
                current.left = new Node(choice);
                current.printCurrentNode();
                break;
            } else if (choice > current.value && current.right == null) {
                current.right = new Node(choice);
                current.printCurrentNode();
                break;
            } else if (choice == current.value) {
                System.out.println("Valor já existe, não será inserido.");
                break;
            } else {
                System.out.println("Nenhum nó disponível, avançando nível da árvore.");
                if (choice > current.value) {
                    current = current.right;
                    current.printCurrentNode();
                } else if (choice < current.value) {
                    current = current.left;
                    current.printCurrentNode();
                }
            }
        }
    }

    public Node search(int value, Node current){
        while (true){
            if (value < current.value && current.left != null){
                current = current.left;
            } else if (value > current.value && current.right != null){
                current = current.right;
            } else if (current.value == value){
                return current;
            } else {
                return null;
            }
        }
    }

    public int calculateHeight(Node current){
        if (current == null){
            return 0;
        }
        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void printTree(Node current){
        if (current == null) return;
        printTree(current.left);
        System.out.print(current.value + " ");
        printTree(current.right);
    }

    public Node smallestValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node remove(Node current, int value) {
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
}