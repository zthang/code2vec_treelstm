private void solveD() throws IOException {
    int n = in.nextInt(), m = in.nextInt();
    graph = createGraph(n);
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1, u = in.nextInt() - 1;
        graph[u].add(v);
    }
    int k = in.nextInt();
    int[] p = in.nextIntArray(k);
    for (int i = 0; i < k; i++) p[i]--;
    int[] q = new int[n];
    int ql = 0, qr = 0;
    int[] dist = new int[n], cnt = new int[n];
    fill(dist, n);
    dist[p[k - 1]] = 0;
    q[qr++] = p[k - 1];
    while (ql < qr) {
        int v = q[ql++];
        for (int u : graph[v]) {
            if (dist[u] > dist[v] + 1) {
                dist[u] = dist[v] + 1;
                cnt[u] = 1;
                q[qr++] = u;
            } else if (dist[u] == dist[v] + 1)
                cnt[u]++;
        }
    }
    int min = 0, max = 0;
    for (int i = 0; i < k - 1; i++) {
        if (dist[p[i + 1]] == dist[p[i]] - 1) {
            if (cnt[p[i]] > 1)
                max++;
        } else {
            min++;
            max++;
        }
    }
    out.println(min + " " + max);
}