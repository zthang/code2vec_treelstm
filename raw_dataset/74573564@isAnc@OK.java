boolean isAnc(int v, int u, int[] si, int[] ei) {
    return si[v] <= si[u] && ei[u] <= ei[v];
}