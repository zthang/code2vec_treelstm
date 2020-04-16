public void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
        return;
    }
    if (rank[a] == rank[b]) {
        rank[a]++;
    }
    if (rank[a] > rank[b]) {
        p[b] = a;
    } else {
        p[a] = b;
    }
}