package br.unicesumar.projeto_1.avl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree avl = new AVLTree();

        int choice = -1;
        int value;

        System.out.println("Arvore AVL");

        do {
            try {
                //obs. ja na arvore avl, a função de mostrar a arvore completa é melhor ja que ela vai equilibrando sozinha, mas se forem inseridos muitos dados, a função vai ficar gigante tambem
                System.out.println("\n[1]- Adicionar nó \n[2]- Procurar valor de nó \n[3]- Calcular altura \n[4]- Remover nó \n[5]- Mostrar arvore completa (aumenta muito de tamanho a partir de altura > 5) \n[6]- Mostrar arvore em ordem crescente \n[0]- Sair");
                System.out.print("> ");
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
                        value = scanner.nextInt();
                        Node foundNode = avl.search(value);
                        if (foundNode != null){
                            System.out.println("valor encontrado: " + foundNode.key);
                        } else {
                            System.out.println("valor nao encontrado");
                        }
                        break;

                    case 3:
                        System.out.println("altura da arvore: " + avl.calculateHeight(avl.root));
                        break;

                    case 4:
                        System.out.print("Insira o valor do nó que você quer remover: ");
                        value = scanner.nextInt();
                        avl.remove(value);
                        break;

                    case 5:
                        avl.printByLevel();
                        break;

                    case 6:
                        System.out.print("\n");
                        avl.printTree();
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