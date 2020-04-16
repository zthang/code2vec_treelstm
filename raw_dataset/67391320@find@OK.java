static int find(int a) {
    if (p[a] == a) {
        return a;
    }
    return p[a] = find(p[a]);
}