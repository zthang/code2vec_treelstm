public int sumExEx(int node, int a, int b) {
    int l = indexInP[a] + 1;
    int r = indexInP[b] - 1;
    if (l > r)
        return 0;
    return cumsum[node][r] - (l == 0 ? 0 : cumsum[node][l - 1]);
}