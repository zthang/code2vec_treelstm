public void unite(int a, int b) {
    a = root(a);
    b = root(b);
    if (a == b) {
        return;
    }
    if (rank[a] < rank[b]) {
        p[a] = b;
    } else {
        p[b] = a;
        if (rank[a] == rank[b]) {
            ++rank[a];
        }
    }
}