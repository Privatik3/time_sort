import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        String[] algorithmNames = new String[] {"BubbleSort",
                "InsertionSort",
                "SelectionSort",
                "StandartSort"};

        for (String algorithmName : algorithmNames) {

            try {
                System.out.println(String.format("%s отработал за: %d ms", algorithmName, getSortTime(algorithmName)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static long getSortTime(String algorithmName) throws Exception {

        Sorted someSorted = factorySort(algorithmName);
        long t0, t1;

        if (someSorted != null) {
            int[] arr = new int[100_000];
            Random rad = new Random();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = rad.nextInt();
            }

            t0 = System.currentTimeMillis();
            someSorted.sort(arr);
            t1 = System.currentTimeMillis();
        } else {
            throw new Exception("Неправильное название алгоритма");
        }

        return t1 - t0;
    }

    static Sorted factorySort(String algorithmName) {

        if ("BubbleSort".equals(algorithmName)) {
            return new BubbleSort();
        } else if ("InsertionSort".equals(algorithmName)) {
            return new InsertionSort();
        } else if ("SelectionSort".equals(algorithmName)) {
            return new InsertionSort();
        } else if ("StandartSort".equals(algorithmName)) {
            return new StandartSort();
        }

        return null;
    }
}