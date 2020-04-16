void dsuUnite(int a, int b) {
    a = dsuGet(a);
    b = dsuGet(b);
    if (a != b) {
        ans -= sz[a] * (sz[a] - 1) / 2;
        ans -= sz[b] * (sz[b] - 1) / 2;
        if (sz[a] < sz[b]) {
            parent[a] = b;
            sz[b] += sz[a];
            ans += sz[b] * (sz[b] - 1) / 2;
        } else {
            parent[b] = a;
            sz[a] += sz[b];
            ans += sz[a] * (sz[a] - 1) / 2;
        }
    }
}