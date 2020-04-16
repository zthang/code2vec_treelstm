void work() {
    int n = in.nextInt();
    int m = in.nextInt();
    vis = new boolean[n];
    rec = (HashSet<Integer>[]) new HashSet[n];
    set = new TreeSet();
    for (int i = 0; i < n; i++) rec[i] = new HashSet<>();
    for (int i = 0; i < n; i++) set.add(i);
    for (int i = 0; i < m; i++) {
        int s = in.nextInt() - 1;
        int e = in.nextInt() - 1;
        rec[s].add(e);
        rec[e].add(s);
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            cnt++;
            dfs(i);
        }
    }
    out.println(cnt - 1);
}