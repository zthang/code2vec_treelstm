static // O(N log log N)
void sieve(// O(N log log N)
int N) {
    isComposite = new int[N + 1];
    idx = new int[N + 1];
    // 0 indicates a prime number
    isComposite[0] = isComposite[1] = 1;
    primes = new ArrayList<Integer>();
    int ix = 1;
    for (// can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    int i = 2; // can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    i <= N; // can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    ++i) if (// can loop in 2 and odd integers for slightly better performance
    isComposite[i] == 0) {
        primes.add(i);
        idx[i] = ix;
        ix++;
        if (1l * i * i <= N)
            for (// j = i * 2 will not affect performance too much, may alter in
            int j = i * i; // j = i * 2 will not affect performance too much, may alter in
            j <= N; // j = i * 2 will not affect performance too much, may alter in
            j += i) // modified sieve
            isComposite[j] = 1;
    }
    p = new int[primes.size()];
    int i = 0;
    for (int x : primes) {
        p[i++] = x;
    }
}