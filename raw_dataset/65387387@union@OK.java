public void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[b] > rank[a]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            rank[a]++;
        }
        noOfComponents--;
    }
}