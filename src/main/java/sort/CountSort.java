package sort;

import sort.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class CountSort implements IntegerSort {
    @Override
    public List<Integer> sort(List<Integer> array) {
        List<Integer> count = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int max = ListUtil.max(array);

        for (int i = 0; i <= max; i++) {
            count.add(0);
        }

        for (int i = 0; i < array.size(); i++) {
            int value = array.get(i);
            result.add(0);
            count.set(value, count.get(value) + 1);
        }


        for (int i = 1; i < count.size(); i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        for (int i = array.size() - 1; i >= 0; i--) {
            result.set(count.get(array.get(i)) - 1, array.get(i));
            count.set(array.get(i), count.get(array.get(i)) - 1);
        }

        return result;

    }





}
