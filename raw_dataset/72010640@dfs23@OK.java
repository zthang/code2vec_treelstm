private void dfs23(int now) {
    visited[now] = true;
    int p1 = ans23[parent[now]];
    int p2 = ans23[parent[parent[now]]];
    ans23[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs23(i);
    }
}