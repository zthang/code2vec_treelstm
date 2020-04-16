static // O(sqrt(N) / ln sqrt(N))
TreeSet<Long> primeFactors(// O(sqrt(N) / ln sqrt(N))
long N) {
    // take abs(N) in case of -ve integers
    TreeSet<Long> factors = new TreeSet<Long>();
    int idx = 0, p = primes.get(idx);
    while (p * p <= N) {
        while (N % p == 0) {
            factors.add((long) p);
            N /= p;
        }
        if (primes.size() > idx + 1)
            p = primes.get(++idx);
        else
            break;
    }
    if (// last prime factor may be > sqrt(N)
    N != 1)
        // for integers whose largest prime factor has a power of 1
        factors.add(N);
    return factors;
}