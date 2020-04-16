void run() {
    vis = new int[n];
    dfsNum = new int[n];
    low = new int[n];
    bridges = new ArrayList<>();
    cuts = new ArrayList<>();
    bccs = new ArrayList<>();
    eStack = new ArrayDeque<>();
    num = 0;
    for (int i = 0; i < n; i++) {
        if (vis[i] != 0)
            continue;
        dfs(i, -1);
    }
}