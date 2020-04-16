public static void sieve(int size) {
    sieve = new int[size + 1];
    primes = new ArrayList<Integer>();
    sieve[1] = 1;
    for (int i = 2; i * i <= size; i++) {
        if (sieve[i] == 0) {
            for (int j = i * i; j < size; j += i) {
                sieve[j] = 1;
            }
        }
    }
    for (int i = 2; i <= size; i++) {
        if (sieve[i] == 0)
            primes.add(i);
    }
}