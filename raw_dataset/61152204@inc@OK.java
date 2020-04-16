public static void inc(int[] arr) {
    int add = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
        arr[i] += add;
        arr[i] %= 6;
        if (arr[i] != 0) {
            add = 0;
        }
    }
}