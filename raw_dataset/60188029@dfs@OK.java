boolean dfs(int node, HashSet<Integer> w, HashSet<Integer> g, HashSet<Integer> b) {
    w.remove(node);
    g.add(node);
    for (int itr : graph[node]) {
        if (b.contains(itr))
            continue;
        else if (g.contains(itr))
            return true;
        else if (dfs(itr, w, g, b))
            return true;
    }
    g.remove(node);
    b.add(node);
    return false;
}