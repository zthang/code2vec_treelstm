void solve(PrintWriter out, Reader in) throws IOException {
    n = in.nextInt();
    k = in.nextInt();
    adj = new ArrayList[n + 1];
    int[][] arr = new int[k + 1][2];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) {
        arr[i][0] = in.nextInt();
        arr[i][1] = in.nextInt();
        adj[arr[i][0]].add(arr[i][1]);
        adj[arr[i][1]].add(arr[i][0]);
    }
    vis = new boolean[n + 1];
    ans = k;
    for (int i = 0; i < k; i++) {
        if (!vis[arr[i][0]]) {
            vis[arr[i][0]] = true;
            dfs(arr[i][0]);
        }
    }
    out.println(ans);
}