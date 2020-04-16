void union(int x, int y) {
    int px = find(x), py = find(y);
    if (px == py)
        return;
    par[py] = px;
}