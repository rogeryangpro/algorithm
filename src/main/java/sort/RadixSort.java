package sort;


import java.util.List;

public class RadixSort implements IntegerSort {

    @Override
    public List<Integer> sort(List<Integer> array) {

        int md = maxDigitCount(array);

        if (md == 0) {
            return array;
        }

        AnotherCountSort anotherCountSort = new AnotherCountSort();

        for (int i = 0; i < md; i++) {
            array = anotherCountSort.sort(array, i);
        }
        return array;
    }


    private int maxDigitCount(List<Integer> array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            int d = digitsOf(array.get(i));
            if (count < d) {
                count = d;
            }
        }
        return count;
    }

    private int digitsOf(int num) {
        int i = 0;

        while (num > 0) {
            num /= 10;
            i++;
        }
        return i;
    }


}
