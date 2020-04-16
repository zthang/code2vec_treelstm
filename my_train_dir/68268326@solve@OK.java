static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    n = ni();
    c = new int[n + 1];
    par = new int[n + 1];
    lev = new int[n + 1];
    adj = new ArrayList[n + 1];
    sz = new int[n + 1];
    val = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
    }
    int root = -1;
    for (int i = 1; i <= n; ++i) {
        int p = ni();
        c[i] = ni();
        if (p == 0) {
            root = i;
        } else {
            adj[p].add(i);
        }
    }
    dfs(root, root, 0);
    if (invalid) {
        pl("NO");
    } else {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            set.add(i);
        }
        int ptr = 1;
        while (!set.isEmpty()) {
            int which = -1;
            for (int e : set) {
                if (c[e] == 0) {
                    if (which == -1) {
                        which = e;
                    } else {
                        if (lev[which] > lev[e]) {
                            which = e;
                        }
                    }
                }
            }
            if (which == -1) {
                pl("NO");
                System.exit(0);
            }
            set.remove(which);
            val[which] = ptr++;
            int curr = which;
            while (curr != root) {
                if (c[curr] > 0) {
                    c[curr]--;
                }
                curr = par[curr];
            }
            if (c[curr] > 0) {
                c[curr]--;
            }
        }
        pl("YES");
        for (int i = 1; i <= n; ++i) {
            p(val[i]);
        }
        pl();
    }
    pw.flush();
    pw.close();
}