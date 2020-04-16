void dfs(int u) {
    int cnt = 0;
    int val = 0;
    size[u] = 1;
    while (cnt <= c[u]) {
        val++;
        if (val > n)
            done = true;
        if (!used[val])
            cnt++;
    }
    ans[u] = val;
    used[val] = true;
    for (int v : tree[u]) {
        dfs(v);
        size[u] += size[v];
    }
    if (c[u] >= size[u])
        done = true;
}