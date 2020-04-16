public void solve(int testNumber, FastReader in, FastWriter out) {
    int i, j, k;
    N = in.nextInt();
    Q = in.nextInt();
    edges = new int[N - 1][];
    for (i = 0; i < N - 1; ++i) {
        int a = in.nextInt() - 1, b = in.nextInt() - 1, w = in.nextInt();
        edges[i] = new int[] { a, b, w };
    }
    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
    queries = new long[Q][];
    for (i = 0; i < Q; ++i) queries[i] = new long[] { i, in.nextInt(), -7 };
    Arrays.sort(queries, (a, b) -> Long.compare(a[1], b[1]));
    parent = new int[N];
    Arrays.fill(parent, -7);
    size = new int[N];
    Arrays.fill(size, 1);
    int p = 0;
    for (long[] q : queries) {
        while (p < N - 1 && edges[p][2] <= q[1]) {
            int a = edges[p][0], b = edges[p][1];
            ++p;
            join(a, b);
        }
        q[2] = pairCount;
    }
    Arrays.sort(queries, (a, b) -> Long.compare(a[0], b[0]));
    for (long[] q : queries) out.printsp(q[2]);
    out.println();
    out.flush();
}