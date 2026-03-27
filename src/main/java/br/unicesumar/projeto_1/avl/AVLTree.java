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

    public void insert (int key){
        Node current = root;
        Node addedNode;
        while (true){
            if (root == null){
                root = new Node (key);
                root.height = calculateHeight(root);
                break;
            } else {
                if (key < current.key && current.left == null){
                    current.left = new Node(key);
                    break;
                } else if (key >= current.key && current.right == null){
                    current.right = new Node (key);
                    break;
                }

                if (key < current.key){
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
    }
}
