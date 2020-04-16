public static int find(int i) {
    if (parent[i] == i) {
        return i;
    }
    parent[i] = find(parent[i]);
    return parent[i];
}