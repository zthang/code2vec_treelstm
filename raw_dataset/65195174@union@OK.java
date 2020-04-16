public void union(int i, int j) {
    int root1 = find(i), root2 = find(j);
    if (root2 == root1)
        return;
    if (_rank[root1] > _rank[root2]) {
        _parent[root2] = root1;
    } else if (_rank[root2] > _rank[root1]) {
        _parent[root1] = root2;
    } else {
        _parent[root2] = root1;
        _rank[root1]++;
    }
}