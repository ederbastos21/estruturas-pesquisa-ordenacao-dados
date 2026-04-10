package br.unicesumar.projeto_1.tsp;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int EXECUTIONS = 30;
    private static final int[] DEFAULT_SIZES = {10, 50, 200, 1000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        System.out.println("Caixeiro Viajante - Heurística do Vizinho Mais Próximo");
        do {
            try {
                System.out.println("\n[1]- Executar todos os experimentos padrao (" + formatSizes() + " cidades, " + EXECUTIONS + " execucoes cada)");
                System.out.println("[2]- Executar experimento personalizado");
                System.out.println("[0]- Sair");
                System.out.print("> ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        System.out.println();
                        for (int size : DEFAULT_SIZES) {
                            runExperiment(size);
                        }
                        break;
                    case 2:
                        System.out.print("Insira o número de cidades: ");
                        int numCities = scanner.nextInt();
                        if (numCities < 2) {
                            System.out.println("O número de cidades deve ser maior que 1.");
                        } else {
                            runExperiment(numCities);
                        }
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

    private static void runExperiment(int numCities) {
        double[] distances = new double[EXECUTIONS];
        double[] timesMs = new double[EXECUTIONS];
        Random random = new Random();

        System.out.println("--- Experimento: " + numCities + " cidades | " + EXECUTIONS + " execuções ---");

        for (int exec = 0; exec < EXECUTIONS; exec++) {
            double[][] coordinates = new double[numCities][2];
            for (int i = 0; i < numCities; i++) {
                coordinates[i][0] = random.nextDouble() * 1000;
                coordinates[i][1] = random.nextDouble() * 1000;
            }
            TSP tsp = new TSP(coordinates);
            int startCity = random.nextInt(numCities);
            long startTime = System.nanoTime();
            distances[exec] = tsp.nearestNeighbor(startCity);
            long endTime = System.nanoTime();

            timesMs[exec] = (endTime - startTime) / 1_000_000.0;
        }
        printStats(distances, timesMs);
    }

    private static void printStats(double[] distances, double[] timesMs) {
        double meanDist = calculateMean(distances);
        double stdDevDist = calculateStdDev(distances, meanDist);
        double minDist = calculateMin(distances);
        double maxDist = calculateMax(distances);
        double meanTime = calculateMean(timesMs);
        double stdDevTime = calculateStdDev(timesMs, meanTime);

        System.out.printf(" Distância | Media: %12.2f | DesvPad: %10.2f | Min: %12.2f | Max: %12.2f%n", meanDist, stdDevDist, minDist, maxDist);
        System.out.printf(" Tempo (ms) | Media: %12.4f | DesvPad: %10.4f%n", meanTime, stdDevTime);
        System.out.println();
    }

    private static double calculateMean(double[] data) {
        double sum = 0;
        for (double v : data) sum += v;
        return sum / data.length;
    }

    private static double calculateStdDev(double[] data, double mean) {
        double sum = 0;
        for (double v : data) sum += (v - mean) * (v - mean);
        return Math.sqrt(sum / data.length);
    }

    private static double calculateMin(double[] data) {
        double min = Double.MAX_VALUE;
        for (double v : data) if (v < min) min = v;
        return min;
    }

    private static double calculateMax(double[] data) {
        double max = -Double.MAX_VALUE;
        for (double v : data) if (v > max) max = v;
        return max;
    }

    private static String formatSizes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DEFAULT_SIZES.length; i++) {
            sb.append(DEFAULT_SIZES[i]);
            if (i < DEFAULT_SIZES.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}