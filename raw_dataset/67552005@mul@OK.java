matrix mul(matrix b) {
    matrix c = new matrix(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                c.a[i][j] = (c.a[i][j] + a[i][k] * b.a[k][j]) % mod;
            }
        }
    }
    return c;
}