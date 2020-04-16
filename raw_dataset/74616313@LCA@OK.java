static int LCA(int x, int y) {
    if (isAncestor(x, y))
        return x;
    if (isAncestor(y, x))
        return y;
    for (int i = 20; i >= 0; i--) {
        if (!isAncestor(up[x][i], y))
            x = up[x][i];
    }
    return up[x][0];
}