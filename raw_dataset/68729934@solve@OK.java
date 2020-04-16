static void solve() {
    int n = in.nextInt();
    g = new ArrayList[n + 1];
    Arrays.setAll(g, i -> new ArrayList<>());
    for (int i = 1; i <= n; i++) {
        int a = in.nextInt();
        g[i].add(i - a);
    }
    vis = new boolean[n + 1];
    ans = new ArrayList<>();
    int v = 1;
    vis[v] = true;
    while (true) {
        v = g[v].get(0);
        if (vis[v]) {
            int from = v;
            ans.add(v);
            v = g[v].get(0);
            while (v != from) {
                ans.add(v);
                v = g[v].get(0);
            }
            break;
        } else {
            vis[v] = true;
        }
    }
    out.println(ans.size());
    for (int i : ans) {
        out.print(i + " ");
    }
    out.println();
}