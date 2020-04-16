static void calculate(int i) {
    if (vis[i] == 1)
        return;
    vis[i] = 1;
    for (int j = 1; j <= n; j++) {
        if (graph[i][j] == 1 && dom[val[i]][val[j]] != -1) {
            max++;
            dom[val[i]][val[j]] = dom[val[j]][val[i]] = -1;
        }
    }
    for (int j = 1; j <= n; j++) if (graph[i][j] == 1)
        calculate(j);
}