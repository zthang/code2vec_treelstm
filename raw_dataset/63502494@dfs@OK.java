static int dfs(int v) {
    int ret = 1;
    visited[v] = true;
    for (int i : list.get(v)) {
        if (visited[i] == false)
            ret += dfs(i);
    }
    return ret;
}