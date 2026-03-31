package br.unicesumar.projeto_1.bst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice = -1;
        int value;

        do {
            try {
            System.out.println("\n[1]- Adicionar nó // [2]- Procurar valor de nó // [3]- Calcular altura // [4]- Remover nó // [5]- Mostrar arvore em ordem crescente // [0]- Sair");
            System.out.print("Escreva sua ação: ");
            choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.print("Insira o valor do nó: ");
                        value = scanner.nextInt();
                        bst.insert(value);
                        break;

                    case 2:
                        System.out.print("Insira o valor que você quer procurar: ");
                        value = scanner.nextInt();
                        Node foundNode = bst.search(value);
                        if (foundNode != null) {
                            System.out.println("Valor " + foundNode.value + " encontrado.");
                        } else {
                            System.out.println("Valor " + value + " não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("Altura da árvore: " + bst.calculateHeight());
                        break;

                    case 4:
                        System.out.print("Insira o valor do nó que você quer remover: ");
                        value = scanner.nextInt();
                        bst.remove(value);
                        break;

                    case 5:
                        bst.printTree();
                        System.out.println();
                        break;

                    default:
                        System.out.println("Insira um valor válido.");
                }
            } catch (Exception e){
                System.out.println("erro encontrado " + e);
                scanner.nextLine();
            }

        } while (choice != 0);
    }
}