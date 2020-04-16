static long[] primes(int to) {
    long[] all = new long[to + 1];
    long[] primes = new long[to + 1];
    all[1] = 1;
    int primesLength = 0;
    for (int i = 2; i <= to; i++) {
        if (all[i] == 0) {
            primes[primesLength++] = i;
            all[i] = i;
        }
        for (int j = 0; j < primesLength && i * primes[j] <= to && all[i] >= primes[j]; j++) {
            all[(int) (i * primes[j])] = primes[j];
        }
    }
    return Arrays.copyOf(primes, primesLength);
}