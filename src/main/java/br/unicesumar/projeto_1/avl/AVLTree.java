package br.unicesumar.projeto_1.avl;

public class AVLTree {
    Node root;

    public int height(Node node){
        if (node == null){
            return 0;
        } else {
            return node.height;
        }
    }
}
