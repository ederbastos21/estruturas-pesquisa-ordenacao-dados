import java.util.*;
package br.unicesumar.projeto_2.busca_sequencial;

public class Main {

    static Random random = new Random();

    public static int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) return meio;

            if (vetor[meio] < valor)
                inicio = meio + 1;
            else
                fim = meio - 1;
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
            Arrays.sort(vetor);

            int valor = vetor[random.nextInt(tamanho)];
            int posicao = buscaBinaria(vetor, valor);

            double[] tempos = new double[repeticoes];

            for (int i = 0; i < repeticoes; i++) {
                long inicio = System.nanoTime();
                buscaBinaria(vetor, valor);
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
                            "Encontrado: " + posicao + "\n" +
                            "Média: " + media + " ms" + "\n" +
                            "Desvio: " + desvio
            );
        }
    }
}