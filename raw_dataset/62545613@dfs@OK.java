private void dfs(int v, int p) {
    reverseIndexMap[ind] = v;
    indexMap[v] = ind++;
    for (int to : graph[v]) {
        if (to != p)
            dfs(to, v);
    }
}