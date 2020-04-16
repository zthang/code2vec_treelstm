private long[][] matPow(long[][] mat0, long p) {
    int n = mat0.length;
    long[][] ans = matIdentity(n);
    long[][] mat = matCopy(mat0);
    while (p > 0) {
        if (p % 2 == 1) {
            ans = matMul(ans, mat);
        }
        p /= 2;
        mat = matMul(mat, mat);
    }
    return ans;
}