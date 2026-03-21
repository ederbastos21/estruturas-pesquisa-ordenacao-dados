package br.unicesumar.projeto_1.bst;

public class BinarySearchTree {
    public void insert(int escolha, Node atual){
        while (true) {
            if (escolha < atual.value && atual.left == null) {
                atual.left = new Node(escolha);
                atual.printTree();
                break;
            } else if (escolha > atual.value && atual.right == null) {
                atual.right = new Node(escolha);
                atual.printTree();
                break;
            } else if (escolha == atual.value) {
                //obs. vi em fontes na internet que algoritmos bst podem ou nao considerar duplicatas sem comprometer a ideia de arvores binarias,
                //e nao achei nada no documento do trabalho, portanto, eu considerei nao incluir valores duplicados.
                System.out.println("Valor já existe, não será inserido.");
                break;
            } else {
                System.out.println("nenhum nó disponivel, avançando nivel da arvore");
                if (escolha > atual.value) {
                    atual = atual.right;
                    atual.printTree();
                } else if (escolha < atual.value) {
                    atual = atual.left;
                    atual.printTree();
                }
            }
        }
    }

    public Node search(int valor, Node atual){
        while (true){
            if (valor < atual.value && atual.left != null){
                atual = atual.left;
            } else if (valor > atual.value && atual.right != null){
                atual = atual.right;
            } else if (atual.value == valor){
                return atual;
            } else {
                return null;
            }
        }
    }

}
