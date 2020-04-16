private void dfs2(int node, boolean[] vis, int pre) {
    vis[node] = true;
    for (int nn : graph[node]) {
        vis[nn] = true;
    }
    out: for (int[] A : Q[node]) {
        int idx = A[0];
        for (int i = 1; i < A.length; i++) {
            if (!vis[A[i]]) {
                continue out;
            }
        }
        ret[idx] = 1;
    }
    for (int nn : graph[node]) {
        if (nn != pre) {
            dfs2(nn, vis, node);
        }
    }
    for (int nn : graph[node]) {
        if (nn != pre)
            vis[nn] = false;
    }
}