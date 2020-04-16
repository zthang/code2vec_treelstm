private void dfs32(int now) {
    visited[now] = true;
    int p1 = ans32[parent[now]];
    int p2 = ans32[parent[parent[now]]];
    ans32[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs32(i);
    }
}