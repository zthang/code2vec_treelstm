private void dfs13(int now) {
    visited[now] = true;
    int p1 = ans13[parent[now]];
    int p2 = ans13[parent[parent[now]]];
    ans13[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs13(i);
    }
}