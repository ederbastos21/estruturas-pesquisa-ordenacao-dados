package br.unicesumar.projeto_3;

public class BenchmarkRunner {

    public BenchmarkResult runBenchmark(SortAlgorithm algorithm, int[] baseArray, int repetitions, String caseType) {
        long[] executionTimes = new long[repetitions];

        for (int i = 0; i < repetitions; i++) {
            int[] workingArray = ArrayGenerator.copyArray(baseArray);

            long start = System.nanoTime();
            algorithm.sort(workingArray);
            long end = System.nanoTime();

            executionTimes[i] = end - start;

            if (!isSorted(workingArray)) {
                throw new IllegalStateException("Erro: o vetor não foi ordenado corretamente por " + algorithm.getName());
            }
        }

        return new BenchmarkResult(
                algorithm.getName(),
                caseType,
                baseArray.length,
                executionTimes
        );
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
