package sort;

import sort.util.ListUtil;

import java.util.List;

public class HeapSort implements Sort {
    @Override
    public List<Integer> sort(List<Integer> array) {
        heapSort(array);

        return array;
    }


    private static void maxHeapify(Heap heap, int i) {

        int largest = i;

        List<Integer> array = heap.array;

        int left = left(i);

        if (left < heap.size && array.get(i) < array.get(left)) {
            largest = left;
        }

        int right = right(i);

        if (right < heap.size && array.get(largest) < array.get(right)) {
            largest = right;
        }

        if (largest != i) {
            ListUtil.switchElement(array, i, largest);
            maxHeapify(heap, largest);
        }

    }

    private static void buildMaxHeap(Heap heap) {
        for (int i = heap.array.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i);
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

    private void heapSort(List<Integer> array) {
        Heap heap = new Heap(array);
        buildMaxHeap(heap);

        for (int i = heap.array.size() - 1; i > 0; i--) {
            ListUtil.switchElement(heap.array, i, 0);
            heap.decrease();
            maxHeapify(heap, 0);
        }
    }
}
