package sort;

import java.util.ArrayList;
import java.util.List;

public class CountSort implements Sort {
    @Override
    public List<Integer> sort(List<Integer> array) {
        List<Integer> count = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int max = max(array);

        for (int i = 0; i <= max; i++) {
            count.add(0);
        }

        for (int i = 0; i < array.size(); i++) {
            int value = array.get(i);
            count.set(value, count.get(value) + 1);
        }


        for (int i = 1; i < count.size(); i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        for (int i = array.size() -1; i >=0 ; i --) {


        }


    }

    private int max(List<Integer> array) {
        int max = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }



}
