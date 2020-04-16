private int[][] na(int n, int m) {
    int[][] a = new int[n][];
    for (int i = 0; i < n; i++) a[i] = na(m);
    return a;
}