package br.unicesumar.projeto_1.rubro_negra;

public class Node {
    int key;
    boolean isRed; //true = Rubro, false = Negro
    Node left;
    Node right;
    Node parent; //ponteiro ao pai

    public Node(int key) {
        this.key = key;
        this.isRed = true; //todo novo no eh rubro por padrao
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
