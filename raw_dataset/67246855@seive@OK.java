static void seive(int N) {
    si = new int[N];
    primes = new ArrayList<>();
    si[1] = 1;
    for (int i = 2; i < N; i++) {
        if (si[i] == 0) {
            si[i] = i;
            primes.add(i);
        }
        for (int j = 0; j < primes.size() && primes.get(j) <= si[i] && (i * primes.get(j)) < N; j++) si[primes.get(j) * i] = primes.get(j);
    }
}