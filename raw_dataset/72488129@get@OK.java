private T get(int from, int to, int node) {
    if (from == l[node] && to == r[node]) {
        return a[node];
    } else {
        if (to <= l[node] + (r[node] - l[node]) / 2) {
            return get(from, to, lch(node));
        } else if (l[node] + (r[node] - l[node]) / 2 <= from) {
            return get(from, to, rch(node));
        } else {
            return op.apply(get(from, l[node] + (r[node] - l[node]) / 2, lch(node)), get(l[node] + (r[node] - l[node]) / 2, to, rch(node)));
        }
    }
}