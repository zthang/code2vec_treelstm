static void solve() throws IOException {
    n = nextInt();
    k = nextInt();
    list = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
    for (int i = 0; i < k; i++) {
        int u = nextInt();
        int v = nextInt();
        list.get(u).add(v);
        list.get(v).add(u);
    }
    visited = new boolean[n + 1];
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (visited[i] == false) {
            ans += dfs(i) - 1;
        }
    }
    out.println(k - ans);
}