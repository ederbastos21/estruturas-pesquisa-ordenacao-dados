package br.unicesumar.projeto_1.rubro_negra;

public class Node {
    int key;
    boolean isRed; //true = Rubro, false = Negro
    Node left;
    Node right;
    Node parent;

    public Node(int key) {
        this.key = key;
        this.isRed = true;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
