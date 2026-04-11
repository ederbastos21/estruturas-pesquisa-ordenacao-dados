package br.unicesumar.projeto_3;

import java.util.Random;

public class ArrayGenerator {
    private static final Random RANDOM = new Random();

    private ArrayGenerator() {
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(size * 10);
        }

        return array;
    }

    public static int[] generateSortedAscendingArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    public static int[] generateSortedDescendingArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        return array;
    }

    public static int[] copyArray(int[] original) {
        return original.clone();
    }
}
