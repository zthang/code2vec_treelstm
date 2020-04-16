public void solve() throws IOException {
    int n = readInt();
    int m = readInt();
    Edge[] edge = new Edge[n - 1];
    for (int i = 0; i < n - 1; i++) {
        int u = readInt();
        int v = readInt();
        int w = readInt();
        edge[i] = new Edge(u, v, w);
    }
    Arrays.sort(edge);
    query[] q = new query[m];
    for (int i = 0; i < m; i++) {
        int a = readInt();
        q[i] = new query(a, i);
    }
    Arrays.sort(q);
    long[] fina = new long[m];
    int[] parent = new int[n + 1];
    int[] size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    int i = 0;
    long change = 0;
    for (int j = 0; j < m; j++) {
        int val = q[j].m;
        int index = q[j].index;
        while (i < n - 1 && edge[i].val <= val) {
            int u = edge[i].u;
            int v = edge[i].v;
            change = change + union(parent, size, u, v);
            i++;
        }
        fina[index] = change;
    }
    for (int j = 0; j < m; j++) out.print(fina[j] + " ");
}