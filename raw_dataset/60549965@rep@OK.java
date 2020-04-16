public int rep(int x) {
    if (__rep[x] == x) {
        return x;
    }
    int r = rep(__rep[x]);
    __rep[x] = r;
    return r;
}