int lcaA(int u, int v) {
    if (lcaA[u][v] != -1)
        return lcaA[u][v];
    if (u == v)
        return lcaA[u][v] = u;
    if (depA[u] >= depA[v])
        return lcaA[u][v] = lcaA(parA[u], v);
    else
        return lcaA[u][v] = lcaA(u, parA[v]);
}