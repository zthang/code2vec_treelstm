public void solve(int testNumber, FastReader scan, PrintWriter out) {
    n = scan.nextInt();
    m = scan.nextInt();
    adj = new ArrayList[n];
    visited = new boolean[n];
    int ans = 0;
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int a = scan.nextInt() - 1, b = scan.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i])
            res.add(go(i));
    }
    Collections.sort(res);
    int currMax = -1;
    for (Item i : res) {
        if (i.first <= currMax)
            ans++;
        currMax = Math.max(currMax, i.second);
    }
    out.println(ans);
}