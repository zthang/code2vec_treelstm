matrix add(matrix b) {
    matrix c = new matrix(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            c.a[i][j] = (a[i][j] + b.a[i][j]) % mod;
        }
    }
    return c;
}