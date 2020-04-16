void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = s.nextInt();
    cost = s.next2DLongArray(3, N);
    deg = new int[N];
    adj = new int[N][2];
    int k = N, u, v;
    while (--k > 0) {
        u = s.nextInt() - 1;
        v = s.nextInt() - 1;
        if (deg[u] == 2) {
            out.println(-1);
            return;
        }
        if (deg[v] == 2) {
            out.println(-1);
            return;
        }
        adj[u][deg[u]++] = v;
        adj[v][deg[v]++] = u;
    }
    root = 0;
    while (deg[root] != 1) root++;
    order = new int[N];
    v = root;
    u = -1;
    k = 0;
    order[k++] = v;
    int w;
    while (k < N) {
        w = adj[v][0] == u ? adj[v][1] : adj[v][0];
        u = v;
        v = w;
        order[k++] = v;
    }
    int[][] perms = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
    int[] opt = null;
    long min = (long) Integer.MAX_VALUE * Integer.MAX_VALUE;
    for (int[] p : perms) {
        long price = 0;
        for (int i = 0; i < N; i++) price += cost[p[i % 3]][order[i]];
        if (price < min) {
            min = price;
            opt = p;
        }
    }
    int[] col = new int[N];
    for (int i = 0; i < N; i++) {
        col[order[i]] = opt[i % 3] + 1;
    }
    out.println(min);
    for (int x : col) out.print(x + " ");
    out.println();
}