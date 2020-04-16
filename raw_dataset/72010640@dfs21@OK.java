private void dfs21(int now) {
    visited[now] = true;
    int p1 = ans21[parent[now]];
    int p2 = ans21[parent[parent[now]]];
    ans21[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs21(i);
    }
}