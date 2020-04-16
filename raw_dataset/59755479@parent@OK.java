public int parent(int x) {
    if (p[x] == x)
        return x;
    return p[x] = parent(p[x]);
}