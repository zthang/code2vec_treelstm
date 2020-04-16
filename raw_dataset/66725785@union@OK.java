void union(int _a, int _b) {
    int p_a = root(_a);
    int p_b = root(_b);
    if (a[p_a].size() > a[p_b].size()) {
        parent[p_b] = p_a;
        for (int i = 0; i < a[p_b].size(); i++) {
            long get = (long) a[p_b].get(i);
            int l = ub(p_a, get);
            int r = lb(p_a, get);
            if (l <= r)
                ans += (r - l + 1);
        }
        merge(p_a, p_b);
    // a[p_b].clear();
    } else {
        parent[p_a] = p_b;
        for (int i = 0; i < a[p_a].size(); i++) {
            long get = (long) a[p_a].get(i);
            int l = ub(p_b, get);
            int r = lb(p_b, get);
            if (l <= r)
                ans += (r - l + 1);
        }
        merge(p_b, p_a);
    // a[p_a].clear();
    }
}