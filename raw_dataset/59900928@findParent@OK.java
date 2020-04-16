public static int findParent(int idx, int[] parent) {
    if (parent[idx] == idx) {
        return idx;
    }
    parent[idx] = findParent(parent[idx], parent);
    return parent[idx];
}