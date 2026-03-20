package br.unicesumar.projeto_1.bst;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Node root = new Node (10);

        System.out.println("root: " + root.value);
        while (true){
            System.out.print("Adicionar valor do nó: // 0 para sair");
            int escolha = scanner.nextInt();
            int valor = 25;
            Node atual = root;

            System.out.println(atual.value);

            if (escolha == 0){
                break;
            }

            while (true){
                if (escolha < atual.value && atual.left == null){
                    atual.left = new Node (escolha);
                    atual.printTree();
                    break;
                } else if (escolha > atual.value && atual.right == null){
                    atual.right = new Node (escolha);
                    atual.printTree();
                    break;
                } else if (escolha == atual.value) {
                    //obs. vi em fontes na internet que algoritmos bst podem ou nao considerar duplicatas sem comprometer a ideia de arvores binarias,
                    //e nao achei nada no documento do trabalho, portanto, eu considerei nao incluir valores duplicados.
                    System.out.println("Valor já existe, não será inserido.");
                    break;
                }
                else {
                    System.out.println("nenhum nó disponivel, avançando nivel da arvore");
                    if (escolha > atual.value){
                        atual = atual.right;
                        atual.printTree();
                    } else if (escolha < atual.value){
                        atual = atual.left;
                        atual.printTree();
                    }
                }
            }
        }
    }
}
