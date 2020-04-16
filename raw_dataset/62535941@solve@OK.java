static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    int[] w = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
        w[i] = ni();
    }
    HashSet<Integer>[] adj = new HashSet[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new HashSet<>();
    }
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        adj[v].add(u);
    }
    int s = ni();
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; ++i) {
        if (i == s) {
            continue;
        }
        if (adj[i].size() == 1) {
            queue.addFirst(i);
        }
    }
    boolean[] popped = new boolean[n + 1];
    long[] max_subtree = new long[n + 1];
    while (!queue.isEmpty()) {
        int curr = queue.pollFirst();
        popped[curr] = true;
        int par = -1;
        for (int e : adj[curr]) {
            par = e;
        }
        max_subtree[par] = max(max_subtree[par], w[curr] + max_subtree[curr]);
        adj[par].remove(curr);
        if (adj[par].size() == 1 && par != s) {
            queue.addFirst(par);
        }
    }
    long ans = 0, max = 0;
    for (int i = 1; i <= n; ++i) {
        if (!popped[i]) {
            ans += w[i];
            max = max(max, max_subtree[i]);
        }
    }
    pl((ans + max));
    pw.flush();
    pw.close();
}