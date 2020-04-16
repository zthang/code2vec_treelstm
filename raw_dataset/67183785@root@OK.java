long root(int n, int p, long w) {
    long sub = 1;
    for (long[] ch : tree[n].ch) {
        if (ch[0] != p) {
            sub += root((int) ch[0], n, ch[1]);
        }
    }
    min += (sub % 2) * w;
    max += Math.min(N - sub, sub) * w;
    return sub;
}