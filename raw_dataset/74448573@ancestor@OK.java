int ancestor(int u, int dep, int[][] sparse) {
    for (int i = 0; dep > 0 && u != -1; dep >>>= 1, i++) {
        if ((dep & 1) == 1)
            u = sparse[i][u];
    }
    return u;
}