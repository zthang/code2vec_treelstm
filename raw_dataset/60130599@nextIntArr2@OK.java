int[][] nextIntArr2(int n, int m) {
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
        arr[i] = nextIntArr(m);
    }
    return arr;
}