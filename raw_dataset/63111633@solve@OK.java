void solve() {
    int t = scn.nextInt();
    while (t-- > 0) {
        int n = scn.nextInt(), m = scn.nextInt();
        int[] from = new int[m - n], to = new int[m - n];
        for (int i = 0, j = 0; i < m; i++) {
            int u = scn.nextInt() - 1, v = scn.nextInt() - 1;
            if (u != v) {
                from[j] = u;
                to[j] = v;
                j++;
            }
        }
        int[] clust = decomposeToSCC(packD(n, from, to), packD(n, to, from));
        int scc = 0;
        for (int i = 0; i < n; i++) {
            scc = Math.max(scc, clust[i] + 1);
        }
        if (scc == 1) {
            out.println("No");
            continue;
        }
        int[] size = new int[scc];
        for (int s : clust) {
            size[s]++;
        }
        int[] X = new int[m - n], Y = new int[m - n];
        for (int i = 0, j = 0; i < m - n; i++) {
            if (clust[from[i]] == clust[to[i]]) {
                continue;
            }
            X[j] = clust[from[i]];
            Y[j] = clust[to[i]];
            j++;
        }
        int zero = 0;
        boolean[] mark = new boolean[n];
        int[][] g = packD(scc, X, Y);
        for (int i = 0; i < scc; i++) {
            g[i] = scn.uniq(g[i]);
            if (g[i].length == 0) {
                zero++;
                mark[i] = true;
            }
        }
        if (zero == 0) {
            out.println("No");
            continue;
        }
        if (zero == scc) {
            mark[0] = false;
        }
        int x = 0, y = 0;
        for (int i = 0; i < scc; i++) {
            if (mark[i]) {
                x += size[i];
            } else {
                y += size[i];
            }
        }
        out.println("Yes");
        out.println(x + " " + y);
        for (int i = 0; i < n; i++) {
            if (mark[clust[i]]) {
                out.print(i + 1 + " ");
            }
        }
        out.println();
        for (int i = 0; i < n; i++) {
            if (!mark[clust[i]]) {
                out.print(i + 1 + " ");
            }
        }
        out.println();
    }
}