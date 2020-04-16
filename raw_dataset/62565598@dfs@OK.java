static void dfs(int a, int p) {
    boolean first = true;
    perm.add(a);
    for (int i : graph[a].edges) {
        if (i != p) {
            if (first) {
                dfs(i, a);
                if (!o) {
                    return;
                }
                first = false;
            } else {
                o = false;
                return;
            }
        }
    }
}