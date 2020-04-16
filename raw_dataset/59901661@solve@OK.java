public void solve(int testNumber, InputReader in, PrintWriter out) {
    int t, i, j, tt, k;
    this.out = out;
    this.in = in;
    n = in.nextInt();
    int m = in.nextInt();
    TreeMap<Integer, Long> tm = new TreeMap<>();
    DisjointUnionSets dsu = new DisjointUnionSets(n);
    Entity[] en = new Entity[n - 1];
    for (i = 0; i < n - 1; i++) {
        en[i] = new Entity(in.nextInt() - 1, in.nextInt() - 1, in.nextInt());
    }
    Arrays.sort(en, com);
    int cc = 0;
    int[] a = new int[m];
    int[] b = new int[m];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (i = 0; i < m; i++) {
        a[i] = in.nextInt();
        b[i] = a[i];
    }
    sort(b);
    long ans = 0;
    for (i = 0; i < m; i++) {
        if (tm.containsKey(b[i]))
            continue;
        while (cc < n - 1 && en[cc].c <= b[i]) {
            ans = dsu.union(en[cc].a, en[cc].b, ans);
            cc++;
        }
        tm.put(b[i], ans);
    }
    for (i = 0; i < m; i++) {
        p(tm.get(a[i]));
    }
    pn("");
}