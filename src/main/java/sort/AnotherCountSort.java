package sort;

import com.google.common.math.IntMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnotherCountSort {
    public List<Integer> sort(List<Integer> array, int d) {
        List<Integer> count = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int max = max(array, d);

        for (int i = 0; i <= max; i++) {
            count.add(0);
        }

        for (int i = 0; i < array.size(); i++) {
            int value = numberAtDigit(array.get(i), d);
            result.add(0);
            count.set(value, count.get(value) + 1);
        }


        for (int i = 1; i < count.size(); i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        for (int i = array.size() - 1; i >= 0; i--) {
            int value = numberAtDigit(array.get(i), d);
            result.set(count.get(value) - 1, array.get(i));
            count.set(value, count.get(value) - 1);
        }

        return result;

    }

    private int max(List<Integer> array, int d) {
        int max = -1;
        for (int i = 0; i < array.size(); i++) {

            int value = numberAtDigit(array.get(i), d);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    /**
     *
     * @param n
     * @param d 个位是0 十位是1 以此类推
     * @return
     */
    public int numberAtDigit(int n, int d) {
        return (n / IntMath.pow(10, d)) % 10;
    }




}
