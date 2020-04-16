int root(int x) {
    if (pt[x] == x)
        return x;
    pt[x] = root(pt[x]);
    return pt[x];
}