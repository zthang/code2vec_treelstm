public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    initGraph(n, m);
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        addEdge(a, b);
        addEdge(b, a);
    }
    int[] deg = new int[n];
    PriorityQueue<Vertex> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        pq.offer(new Vertex(i, deg[i]));
    }
    boolean[] used = new boolean[n];
    int numUsed = 0;
    int ans = 0;
    while (!pq.isEmpty()) {
        Vertex ver = pq.poll();
        int v = ver.id;
        if (ver.deg != deg[v]) {
            continue;
        }
        if (used[v]) {
            continue;
        }
        if (deg[v] == numUsed) {
            ++ans;
        }
        used[v] = true;
        ++numUsed;
        for (int e = firstEdge[v]; e >= 0; e = edgeNxt[e]) {
            int u = edgeDst[e];
            if (used[u]) {
                continue;
            }
            ++deg[u];
            pq.offer(new Vertex(u, deg[u]));
        }
    }
    --ans;
    out.println(ans);
}