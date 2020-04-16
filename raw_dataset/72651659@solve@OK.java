void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    long[] c = new long[2 * n];
    for (int i = 0; i < n; i++) c[n + i] = nl();
    long[] r = new long[2 * n];
    Random rr = new Random();
    for (int i = 0; i < n; i++) r[i] = rr.nextLong();
    int[] from = new int[m], to = new int[m];
    long[] rand = new long[2 * n];
    boolean[] f = new boolean[n << 1];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1 + n;
        rand[to[i]] ^= r[from[i]];
        f[to[i]] = true;
    }
    HashMap<Long, Long> mp = new HashMap<>();
    for (int i = n; i < 2 * n; i++) mp.put(rand[i], mp.getOrDefault(rand[i], 0L) + c[i]);
    long ans = 0;
    for (int i = n; i < 2 * n; i++) {
        if (f[i])
            ans = gcd(ans, mp.get(rand[i]));
    }
    pn(ans);
}