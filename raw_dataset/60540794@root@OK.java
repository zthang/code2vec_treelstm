public int root(int x) {
    while (x != p[x]) {
        x = p[x];
    }
    return x;
}