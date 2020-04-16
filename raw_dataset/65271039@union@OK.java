void union(int n1, int n2, long level) {
    n1 = getRoot(n1);
    n2 = getRoot(n2);
    if (n1 == n2)
        return;
    if (qs[n1] == null) {
        root[n1] = n2;
        return;
    }
    if (qs[n2] == null) {
        root[n2] = n1;
        return;
    }
    if (qs[n1].size() < qs[n2].size()) {
        union(n2, n1, level);
        return;
    }
    for (int i : qs[n2]) {
        int other = getRoot(a[i]) == n2 ? getRoot(b[i]) : getRoot(a[i]);
        if (other == n1) {
            res[i] = level;
            qs[n1].remove(i);
        } else {
            qs[n1].add(i);
        }
    }
    qs[n2] = null;
    root[n2] = n1;
}