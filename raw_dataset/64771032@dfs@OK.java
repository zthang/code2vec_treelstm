private static void dfs(int u, Collection<Integer>[] adj, TreeSet<Integer> notVisited) {
    notVisited.remove(u);
    Integer next = notVisited.higher(-1);
    while (next != null) {
        if (!adj[u].contains(next))
            dfs(next, adj, notVisited);
        next = notVisited.higher(next);
    }
}