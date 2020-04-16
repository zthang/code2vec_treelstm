static void sieve(int n) {
    Arrays.fill(hash, true);
    for (int p = 2; p * p < n; p++) if (hash[p] == true)
        for (int i = p * 2; i < n; i += p) hash[i] = false;
}