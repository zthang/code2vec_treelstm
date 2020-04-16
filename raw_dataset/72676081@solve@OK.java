public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    long[] c = new long[n];
    for (int i = 0; i < n; i++) c[i] = s.nextLong();
    ArrayList<Integer>[] a = new ArrayList[n];
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    int[] hash = new int[n];
    hash[0] = 1;
    for (int i = 1; i < n; i++) {
        hash[i] = hash[i - 1] << 1;
        hash[i] %= mod;
    }
    HashMap<Long, Long> t = new HashMap<>();
    while (m-- > 0) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        a[v].add(u);
    }
    for (int i = 0; i < n; i++) {
        if (a[i].isEmpty())
            continue;
        long val = 0;
        for (int j : a[i]) val += hash[j];
        t.put(val, t.getOrDefault(val, 0L) + c[i]);
    }
    long gcd = 0;
    for (Map.Entry<Long, Long> e : t.entrySet()) gcd = func.gcd(gcd, e.getValue());
    w.println(gcd);
}