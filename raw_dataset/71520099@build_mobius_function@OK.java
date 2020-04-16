private void build_mobius_function(int n) {
    mobius = new int[n + 1];
    sieve = new int[n + 1];
    factors = new int[n + 1][];
    // for (int i = 1; i <= n; i++)factors[i] = new ArrayList<>();
    for (int i = 2; i <= n; i++) sieve[i] = i;
    for (int i = 2; i <= n; i++) {
        if (sieve[i] == i) {
            mobius[i] = -1;
            for (long j = 1L * i * i; j <= n; j += i) sieve[(int) j] = i;
        }
    }
    for (int i = 6; i <= n; i++) {
        if (sieve[i] != i) {
            int pre = i / sieve[i];
            if (pre % sieve[i] != 0)
                mobius[i] = -mobius[pre];
        }
    }
    int[] sz = new int[n + 1];
    long tot = 0;
    for (int i = 2; i <= n; i++) {
        if (mobius[i] != 0) {
            for (int j = i * 2; j <= n; j += i) {
                sz[j]++;
                tot++;
            }
        }
    }
    for (int i = 2; i <= n; i++) {
        factors[i] = new int[sz[i]];
        sz[i] = 0;
    }
    for (int i = 2; i <= n; i++) {
        if (mobius[i] != 0) {
            for (int j = i * 2; j <= n; j += i) {
                factors[j][sz[j]++] = i;
            // factors[j].add(i);
            }
        }
    }
// System.out.println("tot  =  "  + tot);
}