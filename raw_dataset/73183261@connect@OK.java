private void connect(int u, int v) {
    int u0 = find(u);
    int v0 = find(v);
    if (u0 == v0)
        ;
    else {
        p[u0] = v0;
        size[v0] += size[u0];
        cnt[v0] += cnt[u0];
    }
    cnt[v0]++;
}