private void dfs12(int now) {
    visited[now] = true;
    int p1 = ans12[parent[now]];
    int p2 = ans12[parent[parent[now]]];
    ans12[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs12(i);
    }
}