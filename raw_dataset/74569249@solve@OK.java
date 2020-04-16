public void solve() {
    int n = sc.ni();
    int m = sc.ni();
    in = new int[n];
    out = new int[n];
    prr = new int[n];
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList();
    for (int i = 0; i < n - 1; i++) {
        int x = sc.ni();
        int y = sc.ni();
        adj[x - 1].add(y - 1);
        adj[y - 1].add(x - 1);
    }
    time = 0;
    dfs(0, 0);
    while (m-- > 0) {
        int t = sc.ni();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < t; i++) list.add(prr[sc.ni() - 1]);
        Collections.sort(list, (p, q) -> (in[p] - in[q]));
        int x = in[0];
        int y = out[0];
        int res = 0;
        for (int i : list) {
            if (in[i] >= x && out[i] <= y) {
                x = in[i];
                y = out[i];
            } else
                res = -1;
        }
        if (res == -1)
            pw.println("NO");
        else
            pw.println("YES");
    }
}