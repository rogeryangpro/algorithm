package sort.util;

import sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort implements Sort {
    @Override
    public List<Integer> sort(List<Integer> array) {
        return null;
    }


    private static void maxHeapify(List<Integer> array, int i) {

        int largest = i;

        int left = left(i);

        if (left < array.size() && array.get(i) < array.get(left)) {
            largest = left;
        }

        int right = right(i);

        if (right < array.size() && array.get(i) < array.get(right)) {
            largest = right;
        }

        if (largest != i) {
            ListUtil.switchElement(array, i, largest);
            maxHeapify(array, largest);
        }

    }

    private static void buildMaxHeap(List<Integer> array) {
        for (int i = array.size() / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int parent(int i) {
        return i % 2 == 0 ? i / 2 - 1 : i / 2;
    }

    public static void main(String[] args) {


        List<Integer> array = new ArrayList<>(Arrays.asList(3, 2, 4, 8, 7, 6));

        buildMaxHeap(array);

        System.out.println(array);


    }
}
