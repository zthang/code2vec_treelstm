static long[][] matMul(// C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
long[][] a2, // C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
long[][] b, // C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
int p, // C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
int q, // C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
int r) {
    long[][] C = new long[p][r];
    for (int i = 0; i < p; ++i) {
        for (int j = 0; j < r; ++j) {
            for (int k = 0; k < q; ++k) {
                C[i][j] = (C[i][j] + (a2[i][k] % mod * b[k][j] % mod)) % mod;
                C[i][j] %= mod;
            }
        }
    }
    return C;
}