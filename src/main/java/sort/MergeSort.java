package sort;

import sort.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort implements Sort {

    @Override
    public List<Integer> sort(List<Integer> array) {
        mergeSort(array, 0, array.size() - 1);
        return array;
    }

    private void mergeSort(List<Integer> array, int start, int end) {

        System.out.println(start + " -- " + end);
        if (start < end) {
            if (start == end - 1) {
                if (array.get(start) > array.get(end)) {
                    ListUtil.switchElement(array, start, end);
                }
                return;
            }


            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid + 1, end);
        }
    }


    /**
     * @param array
     * @param start
     * @param middle start index of the right part
     * @param end
     */
    private void merge(List<Integer> array, int start, int middle, int end) {
        int i = 0;
        int j = 0;

        List<Integer> left = new ArrayList<>(array.subList(start, middle));
        List<Integer> right = new ArrayList<>(array.subList(middle, end + 1));

        int index = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                array.set(index, left.get(i));
                index++;
                i++;
            } else {
                array.set(index, right.get(j));
                index++;
                j++;
            }
        }

        while (i < left.size()) {
            array.set(index, left.get(i));
            index++;
            i++;
        }

        while (j < right.size()) {
            array.set(index, right.get(j));
            index++;
            j++;
        }
    }


}
