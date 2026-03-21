package br.unicesumar.projeto_1.bst;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int escolha;
        int valor;
        Node root = new Node (10);

        System.out.println("root: " + root.value);
        do{
            Node atual = root;

            System.out.println("\n1- Adicionar nó // 2- Procurar valor de nó // 3- calcular Altura // 0 - sair");
            System.out.print("escreva sua ação: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    break;
                case 1:
                    System.out.print("Insira o valor do nó: ");
                    valor = scanner.nextInt();
                    bst.insert(valor, atual);
                    break;
                case 2:
                    System.out.print("insira o valor que voce quer procurar: ");
                    valor = scanner.nextInt();
                    Node valorEncontrado = bst.search(valor, atual);
                    if (valorEncontrado != null){
                        System.out.println("valor " + bst.search(valor, atual).value + " encontrado");
                    } else {
                        System.out.println("valor " + valor + " nao encontrado");
                    }
                    break;
                case 3:
                    System.out.println(bst.calcularAltura(atual));
                    break;
                default:
                    System.out.println("insira um valor valido");
            }
        } while (escolha != 0);
    }
}
