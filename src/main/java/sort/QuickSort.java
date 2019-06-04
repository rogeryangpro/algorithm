package sort;

import sort.util.ListUtil;

import java.util.List;

public class QuickSort implements Sort{
    @Override
    public List<Integer> sort(List<Integer> array) {


        quickSort(array, 0, array.size() - 1);

        return array;
    }




    private void quickSort(List<Integer> array, int p, int r) {

        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private int partition(List<Integer> array, int p, int r) {
        int i = p - 1;
        int sentinel = array.get(r);

        for (int j = p; j < r; j++) {
            if (array.get(j) < sentinel) {
                i++;
                if (i != j) {
                    ListUtil.switchElement(array, i, j);
                }
            }
        }
        ListUtil.switchElement(array, i + 1, r);
        return i + 1;
    }






}
