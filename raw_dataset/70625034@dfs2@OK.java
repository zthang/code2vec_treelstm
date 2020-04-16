static void dfs2(int root) {
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (vis[i] == 0)
            cnt++;
        if (c[root] + 1 == cnt) {
            ans[root] = i;
            vis[i] = 1;
            break;
        }
    }
    for (int i = 0; i < vec[root].size(); i++) {
        if (vec[root].get(i) == pre[root])
            continue;
        dfs2(vec[root].get(i));
    }
}