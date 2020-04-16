public void dfs(int u) {
    marked[u] = true;
    for (Integer i : arr[u]) {
        if (!marked[i])
            dfs(i);
    }
}