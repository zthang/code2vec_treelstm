static void dfs(int i, int p) {
    if (used[i])
        ans++;
    else {
        used[i] = true;
        for (int j : graph.get(i)) if (j != p)
            dfs(j, i);
    }
}