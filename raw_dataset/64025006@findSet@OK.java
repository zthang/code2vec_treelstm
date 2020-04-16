int findSet(int x) {
    if (p[x] == x)
        return x;
    else
        return p[x] = findSet(p[x]);
}