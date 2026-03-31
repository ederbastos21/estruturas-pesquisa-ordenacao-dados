package br.unicesumar.projeto_1.bst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice = -1;
        int value;

        System.out.println("Arvore BST");

        do {
            try {
                //obs. na arvore binaria principalmente, a função de mostrar a arvore completa fica absurdamente grande a partir de 6 andares, entao é um recurso experimental
                System.out.println("\n[1]- Adicionar nó \n[2]- Procurar valor de nó \n[3]- Calcular altura \n[4]- Remover nó \n[5]- Mostrar arvore completa (aumenta muito de tamanho a partir de altura > 5) \n[6]- Mostrar arvore em ordem crescente \n[0]- Sair");
                System.out.print("> ");
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
                            bst.printByLevel();
                            System.out.println();
                            break;

                        case 6:
                            System.out.print("\n");
                            bst.printTree();
                            System.out.print("\n");
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