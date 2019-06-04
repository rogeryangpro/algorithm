import sort.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortTest {

    static List<IntegerSort> sorts = Arrays.asList(
            new InsertSort(),
            new SelectSort(),
            new BubbleSort(),
            new MergeSort(),
            new HeapSort(),
            new QuickSort(),
            new CountSort()
    );

    public static void main(String[] args) {


        List<Integer> array = randomArray(40);

        sorts.forEach(e -> {
                    long s = System.currentTimeMillis();
                    List<Integer> r = e.sort(array);
                    System.out.println(r + " in " + (System.currentTimeMillis() - s) + " ms");
                }
        );

    }

    public static List<Integer> randomArray(int size) {


        Random r = new Random();

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(1000));
        }

        return array;
    }
}
