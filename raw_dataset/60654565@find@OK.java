public int find(int v) {
    if (v == parents[v])
        return v;
    return parents[v] = find(parents[v]);
}