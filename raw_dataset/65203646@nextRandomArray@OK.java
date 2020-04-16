int[] nextRandomArray(int n, int low, int lim) {
    int[] arr = new int[n];
    Random r = new Random();
    for (int i = 0; i < n; i++) {
        arr[i] = low + r.nextInt(lim - low + 1);
    }
    return arr;
}