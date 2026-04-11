package br.unicesumar.projeto_3;

import br.unicesumar.projeto_3.*;

public class Main {

    public static void main(String[] args) {
        SortAlgorithm[] algorithms = {
                new MergeSort(),
                new QuickSort()
        };

        int[] sizes = {1000, 5000, 10000, 50000};
        int repetitions = 30;

        BenchmarkRunner runner = new BenchmarkRunner();

        for (int size : sizes) {
            int[] ascending = ArrayGenerator.generateSortedAscendingArray(size);
            int[] random = ArrayGenerator.generateRandomArray(size);
            int[] descending = ArrayGenerator.generateSortedDescendingArray(size);

            for (SortAlgorithm algorithm : algorithms) {
                if (algorithm instanceof MergeSort) {
                    printResult(runner.runBenchmark(algorithm, ascending, repetitions, "Melhor Caso"));
                    printResult(runner.runBenchmark(algorithm, random, repetitions, "Caso Médio"));
                    printResult(runner.runBenchmark(algorithm, descending, repetitions, "Pior Caso"));
                } else if (algorithm instanceof QuickSort) {
                    printResult(runner.runBenchmark(algorithm, random, repetitions, "Caso Médio"));
                    printResult(runner.runBenchmark(algorithm, ascending, repetitions, "Pior Caso (crescente)"));
                    printResult(runner.runBenchmark(algorithm, descending, repetitions, "Pior Caso (decrescente)"));
                }
            }
        }
    }

    private static void printResult(BenchmarkResult result) {
        System.out.println("--------------------------------------------------");
        System.out.println("Algoritmo: " + result.getAlgorithmName());
        System.out.println("Tipo de caso: " + result.getCaseType());
        System.out.println("Tamanho do vetor: " + result.getArraySize());
        System.out.printf("Média: %.2f ns%n", result.getMean());
        System.out.printf("Mediana: %.2f ns%n", result.getMedian());
        System.out.printf("Desvio padrão: %.2f ns%n", result.getStandardDeviation());
        System.out.println("Mínimo: " + result.getMin() + " ns");
        System.out.println("Máximo: " + result.getMax() + " ns");
    }
}