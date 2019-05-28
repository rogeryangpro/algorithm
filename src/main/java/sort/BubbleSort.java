package sort;

import sort.util.ListUtil;

import java.util.List;

public class BubbleSort implements Sort {

    @Override
    public List<Integer> sort(List<Integer> array) {
        for (int i = array.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    ListUtil.switchElement(array, j, j + 1);
                }
            }
        }
        return array;
    }
}
