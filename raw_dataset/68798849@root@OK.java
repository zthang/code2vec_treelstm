public static int root(int[] arr, int i) {
    while (arr[i] != i) {
        i = arr[i];
    }
    return i;
}