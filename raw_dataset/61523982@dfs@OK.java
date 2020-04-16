static void dfs(int n) {
    visited[n] = true;
    for (int i = 1; i <= 3; i++) {
        if (!color[n][i]) {
            can[n] = i;
            break;
        }
    }
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        color[idx][can[n]] = true;
    }
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        if (!visited[idx]) {
            dfs(idx);
        }
    }
}