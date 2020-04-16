public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt();
    int[] map = new int[2 * n];
    int[] idx = new int[2 * n];
    Arrays.fill(map, -1);
    Arrays.fill(idx, -1);
    for (int i = 0; i < n; i++) {
        int l = s.nextInt() - 1, r = s.nextInt() - 1;
        map[l] = r;
        idx[l] = i;
        idx[r] = i;
    }
    int edgecount = 0;
    TreeSet<Integer> ts = new TreeSet<>();
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < 2 * n; i++) {
        if (map[i] == -1)
            continue;
        while (!ts.isEmpty() && ts.first() < i) ts.remove(ts.first());
        ts.add(map[i]);
        int x = map[i] - 1;
        while (ts.floor(x) != null) {
            x = ts.floor(x);
            adj[idx[i]].add(idx[x]);
            adj[idx[x]].add(idx[i]);
            edgecount++;
            x = x - 1;
            if (edgecount >= n) {
                w.println("NO");
                return;
            }
        }
    }
    if (edgecount < n - 1) {
        w.println("NO");
        return;
    }
    vis = new int[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (vis[i] == 0) {
            dfs(i);
            count++;
        }
    }
    if (count == 1)
        w.println("YES");
    else
        w.println("NO");
}