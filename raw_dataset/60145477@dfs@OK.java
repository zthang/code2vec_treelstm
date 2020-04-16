static boolean dfs(int s) {
    if (stack[s])
        return true;
    if (vis[s])
        return false;
    vis[s] = stack[s] = true;
    for (int i : adj[s]) {
        if (dfs(i))
            return true;
    }
    stack[s] = false;
    return false;
}