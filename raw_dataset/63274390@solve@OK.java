public void solve(InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    int q = in.nextInt();
    PriorityQueue<edge> pq = new PriorityQueue<edge>();
    for (int i = 0; i < n - 1; i++) {
        int f = in.nextInt() - 1;
        int t = in.nextInt() - 1;
        int l = in.nextInt();
        edge e = new edge(f, t, l);
        pq.add(e);
    }
    pair[] query = new pair[q];
    for (int i = 0; i < q; i++) {
        query[i] = new pair(in.nextInt(), i);
    }
    Arrays.sort(query);
    DSU dsu = new DSU(n);
    Set<Integer> block = new HashSet<Integer>();
    int p = 0;
    long[] ret = new long[q];
    long tot = 0;
    while (!pq.isEmpty()) {
        edge x = pq.poll();
        int f = x.f;
        int t = x.t;
        int l = x.l;
        while (p < q && query[p].v < l) ret[query[p++].idx] = tot;
        int block1 = dsu.find(f);
        int block2 = dsu.find(t);
        if (block1 == block2)
            continue;
        if (block.contains(block2)) {
            block.remove(block2);
            tot -= (long) dsu.size(block2) * (dsu.size(block2) - 1) / 2;
        }
        if (block.contains(block1)) {
            block.remove(block1);
            tot -= (long) dsu.size(block1) * (dsu.size(block1) - 1) / 2;
        }
        if (f < t) {
            block.add(block1);
            dsu.union(f, t);
            tot += (long) dsu.size(block1) * (dsu.size(block1) - 1) / 2;
        } else {
            block.add(block2);
            dsu.union(t, f);
            tot += (long) dsu.size(block2) * (dsu.size(block2) - 1) / 2;
        }
    }
    for (int i = p; i < q; i++) ret[query[i].idx] = tot;
    for (int i = 0; i < q; i++) {
        if (i > 0)
            out.print(" ");
        out.print(ret[i]);
    }
    out.println();
}