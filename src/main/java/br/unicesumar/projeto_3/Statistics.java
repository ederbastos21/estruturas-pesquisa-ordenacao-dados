package br.unicesumar.projeto_3;

import java.util.Arrays;

public class Statistics {

    private Statistics() {
    }

    public static double mean(long[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }

        long sum = 0;
        for (long value : values) {
            sum += value;
        }

        return (double) sum / values.length;
    }

    public static double median(long[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }

        long[] copy = values.clone();
        Arrays.sort(copy);

        int middle = copy.length / 2;

        if (copy.length % 2 == 0) {
            return (copy[middle - 1] + copy[middle]) / 2.0;
        }

        return copy[middle];
    }

    public static double standardDeviation(long[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }

        double mean = mean(values);
        double sum = 0.0;

        for (long value : values) {
            double diff = value - mean;
            sum += diff * diff;
        }

        return Math.sqrt(sum / values.length);
    }

    public static long min(long[] values) {
        if (values == null || values.length == 0) {
            return 0L;
        }

        long min = values[0];
        for (long value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public static long max(long[] values) {
        if (values == null || values.length == 0) {
            return 0L;
        }

        long max = values[0];
        for (long value : values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
