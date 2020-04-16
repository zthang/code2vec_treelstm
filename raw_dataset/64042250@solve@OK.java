void solve() {
    int n = in.nextInt();
    long[] x = new long[n], y = new long[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextLong();
        y[i] = in.nextLong();
    }
    long[] c = in.nextLongArray(n), k = in.nextLongArray(n);
    ArrayList<long[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        list.add(new long[] { c[i], i, n });
        for (int j = i + 1; j < n; j++) {
            long cost = (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])) * (k[i] + k[j]);
            list.add(new long[] { cost, i, j });
        }
    }
    Collections.sort(list, (e1, e2) -> Long.compare(e1[0], e2[0]));
    UnionFind uf = new UnionFind(n + 1);
    long sum = 0;
    ArrayList<Integer> vertex = new ArrayList<>();
    ArrayList<int[]> edge = new ArrayList<>();
    for (long[] q : list) {
        long cost = q[0];
        int s = (int) q[1], t = (int) q[2];
        if (!uf.isSame(s, t)) {
            uf.union(s, t);
            sum += cost;
            if (t == n)
                vertex.add((s + 1));
            else
                edge.add(new int[] { s + 1, t + 1 });
        }
    }
    out.println(sum);
    out.println(vertex.size());
    for (int v : vertex) out.print(v + " ");
    out.println();
    out.println(edge.size());
    for (int[] e : edge) out.println(e[0] + " " + e[1]);
}