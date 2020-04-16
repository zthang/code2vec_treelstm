public static int walk(int n, int k) {
    for (int i = 0; i < bl.length && n != -1; i++) {
        if (((1 << i) & k) > 0)
            n = bl[i][n];
    }
    return n;
}