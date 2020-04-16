static boolean dfs(int i, int p, int s) {
    set[i] = s;
    for (int j : graph.get(i)) if (j != p) {
        if (set[j] == set[i])
            return false;
        else if (set[j] == 0 && !dfs(j, i, graph.get(p).contains(j) ? 6 - set[i] - set[p] : set[p]))
            return false;
    }
    return true;
}