public void unite(int a, int b) {
    a = root(a);
    b = root(b);
    if (a == b)
        return;
    if (rank[a] < rank[b]) {
        // a ^= (b ^= (a ^= b));
        int temp = a;
        a = b;
        b = temp;
    }
    p[b] = a;
    if (rank[a] == rank[b])
        ++rank[a];
    minNode[a] = Integer.min(minNode[a], minNode[b]);
    maxNode[a] = Integer.max(maxNode[a], maxNode[b]);
    components--;
}