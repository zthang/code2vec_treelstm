int[][] next2DInt(int n, int m) {
    int[][] arr = new int[n][];
    for (int i = 0; i < n; i++) {
        arr[i] = nextIntArray(m);
    }
    return arr;
}