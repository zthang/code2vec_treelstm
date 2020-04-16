static int find(int x) {
    if (p[x] == x)
        return x;
    return p[x] = find(p[x]);
}