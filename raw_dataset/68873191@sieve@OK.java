static // O(N log log N)
void sieve(// O(N log log N)
int N) {
    isComposite = new int[N + 1];
    // 0 indicates a prime number
    isComposite[0] = isComposite[1] = 1;
    primes = new ArrayList<Integer>();
    l = new ArrayList<>();
    valid = new int[N + 1];
    for (// can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    int i = 2; // can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    i <= N; // can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
    ++i) if (// can loop in 2 and odd integers for slightly better performance
    isComposite[i] == 0) {
        primes.add(i);
        l.add(i);
        valid[i] = 1;
        for (int j = i * 2; j <= N; j += i) {
            // j = i * 2 will not affect performance too much, may alter in modified sieve
            isComposite[j] = 1;
        }
    }
    for (int i = 0; i < primes.size(); i++) {
        for (int j : primes) {
            if (primes.get(i) * j > N) {
                break;
            }
            valid[primes.get(i) * j] = 1;
        }
    }
}