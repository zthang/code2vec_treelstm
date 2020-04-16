int[] readIntArray(int n) {
    int[] a = new int[n];
    for (int idx = 0; idx < n; idx++) {
        a[idx] = nextInt();
    }
    return a;
}