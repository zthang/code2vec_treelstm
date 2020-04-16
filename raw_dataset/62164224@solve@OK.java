void solve() {
    int t = scn.nextInt();
    for (int ii = 1; ii <= t; ii++) {
        int n = scn.nextInt();
        int[] from = new int[n - 1], to = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            from[i] = scn.nextInt() - 1;
            to[i] = scn.nextInt() - 1;
        }
        int[][] g = packU(n, from, to);
        int[][] need = parents3(g, 0);
        int[] par = need[0], order = need[1];
        int[] sub = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i], max = 0, ch = 0;
            for (int v : g[u]) {
                if (v != par[u]) {
                    ch++;
                    max = Math.max(max, sub[v]);
                }
            }
            sub[u] = 1 + max + Math.max(ch - 1, 0);
        }
        int[] vals = new int[n];
        int ans = 0;
        for (int u : order) {
            int max = vals[u], max1 = 0, max2 = 0;
            for (int v : g[u]) {
                if (v != par[u]) {
                    max = Math.max(max, sub[v]);
                    if (sub[v] > max1) {
                        max2 = max1;
                        max1 = sub[v];
                    } else if (sub[v] > max2) {
                        max2 = sub[v];
                    }
                }
            }
            ans = Math.max(ans, max + g[u].length + Math.max(max2 - 1, 0));
            for (int v : g[u]) {
                if (v != par[u]) {
                    max = vals[u];
                    if (sub[v] == max1) {
                        max = Math.max(max2, max);
                    } else {
                        max = Math.max(max1, max);
                    }
                    vals[v] = max + Math.max(g[u].length - 1, 0);
                }
            }
        }
        out.println(ans);
    }
}