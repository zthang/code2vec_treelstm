void solve(FastScanner s, PrintWriter out) {
    N = s.nextInt();
    M = s.nextInt();
    DSU = new DisjointSet(N);
    for (int i = 0, u, v; i < M; i++) {
        u = s.nextInt() - 1;
        v = s.nextInt() - 1;
        DSU.union(u, v);
    }
    for (int i = 0; i < N; i++) {
        int k = DSU.find(i);
        if (!hm.containsKey(k))
            hm.put(k, new TreeSet<>());
        hm.get(k).add(i);
    }
    PriorityQueue<int[]> ranges = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    for (TreeSet<Integer> sets : hm.values()) {
        int lo = sets.first(), hi = sets.last();
        ranges.add(new int[] { lo, 1 });
        ranges.add(new int[] { hi, -1 });
    }
    int occ = 0, res = 0, round = 0, cur[];
    while (!ranges.isEmpty()) {
        cur = ranges.poll();
        occ += cur[1];
        if (cur[1] == 1)
            round++;
        if (occ == 0) {
            res += round - 1;
            round = 0;
        }
    }
    out.println(res);
}