boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return false;
    par[y] = x;
    return true;
}