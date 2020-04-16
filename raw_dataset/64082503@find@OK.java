public int find(int[] p, int x) {
    while (x != p[x]) {
        p[x] = p[p[x]];
        x = p[x];
    }
    return x;
}