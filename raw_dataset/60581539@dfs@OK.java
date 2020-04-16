static void dfs(int a, int par) {
    visited[a] = true;
    for (int i : graph[a].edges) {
        if (i == par) {
            continue;
        }
        if (!visited[i]) {
            if (i > a) {
                done.put(new DCowAndSnacks.Pair(a, i, 0), 1);
            } else {
                done.put(new DCowAndSnacks.Pair(i, a, 0), 1);
            }
            dfs(i, a);
        } else {
            DCowAndSnacks.Pair p;
            if (i > a) {
                p = new DCowAndSnacks.Pair(a, i, 0);
            } else {
                p = new DCowAndSnacks.Pair(i, a, 0);
            }
            if (done.get(p) == null) {
                done.put(p, 1);
                ans++;
            }
        }
    }
}