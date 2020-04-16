static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        int n = ni(), m = ni();
        adj = new ArrayList[n + 1];
        radj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }
        u = new int[m];
        v = new int[m];
        for (int i = 0; i < m; ++i) {
            int U = ni(), V = ni();
            u[i] = U;
            v[i] = V;
            if (U == V) {
                continue;
            }
            adj[U].add(V);
            radj[V].add(U);
        }
        nel();
        vis = new boolean[n + 1];
        st = new Stack<>();
        for (int i = 1; i <= n; ++i) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        which = new int[n + 1];
        size_scc = new int[n + 1];
        counter = 0;
        vis = new boolean[n + 1];
        while (!st.isEmpty()) {
            int x = st.pop();
            if (!vis[x]) {
                counter++;
                dfs1(x);
            }
        }
        if (size_scc[which[1]] == n) {
            sb.append("No\n");
        } else {
            sb.append("Yes\n");
            int[] deg = new int[n + 1];
            for (int i = 0; i < m; ++i) {
                if (which[u[i]] != which[v[i]]) {
                    deg[which[u[i]]]++;
                }
            }
            int zero_deg = -1;
            for (int i = 1; i <= counter; ++i) {
                if (deg[i] == 0) {
                    zero_deg = i;
                    break;
                }
            }
            int count_jury = 0, count_cats = 0;
            for (int i = 1; i <= n; ++i) {
                if (which[i] == zero_deg) {
                    count_jury++;
                } else {
                    count_cats++;
                }
            }
            sb.append(count_jury + " " + count_cats + "\n");
            for (int i = 1; i <= n; ++i) {
                if (which[i] == zero_deg) {
                    sb.append(i + " ");
                }
            }
            sb.append("\n");
            for (int i = 1; i <= n; ++i) {
                if (which[i] != zero_deg) {
                    sb.append(i + " ");
                }
            }
            sb.append("\n");
        }
    }
    psb(sb);
    pw.flush();
    pw.close();
}