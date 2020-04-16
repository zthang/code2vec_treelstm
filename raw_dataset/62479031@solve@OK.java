static void solve() {
    int n = ir.nextInt();
    long[][] c = new long[3][];
    for (int i = 0; i < 3; i++) c[i] = ir.nextLongArray(n);
    Graph[] g = new Graph[n];
    for (int i = 0; i < n; i++) g[i] = new Graph();
    for (int i = 0; i < n - 1; i++) {
        int u = ir.nextInt() - 1;
        int v = ir.nextInt() - 1;
        g[u].add(new long[] { v, 1 });
        g[v].add(new long[] { u, 1 });
    }
    int l = -1;
    for (int i = 0; i < n; i++) {
        if (g[i].size() >= 3) {
            out.println(-1);
            return;
        }
        if (g[i].size() == 1) {
            l = i;
        }
    }
    long[] d = dijkstra(l, g);
    long mi = 1L << 60L;
    int[] b = new int[n];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                continue;
            }
            int r = rest(i, j);
            long tot = 0;
            for (int k = 0; k < n; k++) {
                if (d[k] % 3 == 0) {
                    tot += c[i][k];
                } else if (d[k] % 3 == 1) {
                    tot += c[j][k];
                } else {
                    tot += c[r][k];
                }
            }
            if (mi > tot) {
                mi = tot;
                for (int k = 0; k < n; k++) {
                    if (d[k] % 3 == 0) {
                        b[k] = i + 1;
                    } else if (d[k] % 3 == 1) {
                        b[k] = j + 1;
                    } else {
                        b[k] = r + 1;
                    }
                }
            }
        }
    }
    out.println(mi);
    for (int i = 0; i < n; i++) {
        out.print(b[i] + " ");
    }
    out.println();
}