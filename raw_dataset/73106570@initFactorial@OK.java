public static void initFactorial(int n, long mod) {
    fact = new long[n + 1];
    fact[0] = 1;
    for (int i = 1; i < n + 1; i++) fact[i] = (fact[i - 1] * i) % mod;
}