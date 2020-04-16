void dfs(int s) {
    if (u[s])
        return;
    u[s] = true;
    for (int i : a[s]) {
        if (!u[i])
            dfs(i);
    }
}