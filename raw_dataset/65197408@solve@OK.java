public void solve() throws IOException {
    int n = readInt();
    int m = readInt();
    int[] parent = new int[n + 1];
    int[] size = new int[n + 1];
    int[] max = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        size[i] = 1;
        max[i] = i;
        parent[i] = i;
    }
    for (int i = 0; i < m; i++) {
        int u = readInt();
        int v = readInt();
        union(parent, u, v, size, max);
    }
    int count = 0;
    int i = 1;
    while (i <= n) {
        int curpar = find(parent, i);
        int j = i + 1;
        while (j <= max[find(parent, i)]) {
            int part = find(parent, j);
            if (part != curpar) {
                count++;
                union(parent, curpar, part, size, max);
            }
            j++;
        }
        i = max[curpar] + 1;
    }
    out.println(count);
}