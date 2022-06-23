public class Main {
    public static void main(String[] args) {

        int[] array = {15, 0, 25, 65, 88, 7, 9, 71, 91};

        System.out.println(secondMax1(array));
    }

    private static int secondMax(int[] array) {
        int max, secondMax;

        if (array[0] > array[1]) {
            max = array[0];
            secondMax = array[1];
        } else {
            max = array[1];
            secondMax = array[0];
        }
        for (int i = 2; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
                continue;
            }
            if (array[i] > secondMax) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    private static int secondMax1(int[] array) {
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                max = array[i];
            }

        }
        for (int i = 0; i < array.length - 1; i++) {
            if ((max - array[i]) < (max - array[i + 1])) {
                tmp = array[i];
            } else tmp = array[i + 1];

        }
        return tmp;
    }
}
