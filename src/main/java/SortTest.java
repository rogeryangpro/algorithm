import sort.BubbleSort;
import sort.InsertSort;
import sort.SelectSort;
import sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortTest {

    static List<Sort> sorts = Arrays.asList(new InsertSort(), new SelectSort(), new BubbleSort());

    public static void main(String[] args) {


        List<Integer> array = randomArray(20);

        sorts.forEach(e -> System.out.println(e.sort(array)));
    }

    public static List<Integer> randomArray(int size) {


        Random r = new Random();

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(100));
        }

        return array;
    }
}
