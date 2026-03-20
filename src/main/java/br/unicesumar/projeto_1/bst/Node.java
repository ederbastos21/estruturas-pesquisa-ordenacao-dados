package br.unicesumar.projeto_1.bst;

public class Node {
    int value;
    Node left;
    Node right;

    public Node (int value){
        this.value = value;
        left = null;
        right = null;
    }

    public void printTree(){
        System.out.println("==============================================");
        System.out.println("valor do nó atual: " + this.value);

        if (this.left != null){
            System.out.println("valor do filho esquerdo: " + this.left.value);
        }

        if (this.right != null){
            System.out.println("valor do filho direito: " + this.right.value);
        }
        System.out.println("==============================================");
    }
}
