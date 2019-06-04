package sort;

import sort.util.ListUtil;

import java.util.Arrays;
import java.util.List;

public class InsertSort implements IntegerSort {
    @Override
    public List<Integer> sort(List<Integer> array) {

        if (array == null) {
            return null;
        }

        if (array.size() == 1) {
            return array;
        }

        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0; j--) {
                while (j > 0 && array.get(j) < array.get(j - 1)) {
                    ListUtil.switchElement(array, j, j - 1);
                    j--;
                }
            }
        }
        return array;
    }

}
