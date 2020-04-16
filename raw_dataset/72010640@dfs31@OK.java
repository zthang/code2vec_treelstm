private void dfs31(int now) {
    visited[now] = true;
    int p1 = ans31[parent[now]];
    int p2 = ans31[parent[parent[now]]];
    ans31[now] = 6 - p1 - p2;
    for (int i : tree[now]) {
        if (!visited[i])
            dfs31(i);
    }
}