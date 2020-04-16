public static int minIndex(int[] arr) {
    int min = 10000000;
    int minIndex = 1000000000;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
            minIndex = i;
        }
    }
    return minIndex;
}