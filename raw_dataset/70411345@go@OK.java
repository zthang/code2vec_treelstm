void go(int rt, List<Integer>[] g) {
    str[ct] = rt;
    f[rt] = ct;
    for (int cd : g[rt]) {
        ct++;
        go(cd, g);
    }
    b[rt] = ct;
}