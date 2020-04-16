public long[] lapar(int n) {
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
        arr[i] = lpar();
    }
    return arr;
}