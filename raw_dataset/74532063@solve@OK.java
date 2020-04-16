public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt(), q = c.readInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    lca ll = new lca(0, adj);
    while (q-- > 0) {
        int k = c.readInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = c.readInt() - 1;
        }
        if (k == 1) {
            w.printLine("YES");
            continue;
        }
        int helloHowAreYou = -1;
        int maxHeight = a[0];
        for (int i = 1; i < k; i++) {
            if (ll.height[maxHeight] < ll.height[a[i]]) {
                maxHeight = a[i];
            }
        }
        boolean found = true;
        for (int j = 0; j < k; j++) {
            int kk = ll.__query(maxHeight, a[j]);
            if (kk != a[j]) {
                int kkk = ll.__query(maxHeight, ll.lca[a[j]][0]);
                if (kkk != ll.lca[a[j]][0]) {
                    found = false;
                    break;
                }
            }
        }
        if (found) {
            w.printLine("YES");
            continue;
        }
        found = true;
        int cnt = 0, ind = -1;
        for (int i = 0; i < k; i++) {
            if (ll.height[a[i]] > ll.height[ll.lca[maxHeight][0]]) {
                cnt++;
                ind = i;
            }
        }
        if (cnt > 1) {
            w.printLine("NO");
            continue;
        }
        if (maxHeight != 0) {
            int par = ll.lca[maxHeight][0];
            for (int j = 0; j < k; j++) {
                if (j == ind) {
                    continue;
                }
                int kk = ll.__query(par, a[j]);
                if (kk != a[j]) {
                    int kkk = ll.__query(par, ll.lca[a[j]][0]);
                    if (kkk != ll.lca[a[j]][0]) {
                        found = false;
                        break;
                    }
                }
            }
        }
        if (found) {
            w.printLine("YES");
        } else {
            w.printLine("NO");
        }
    }
}