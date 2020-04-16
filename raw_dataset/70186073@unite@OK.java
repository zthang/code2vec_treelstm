void unite(int v, int u, int flag) {
    int pv = find(v);
    int pu = find(u);
    if (!colored[v] && !colored[u]) {
        if (size[pv] < size[pu]) {
            pv ^= pu;
            pu ^= pv;
            pv ^= pu;
            v ^= u;
            u ^= v;
            v ^= u;
        }
        if (flag == 1) {
            color(u, color[v] ^ 1, false);
        } else {
            color(u, color[v], false);
        }
    } else if (!colored[v]) {
        if (flag == 1) {
            color(v, color[u] ^ 1, true);
        } else {
            color(v, color[u], true);
        }
    } else if (!colored[u]) {
        if (flag == 1) {
            color(u, color[v] ^ 1, true);
        } else {
            color(u, color[v], true);
        }
    }
    if (size[pv] < size[pu]) {
        pv ^= pu;
        pu ^= pv;
        pv ^= pu;
        v ^= u;
        u ^= v;
        v ^= u;
    }
    p[pu] = pv;
    size[pv] += size[pu];
    cnt[pv][0] += cnt[pu][0];
    cnt[pv][1] += cnt[pu][1];
    g[v].add(new Edge(u, flag));
    g[u].add(new Edge(v, flag));
}