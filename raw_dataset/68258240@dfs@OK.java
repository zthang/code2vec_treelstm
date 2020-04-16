public boolean dfs(int v) {
    if (c[v] > sz[v]) {
        return false;
    }
    a[v] = number.get(c[v]);
    number.remove(c[v]);
    for (int i : to[v]) {
        if (!dfs(i)) {
            return false;
        }
    }
    return true;
}