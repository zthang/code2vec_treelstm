public void union(int i, int j) {
    int root1 = find(i);
    int root2 = find(j);
    if (root2 == root1)
        return;
    if (rank[root1] > rank[root2]) {
        parent[root2] = root1;
    } else if (rank[root2] > rank[root1]) {
        parent[root1] = root2;
    } else {
        parent[root2] = root1;
        rank[root1]++;
    }
}