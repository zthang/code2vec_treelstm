static void dfs(int v, boolean[] b) {
    b[v] = true;
    max = Math.max(max, v);
    Iterator<Integer> itr = adj[v].listIterator();
    while (itr.hasNext()) {
        int n = itr.next();
        if (!b[n]) {
            dfs(n, b);
        }
    }
}