public static int findSet(int i) {
    if (parent[i] == i) {
        return i;
    }
    parent[i] = findSet(parent[i]);
    return parent[i];
}