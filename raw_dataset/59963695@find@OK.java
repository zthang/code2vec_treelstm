static int find(int a) {
    if (a == p[a])
        return a;
    p[a] = find(p[a]);
    return p[a];
}