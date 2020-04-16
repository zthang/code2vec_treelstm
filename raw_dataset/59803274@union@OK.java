void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (x == y)
        return;
    if (rank[x] < rank[y]) {
        par[x] = y;
        ans -= res(size[x]);
        ans -= res(size[y]);
        ans += res(size[x] + size[y]);
        size[y] += size[x];
        hs.remove(x);
    } else if (rank[y] < rank[x]) {
        par[y] = x;
        ans -= res(size[x]);
        ans -= res(size[y]);
        ans += res(size[x] + size[y]);
        size[x] += size[y];
        hs.remove(y);
    } else {
        par[x] = y;
        ans -= res(size[x]);
        ans -= res(size[y]);
        ans += res(size[x] + size[y]);
        size[y] += size[x];
        hs.remove(x);
        rank[y]++;
    }
}