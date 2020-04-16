static int getRoot(int[] arr, int i) {
    while (arr[i] != i) {
        arr[i] = arr[arr[i]];
        i = arr[i];
    }
    return i;
}