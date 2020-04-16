private void union(int a, int b) {
    int rootA = root(a);
    int rootB = root(b);
    if (rootA == rootB) {
        return;
    }
    if (size[rootA] < size[rootB]) {
        parent[rootA] = parent[rootB];
        size[rootB] += size[rootA];
        size[rootA] = size[rootB];
    } else {
        parent[rootB] = parent[rootA];
        size[rootA] += size[rootB];
        size[rootB] = size[rootA];
    }
    size1--;
// System.out.println(Arrays.toString(parent));
}