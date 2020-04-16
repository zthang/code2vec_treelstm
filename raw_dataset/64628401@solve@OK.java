public void solve() {
    int n = sc.nextInt();
    edges = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes.add(i);
        edges[i] = new ArrayList<>();
    }
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        edges[a].add(b);
        edges[b].add(a);
    }
    for (int i = 1; i <= n; i++) edges[i].sort(Comparator.naturalOrder());
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (nodes.remove(i)) {
            ans++;
            dfs(i);
        }
    }
    answer(ans - 1);
}