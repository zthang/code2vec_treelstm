long[][] nextLongArr2(int n, int m) {
    long[][] arr = new long[n][m];
    for (int i = 0; i < n; i++) {
        arr[i] = nextLongArr(m);
    }
    return arr;
}