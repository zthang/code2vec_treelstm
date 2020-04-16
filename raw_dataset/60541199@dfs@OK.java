static void dfs(int cur) {
    seen[cur] = true;
    for (int i = 0; i < edges[cur].size; i++) {
        int next = edges[cur].data[i];
        if (!seen[next]) {
            dfs(next);
        }
    }
}