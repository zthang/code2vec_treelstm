public static int[] sieve(int LIM) {
    int i, count = 0;
    boolean[] b = new boolean[LIM];
    for (i = 2; i < LIM; ++i) if (!b[i]) {
        count++;
        for (int j = i << 1; j < LIM; j += i) b[j] = true;
    }
    int[] primes = new int[count];
    for (i = 2, count = 0; i < LIM; ++i) if (!b[i])
        primes[count++] = i;
    return primes;
}