public void solve() {
    int n = sc.ni();
    int m = sc.ni();
    visit = new int[n];
    adj = new HashSet[n];
    adj1 = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new HashSet();
        adj1[i] = new ArrayList();
    }
    for (int i = 0; i < m; i++) {
        int x = sc.ni() - 1;
        int y = sc.ni() - 1;
        adj[x].add(y);
        adj1[y].add(x);
    }
    cost = new int[n];
    int p = sc.ni();
    int[] path = new int[p];
    for (int i = 0; i < p; i++) path[i] = sc.ni() - 1;
    bfs(path[p - 1]);
    int min = 0, max = 0;
    for (int i = 0; i < p - 2; i++) {
        HashSet<Integer> set = new HashSet();
        int tmp = Integer.MAX_VALUE;
        for (int x : adj[path[i]]) tmp = Math.min(tmp, cost[x]);
        for (int x : adj[path[i]]) if (cost[x] == tmp)
            set.add(x);
        if (!(set.size() == 1 && set.contains(path[i + 1])))
            max++;
        if (!set.contains(path[i + 1]))
            min++;
    }
    pw.println(min + " " + max);
}