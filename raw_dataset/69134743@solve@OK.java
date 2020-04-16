void solve() {
    int[] primes = sieveEratosthenes(5000);
    int n = ni();
    int D = 5000;
    int[] f = new int[D + 1];
    for (int i = 0; i < n; i++) f[ni()]++;
    int m = primes.length;
    int[] which = new int[5001];
    {
        int gen = 0;
        for (int p : primes) {
            which[p] = gen++;
        }
    }
    int[] lpf = enumLowestPrimeFactors(D + 1);
    int[][] fas = new int[5001][m];
    for (int i = 2; i <= D; i++) {
        System.arraycopy(fas[i - 1], 0, fas[i], 0, m);
        int k = i;
        while (k > 1) {
            fas[i][which[lpf[k]]]++;
            k /= lpf[k];
        }
    }
    // tr(s);
    // 15567
    // 669
    long dist = 0;
    for (int i = 1; i <= D; i++) {
        for (int v : fas[i]) {
            dist += (long) v * f[i];
        }
    }
    boolean[] can = new boolean[D + 1];
    Arrays.fill(can, true);
    outer: while (true) {
        int[] fm = new int[m];
        int cn = 0;
        for (int i = 1; i <= D; i++) {
            if (!can[i])
                continue;
            cn++;
            int last = last(fas[i]);
            if (last != -1)
                fm[last] += f[i];
        }
        for (int i = 0; i < m; i++) {
            if (fm[i] > n - fm[i]) {
                for (int j = 1; j <= D; j++) {
                    if (can[j]) {
                        int last = last(fas[j]);
                        if (last == i) {
                            fas[j][last]--;
                        } else {
                            can[j] = false;
                        }
                    }
                }
                dist = dist - fm[i] + (n - fm[i]);
                continue outer;
            }
        }
        break;
    }
    out.println(dist);
}