public int get(int x) {
    int x2 = x;
    while (x2 != p[x2]) x2 = p[x2];
    while (x != p[x]) {
        int t = p[x];
        p[x] = x2;
        x = t;
    }
    return x2;
}