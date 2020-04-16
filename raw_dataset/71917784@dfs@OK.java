static void dfs(int v) {
    ArrayList<Integer> toDfs = new ArrayList<>();
    for (int u : unvis) {
        if (!g[v].contains(u)) {
            toDfs.add(u);
        }
    }
    for (int u : toDfs) {
        unvis.remove(u);
    }
    for (int u : toDfs) {
        dfs(u);
    }
}