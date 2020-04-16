static void dfs(int cur) {
    for (int i : adj[cur]) {
        if (color[i] != 0)
            continue;
        if (color[cur] == 2)
            color[i] = 3;
        else
            color[i] = 2;
        dfs(i);
    }
}