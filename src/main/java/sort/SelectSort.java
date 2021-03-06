package sort;

import sort.util.ListUtil;

import java.util.Arrays;
import java.util.List;

public class SelectSort implements IntegerSort {
    @Override
    public List<Integer> sort(List<Integer> array) {

        for (int i = 0; i < array.size() - 1; i++) {

            int min = Integer.MAX_VALUE;
            int index = - 1;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < min) {
                    min = array.get(j);
                    index = j;
                }
            }

            if (min < array.get(i)) {
                ListUtil.switchElement(array, i, index );
            }
        }

        return array;
    }

}
