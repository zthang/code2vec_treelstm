public static void dfs(int u, HashMap<Integer, HashSet<Integer>> adj, TreeSet<Integer> comp, boolean[] used) {
    comp.add(u + 1);
    for (int v : adj.get(u)) {
        if (used[v])
            continue;
        used[v] = true;
        dfs(v, adj, comp, used);
    }
}