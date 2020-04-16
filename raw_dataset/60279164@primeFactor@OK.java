public static long[] primeFactor(int n) {
    long[] prime = new long[n + 1];
    prime[1] = 1;
    for (int i = 2; i <= n; i++) prime[i] = ((i & 1) == 0) ? 2 : i;
    for (int i = 3; i * i <= n; i++) {
        if (prime[i] == i) {
            for (int j = i * i; j <= n; j += i) {
                if (prime[j] == j)
                    prime[j] = i;
            }
        }
    }
    return prime;
}