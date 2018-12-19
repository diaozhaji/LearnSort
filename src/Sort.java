public class Sort {
    public static int[] bubbleSort(int[] src) {

        for (int i = 0; i < src.length - 1; i++) {
            for (int j = 0; j < src.length - 1 - i; j++) {
                int temp;
                if (src[j] > src[j + 1]) {
                    temp = src[j + 1];
                    src[j + 1] = src[j];
                    src[j] = temp;
                }
            }
        }

        return src;
    }

    public static int[] selectSort(int[] src) {

        for (int i = 0; i < src.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[j] < src[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(src, min, i);
            }
        }

        return src;

    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    public static int[] insertSort(int[] src) {

        int[] result = new int[src.length];
        for (int i = 0; i < src.length; i++) {

        }


        return src;
    }
}
