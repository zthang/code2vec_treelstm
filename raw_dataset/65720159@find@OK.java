public int find(int x) {
    return f[x] == x ? x : (f[x] = find(f[x]));
}