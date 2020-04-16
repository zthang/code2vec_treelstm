void dfs(int node) {
    visited[node] = true;
    incycle[node] = true;
    for (pair p : arrayList[node]) {
        int k = p.b;
        if (incycle[k]) {
            ans[p.index] = 2;
        }
        if (!visited[k]) {
            dfs(k);
        }
    }
    incycle[node] = false;
}