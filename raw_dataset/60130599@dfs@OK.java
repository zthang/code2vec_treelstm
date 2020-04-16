static boolean dfs(List<List<Pair<Integer, Integer>>> g, boolean[] vis, boolean[] recStk, int i) {
    if (recStk[i])
        return true;
    if (vis[i])
        return false;
    vis[i] = true;
    boolean hasCycle = false;
    recStk[i] = true;
    for (Pair<Integer, Integer> p : g.get(i)) {
        ec[p.b] = i > p.a ? 2 : 1;
        hasCycle |= dfs(g, vis, recStk, p.a);
    }
    recStk[i] = false;
    return hasCycle;
}