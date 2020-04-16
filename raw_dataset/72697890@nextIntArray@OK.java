public int[] nextIntArray(int n, int off) {
    int[] arr = new int[n + off];
    for (int i = 0; i < n; i++) {
        arr[i + off] = nextInt();
    }
    return arr;
}