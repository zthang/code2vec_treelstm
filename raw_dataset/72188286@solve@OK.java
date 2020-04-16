void solve(PrintWriter out, Reader in) throws IOException {
    n = in.nextInt();
    m = in.nextInt();
    depth = new int[n + 1];
    cnt = new int[n + 1];
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<Integer>();
    int u = 0, v = 0;
    for (int i = 0; i < m; i++) {
        u = in.nextInt();
        v = in.nextInt();
        adj[v].add(u);
    }
    k = in.nextInt();
    arr = new int[k];
    for (int i = 0; i < k; i++) arr[i] = in.nextInt();
    vis = new boolean[n + 1];
    BFS();
    int min = 0, max = 0;
    for (int i = 1; i < k; i++) {
        if (depth[arr[i]] != depth[arr[i - 1]] - 1)
            min++;
        else {
            if (cnt[arr[i - 1]] > 1)
                max++;
        }
    }
    max += min;
    out.println(min + " " + max);
}