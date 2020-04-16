public int root(int[] arr, int num) {
    int i = num;
    while (i != arr[i]) {
        arr[i] = arr[arr[i]];
        i = arr[i];
    }
    return i;
}