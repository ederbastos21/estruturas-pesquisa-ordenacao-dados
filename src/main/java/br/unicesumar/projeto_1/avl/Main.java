package br.unicesumar.projeto_1.avl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree avl = new AVLTree();

        int choice = -1;
        int value;

        do {
            try {
                System.out.println("\n1- Adicionar nó // 2- Procurar valor de nó // 3- Calcular altura // 4- Remover nó // 5- Mostrar arvore em ordem crescente // 0- Sair");
                System.out.print("Escreva sua ação: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.print("Insira o valor do nó: ");
                        value = scanner.nextInt();
                        avl.insert(value);
                        break;

                    case 2:
                        System.out.print("Insira o valor que você quer procurar: ");
                        break;

                    case 3:
                        break;

                    case 4:
                        System.out.print("Insira o valor do nó que você quer remover: ");
                        break;

                    case 5:
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