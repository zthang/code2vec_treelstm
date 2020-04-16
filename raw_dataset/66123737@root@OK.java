private int root(int x) {
    return (x == root[x]) ? x : (root[x] = root(root[x]));
}