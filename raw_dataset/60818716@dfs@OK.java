static void dfs(int v) {
    col[v] = 1;
    // System.out.println(Arrays.toString(list));
    for (Pair<Integer, Integer> p : g[v]) {
        int to = p.getLeft(), id = p.getRight();
        if (col[to] == 0) {
            dfs(to);
            res[id] = 1;
        } else if (col[to] == 2)
            res[id] = 1;
        else {
            res[id] = 2;
            cyc = true;
        }
    }
    col[v] = 2;
}