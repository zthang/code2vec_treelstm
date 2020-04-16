static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    c = new long[n];
    for (int i = 0; i < n; i++) {
        c[i] = in.nextLong();
    }
    TreeSet<Integer>[] sets = new TreeSet[n];
    Arrays.setAll(sets, set -> new TreeSet<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        sets[u].add(v);
    }
    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
        long h = hash(sets[i]);
        pairs[i] = new Pair(i, h);
    }
    Arrays.sort(pairs, (p1, p2) -> Long.compare(p1.h, p2.h));
    ArrayList<Long> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (pairs[i].h == 0)
            continue;
        long cc = c[pairs[i].i];
        int j = i + 1;
        while (j < n && pairs[j].h == pairs[i].h) {
            cc += c[pairs[j].i];
            j++;
        }
        a.add(cc);
        i = j - 1;
    }
    long g = 0;
    for (long aa : a) {
        g = gcd(g, aa);
    }
    out.println(g);
}