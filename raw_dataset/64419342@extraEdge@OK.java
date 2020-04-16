public int extraEdge(int x) {
    int r = find(x);
    return edge[r] - size[r] + 1;
}