private void dfs(int node) {
    if (vis[node])
        return;
    vis[node] = true;
    ArrayList<Integer> list = new ArrayList<>();
    for (int nn : set) {
        if (!rec[node].contains(nn)) {
            list.add(nn);
        }
    }
    for (int nn : list) set.remove(nn);
    for (int nn : list) dfs(nn);
}