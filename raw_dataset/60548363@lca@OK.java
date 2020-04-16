public Edge lca(int a, int b) {
    if (a == b) {
        return new Edge(a, 0);
    }
    int v = -1;
    int a1 = a;
    int b1 = b;
    if (tin[a] <= tin[b] && tout[a] >= tout[b]) {
        v = b;
        long lenb = 0;
        for (int i = l; i >= 0; i--) {
            a1 = up[v][i].to;
            b1 = a;
            if (!(tin[a1] <= tin[b1] && tout[a1] >= tout[b1])) {
                lenb += up[v][i].s;
                v = up[v][i].to;
            }
        }
        lenb += up[v][0].s;
        v = up[v][0].to;
        return new Edge(v, lenb);
    }
    if (upper(b, a)) {
        v = a;
        long lena = 0;
        for (int i = l; i >= 0; i--) {
            a1 = up[v][i].to;
            b1 = b;
            if (!(tin[a1] <= tin[b1] && tout[a1] >= tout[b1])) {
                lena += up[v][i].s;
                v = up[v][i].to;
            }
        }
        lena += up[v][0].s;
        v = up[v][0].to;
        return new Edge(v, lena);
    }
    v = a;
    long lena = 0;
    for (int i = l; i >= 0; i--) {
        a1 = up[v][i].to;
        b1 = b;
        if (!(tin[a1] <= tin[b1] && tout[a1] >= tout[b1])) {
            lena += up[v][i].s;
            v = up[v][i].to;
        }
    }
    lena += up[v][0].s;
    v = up[v][0].to;
    v = b;
    long lenb = 0;
    for (int i = l; i >= 0; i--) {
        a1 = up[v][i].to;
        b1 = a;
        if (!(tin[a1] <= tin[b1] && tout[a1] >= tout[b1])) {
            lenb += up[v][i].s;
            v = up[v][i].to;
        }
    }
    lenb += up[v][0].s;
    v = up[v][0].to;
    return new Edge(v, lena + lenb);
}