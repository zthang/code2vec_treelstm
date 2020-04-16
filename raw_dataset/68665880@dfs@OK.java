private void dfs(int v) {
    vx.remove(v);
    List<Integer> rem = new ArrayList<>();
    for (int node : vx) {
        if (!edge[v].contains(node)) {
            rem.add(node);
        }
    }
    for (int node : rem) vx.remove(node);
    for (int node : rem) dfs(node);
}