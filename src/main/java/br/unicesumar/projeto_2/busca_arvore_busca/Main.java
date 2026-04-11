package br.unicesumar.projeto_2.busca_arvore_busca;
import java.util.*;

public class Main {

    static Random random = new Random();

    static class No {
        int valor;
        No esquerda, direita;

        No(int valor) {
            this.valor = valor;
        }
    }

    public static No inserir(No raiz, int valor) {
        if (raiz == null) return new No(valor);

        if (valor < raiz.valor)
            raiz.esquerda = inserir(raiz.esquerda, valor);
        else
            raiz.direita = inserir(raiz.direita, valor);

        return raiz;
    }

    public static boolean buscaArvore(No raiz, int valor) {
        if (raiz == null) return false;

        if (raiz.valor == valor) return true;

        if (valor < raiz.valor)
            return buscaArvore(raiz.esquerda, valor);
        else
            return buscaArvore(raiz.direita, valor);
    }

    public static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }

    public static double media(double[] valores) {
        double soma = 0;
        for (double v : valores) soma += v;
        return soma / valores.length;
    }

    public static double desvioPadrao(double[] valores, double media) {
        double soma = 0;
        for (double v : valores) {
            soma += Math.pow(v - media, 2);
        }
        return Math.sqrt(soma / valores.length);
    }

    public static void main(String[] args) {

        int[] tamanhos = {1000, 5000, 10000, 20000};
        int repeticoes = 30;

        for (int tamanho : tamanhos) {

            int[] vetor = gerarVetor(tamanho);

            No raiz = null;
            for (int v : vetor) {
                raiz = inserir(raiz, v);
            }

            int valor = vetor[random.nextInt(tamanho)];
            boolean encontrado = buscaArvore(raiz, valor);

            double[] tempos = new double[repeticoes];

            for (int i = 0; i < repeticoes; i++) {
                long inicio = System.nanoTime();
                buscaArvore(raiz, valor);
                long fim = System.nanoTime();
                tempos[i] = (fim - inicio) / 1e6;
            }

            double media = media(tempos);
            double desvio = desvioPadrao(tempos, media);

            System.out.println(
                    "\n-----------------------------------\n" +
                            "Busca em Árvore - Tamanho: " + tamanho + "\n" +
                            "-----------------------------------\n" +
                            "Valor: " + valor + "\n" +
                            "Encontrado: " + encontrado + "\n" +
                            "Média: " + media + " ms" + "\n" +
                            "Desvio: " + desvio
            );
        }
    }
}