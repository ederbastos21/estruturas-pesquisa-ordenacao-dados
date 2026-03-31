package br.unicesumar.projeto_1.avl;

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

        return temp;
    }

    public Node rotateRight (Node node){
        Node temp = node.left;
        Node temp2 = temp.right;

        temp.right = node;
        node.left = temp2;

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

    public Node search (int key){
        Node current = root;

        while (true) {
            if (current.key == key) {
                return current;
            }

            if (key > current.key && current.right != null) {
                current = current.right;
            } else if (key < current.key && current.left != null){
                current = current.left;
            } else {
                return null;
            }

        }
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

        return node;
    }
}
