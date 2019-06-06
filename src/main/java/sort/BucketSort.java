package sort;

import sort.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort implements IntegerSort{
    @Override
    public List<Integer> sort(List<Integer> array) {


        int max = ListUtil.max(array);

        List<List<Integer>> entrance = new ArrayList<>(array.size());


        for (int i = 0; i < array.size(); i++) {
            entrance.add(null);
            int index = index(i, array.size(), array.get(i), max);

        }

                for (int i = 0; i < array.size(); i++) {
            entrance.add(null);
            int index = index(i, array.size(), array.get(i), max);

        }

        return null;



    }

    private int index(int i, int n, int v, int max) {

        return (int) (1.0 * v * n / (max + 1));
    }

    public static void main(String[] args) {

        new BucketSort().sort(Arrays.asList(8, 2, 4,6));
    }


}
