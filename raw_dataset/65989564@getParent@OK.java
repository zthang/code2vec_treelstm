public int getParent(int x, int[] parent) {
    if (x == parent[x]) {
        return x;
    }
    return parent[x] = getParent(parent[x], parent);
}