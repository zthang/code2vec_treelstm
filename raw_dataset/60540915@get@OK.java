int get(int x) {
    return p[x] == x ? x : (p[x] = get(p[x]));
}