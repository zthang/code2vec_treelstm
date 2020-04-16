public void setFactorial() {
    factorial = new long[MAXN];
    factorial[0] = 1;
    for (int i = 1; i < MAXN; ++i) factorial[i] = factorial[i - 1] * i % MOD;
}