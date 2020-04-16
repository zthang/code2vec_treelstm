int lcaB(int u, int v) {
    if (lcaB[u][v] != -1)
        return lcaB[u][v];
    if (u == v)
        return lcaB[u][v] = u;
    if (depB[u] >= depB[v])
        return lcaB[u][v] = lcaB(parB[u], v);
    else
        return lcaB[u][v] = lcaB(u, parB[v]);
}