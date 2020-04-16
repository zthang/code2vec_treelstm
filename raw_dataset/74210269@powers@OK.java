static long powers(long n) {
    int MOD = 1000000007;
    if (n <= 1) {
        return 1;
    }
    n--;
    // This is an identity matrix.
    long[][] res = { { 1, 0 }, { 0, 1 } };
    // this is Transformation matrix.
    long[][] tMat = { { 2, 2 }, { 1, 0 } };
    while (n > 0) {
        if (n % 2 == 1) {
            long[][] tmp = new long[2][2];
            tmp[0][0] = ((res[0][0] * tMat[0][0]) % MOD + (res[0][1] * tMat[1][0]) % MOD) % MOD;
            tmp[0][1] = ((res[0][0] * tMat[0][1]) % MOD + (res[0][1] * tMat[1][1]) % MOD) % MOD;
            tmp[1][0] = ((res[1][0] * tMat[0][0]) % MOD + (res[1][1] * tMat[1][0]) % MOD) % MOD;
            tmp[1][1] = ((res[1][0] * tMat[0][1]) % MOD + (res[1][1] * tMat[1][1]) % MOD) % MOD;
            res[0][0] = tmp[0][0];
            res[0][1] = tmp[0][1];
            res[1][0] = tmp[1][0];
            res[1][1] = tmp[1][1];
        }
        n = n / 2;
        long[][] tmp = new long[2][2];
        tmp[0][0] = ((tMat[0][0] * tMat[0][0]) % MOD + (tMat[0][1] * tMat[1][0]) % MOD) % MOD;
        tmp[0][1] = ((tMat[0][0] * tMat[0][1]) % MOD + (tMat[0][1] * tMat[1][1]) % MOD) % MOD;
        tmp[1][0] = ((tMat[1][0] * tMat[0][0]) % MOD + (tMat[1][1] * tMat[1][0]) % MOD) % MOD;
        tmp[1][1] = ((tMat[1][0] * tMat[0][1]) % MOD + (tMat[1][1] * tMat[1][1]) % MOD) % MOD;
        tMat[0][0] = tmp[0][0];
        tMat[0][1] = tmp[0][1];
        tMat[1][0] = tmp[1][0];
        tMat[1][1] = tmp[1][1];
    }
    return ((res[0][0] * 6) % MOD + (res[0][1] * 2) % MOD) % MOD;
}