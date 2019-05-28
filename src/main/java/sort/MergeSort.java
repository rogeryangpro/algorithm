package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {
    @Override
    public List<Integer> sort(List<Integer> array) {



        return null;
    }


    private void merge(List<Integer> array, int start, int middle, int end) {

        int i = start;
        int j = middle;

        List<Integer> left = new ArrayList<>(middle - start);
        List<Integer> right = new ArrayList<>(end - middle + 1);

        while (i < middle || j <= end) {

            if (array.get(i) <= array.get(j)) {

            }
        }

    }



}
