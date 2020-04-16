static void dfs(ArrayList<ArrayList<Integer>> g, int nd, int ch, int ct) {
    p[nd][ch] = ct;
    ++ctr[ct];
    int i, j;
    for (i = 0; i < g.get(nd).size(); ++i) {
        j = g.get(nd).get(i);
        if (p[j][ch] != -1)
            continue;
        dfs(g, j, ch, ct);
    }
}