@SuppressWarnings("unchecked")
void solve(FastScanner s, PrintWriter out) {
    N = s.nextInt();
    M = s.nextInt();
    K = s.nextInt();
    spec = new Integer[K];
    for (int i = 0; i < K; i++) spec[i] = s.nextInt() - 1;
    Arrays.setAll(adj = new ArrayList[N], x -> new ArrayList<>());
    for (int i = 0, u, v; i < M; i++) {
        u = s.nextInt() - 1;
        v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    dist1 = bfs(0);
    distN = bfs(N - 1);
    Arrays.sort(spec, (a, b) -> {
        if (dist1[a] == dist1[b])
            return distN[a] - distN[b];
        return dist1[a] - dist1[b];
    });
    int[] smax = new int[K];
    smax[K - 1] = distN[spec[K - 1]];
    for (int i = K - 2; i >= 0; i--) smax[i] = max(smax[i + 1], distN[spec[i]]);
    int max = -1;
    for (int i = 0; i + 1 < K; i++) max = max(max, dist1[spec[i]] + 1 + smax[i + 1]);
    if (max > dist1[N - 1])
        max = dist1[N - 1];
    out.println(max);
}