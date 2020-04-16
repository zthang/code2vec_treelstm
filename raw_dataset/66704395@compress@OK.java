long[] compress(long[] arr) {
    int n = arr.length;
    long[] rv = Arrays.copyOf(arr, n);
    rv = uniq(rv);
    for (int i = 0; i < n; i++) {
        arr[i] = Arrays.binarySearch(rv, arr[i]);
    }
    return arr;
}