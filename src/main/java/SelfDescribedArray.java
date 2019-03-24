import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelfDescribedArray {
    static Set<String> tried = new HashSet<>();
    public static void main(String[] args) {

        int n = 21;

        List<List<Integer>> sets = subsets(n);
        sets.forEach(e -> {
            String key = key(e, n);
            if (!tried.contains(key)) {
                List<Integer> r = finalResult(e, n);
                tried.add(key);
                if (r != null) {
                    System.out.println(r);
                }
            }
        });

    }


    private static List<List<Integer>> subsets(int n) {
        int segments = n - 1;
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, segments); i++) {
            int sum = 0;
            String text = bits(i, segments);
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < segments; j++) {
                sum++;
                if (text.charAt(j) == '1') {
                    array.add(sum);
                    sum = 0;
                }
            }
            sum++;
            array.add(sum);
//            System.out.println(array);
            r.add(array);
        }
        return r;
    }


    private static String bits(long n, long m) {
        String text = Long.toBinaryString(n);
        return text.length() < m ? "0".repeat((int) m - text.length()) + text : text;
    }

    private static List<Integer> finalResult(List<Integer> subset, int n) {


        Map<Integer, Long> countMap = subset.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (subset.size() < n) {
            countMap.put(0, Long.valueOf(n - subset.size()));
        }
        List<Integer> countArray = new ArrayList<>(countMap.values().stream().map(e -> Integer.valueOf(String.valueOf(e))).collect(Collectors.toList()));




        if (subset.size() == countArray.size()) {

            Collections.sort(subset);
            Collections.sort(countArray);

            if (subset.equals(countArray)) {
                return r(countMap, n);
            }
        }
        return null;
    }

    private static List<Integer> r (Map<Integer, Long> countMap, int n) {

        List<Integer> r = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {

            if (countMap.get(i) != null) {
                r.add(i, Integer.valueOf(String.valueOf(countMap.get(i))));
            } else {
                r.add(i, 0);
            }

        }

        return r;
    }

    private static String key(List<Integer> array, int n) {
        Map<Integer, Long> countMap = array.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (countMap.get(i) != null) {

                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(i + "=" + countMap.get(i));
            }
        }
        return sb.toString();
    }
}
