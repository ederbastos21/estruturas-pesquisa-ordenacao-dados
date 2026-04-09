package br.unicesumar.projeto_2.busca_sequencial;

import java.util.*;

public class Main {

    static Random random = new Random();

    public static int buscaSequencial(int[] vetor, int valor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
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
            int valor = vetor[random.nextInt(tamanho)];

            int posicao = buscaSequencial(vetor, valor);

            double[] tempos = new double[repeticoes];

            for (int i = 0; i < repeticoes; i++) {
                long inicio = System.nanoTime();
                buscaSequencial(vetor, valor);
                long fim = System.nanoTime();
                tempos[i] = (fim - inicio) / 1e6;
            }

            double media = media(tempos);
            double desvio = desvioPadrao(tempos, media);

            System.out.println(
                    "\n-----------------------------------\n" +
                            "Busca Sequencial - Tamanho: " + tamanho + "\n" +
                            "-----------------------------------\n" +
                            "Valor: " + valor + "\n" +
                            "Posição: " + posicao + "\n" +
                            "Média: " + media + " ms" + "\n" +
                            "Desvio: " + desvio
            );
        }
    }
}