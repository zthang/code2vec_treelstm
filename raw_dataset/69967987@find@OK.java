public static int find(int[] arr, int i) {
    if (arr[i] != i)
        arr[i] = find(arr, arr[i]);
    return arr[i];
}