void work() {
    n = in.nextInt();
    int m = in.nextInt();
    a = in.nextInt() - 1;
    b = in.nextInt() - 1;
    cnt = 0;
    mid = 0;
    graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int s = in.nextInt() - 1, e = in.nextInt() - 1;
        graph[s].add(e);
        graph[e].add(s);
    }
    boolean[] vis = new boolean[n];
    for (int nn : graph[a]) {
        if (vis[nn] || nn == b)
            continue;
        boolean[] flag = new boolean[1];
        int v = dfs(nn, flag, vis);
        if (flag[0])
            mid += v;
        if (!flag[0])
            cnt += v;
    }
    int c2 = n - 2 - cnt - mid;
    out.println((long) c2 * cnt);
}