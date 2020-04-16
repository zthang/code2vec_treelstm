static long dfs(int i, int p) {
    long ans = 0;
    for (int j : graph.get(i)) if (j != p)
        ans = max(ans, dfs(j, i));
    return ans + w[i];
}