private int find(int x) {
    if (p[x] == 0)
        return x;
    else
        return p[x] = find(p[x]);
}