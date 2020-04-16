void dfs(int u, int l, int p, int[] par, int[] si, int[] ei, int[] d, ArrayList<Integer>[] g) {
    si[u] = t++;
    d[u] = l;
    par[u] = p;
    if (g[u] != null)
        for (int nbr : g[u]) if (nbr != p)
            dfs(nbr, l + 1, u, par, si, ei, d, g);
    ei[u] = t++;
}