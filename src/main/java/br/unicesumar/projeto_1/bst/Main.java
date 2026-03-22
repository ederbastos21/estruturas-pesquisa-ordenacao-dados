package br.unicesumar.projeto_1.bst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice;
        int value;
        System.out.print("qual o valor da raiz? ");
        value = scanner.nextInt();
        Node root = new Node(value);

        System.out.println("Raiz: " + root.value);
        do {
            Node current = root;

            System.out.println("\n1- Adicionar nó // 2- Procurar valor de nó // 3- Calcular altura // 4- Remover nó // 5- Mostrar arvore em ordem crescente // 0- Sair");
            System.out.print("Escreva sua ação: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.print("Insira o valor do nó: ");
                    value = scanner.nextInt();
                    bst.insert(value, current);
                    break;
                case 2:
                    System.out.print("Insira o valor que você quer procurar: ");
                    value = scanner.nextInt();
                    Node foundNode = bst.search(value, current);
                    if (foundNode != null) {
                        System.out.println("Valor " + bst.search(value, current).value + " encontrado.");
                    } else {
                        System.out.println("Valor " + value + " não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println(bst.calculateHeight(current));
                    break;
                case 4:
                    System.out.print("Insira o valor do nó que você quer remover: ");
                    value = scanner.nextInt();
                    root = bst.remove(root, value);
                    if (root == null){
                        System.out.print("qual o valor da nova raiz? ");
                        value = scanner.nextInt();
                        root = new Node(value);
                        System.out.println("Raiz: " + root.value);
                    }
                    break;
                case 5:
                    bst.printTree(current);
                    break;
                default:
                    System.out.println("Insira um valor válido.");
            }
        } while (choice != 0);
    }
}