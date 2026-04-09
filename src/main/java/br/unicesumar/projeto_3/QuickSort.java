import java.util.ArrayDeque;
import java.util.Deque;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSortIterative(array, 0, array.length - 1);
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    private void quickSortIterative(int[] array, int low, int high) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int start = range[0];
            int end = range[1];

            if (start < end) {
                int pivotIndex = partition(array, start, end);

                // Empilha primeiro o maior intervalo por último
                // para manter a pilha menor
                if (pivotIndex - 1 - start > end - (pivotIndex + 1)) {
                    stack.push(new int[]{start, pivotIndex - 1});
                    stack.push(new int[]{pivotIndex + 1, end});
                } else {
                    stack.push(new int[]{pivotIndex + 1, end});
                    stack.push(new int[]{start, pivotIndex - 1});
                }
            }
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}