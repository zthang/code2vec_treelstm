public static int dfs(int u, int p) {
    if (p > -1) {
        if (score[u] >= 0)
            score[u] += Math.max(0, score[p] - score[u]);
        else
            score[u] += Math.max(0, score[p]);
    }
    for (int i : adjList[u]) {
        if (p != i)
            dfs(i, u);
    }
    return 0;
}