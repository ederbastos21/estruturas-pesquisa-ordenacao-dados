package br.unicesumar.projeto_1.rubro_negra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RBT rbt = new RBT();
        int choice = -1;
        int value;
        System.out.println("Árvore Rubro-Negra");
        do {
            try {
                //obs. a impressao por nivel mostra a cor ao lado de cada chave sendo R = Rubro e B = Negro
                System.out.println("\n[1]- Adicionar nó \n[2]- Procurar valor de nó \n[3]- Calcular altura \n[4]- Remover nó \n[5]- Mostrar árvore completa (R=Rubro, B=Negro | aumenta de tamanho a partir de altura > 5) \n[6]- Mostrar arvore em ordem crescente \n[0]- Sair");
                System.out.print("> ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Insira o valor do nó: ");
                        value = scanner.nextInt();
                        rbt.insert(value);
                        break;
                    case 2:
                        System.out.print("Insira o valor que você quer procurar: ");
                        value = scanner.nextInt();
                        Node foundNode = rbt.search(value);
                        if (foundNode != null) {
                            System.out.println("Valor " + foundNode.key + " encontrado. Cor: " + (foundNode.isRed ? "Rubro" : "Negro"));
                        } else {
                            System.out.println("Valor " + value + " não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.println("Altura da árvore: " + rbt.calculateHeight());
                        break;
                    case 4:
                        System.out.print("Insira o valor do nó que você quer remover: ");
                        value = scanner.nextInt();
                        rbt.remove(value);
                        break;
                    case 5:
                        rbt.printByLevel();
                        System.out.println();
                        break;
                    case 6:
                        System.out.print("\n");
                        rbt.printTree();
                        System.out.print("\n");
                        break;
                    default:
                        System.out.println("Insira um valor válido.");
                }
            } catch (Exception e) {
                System.out.println("erro encontrado " + e);
                scanner.nextLine();
            }
        } while (choice != 0);
    }
}
