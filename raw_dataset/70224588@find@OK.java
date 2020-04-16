Pair find(int v) {
    if (s[v].p == v) {
        return new Pair(v, 0);
    }
    Pair pa = find(s[v].p);
    s[v].p = pa.v;
    s[v].flag ^= pa.flag;
    return new Pair(s[v].p, s[v].flag);
}