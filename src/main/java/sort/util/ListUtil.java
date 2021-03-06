package sort.util;

import java.util.List;

public class ListUtil {

    public static void switchElement(List list, int i , int j) {
        if (list == null || list.size() < i + 1 || list.size() < j + 1) {
            return;
        }

        Object temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static int max(List<Integer> array) {
        int max = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

}
