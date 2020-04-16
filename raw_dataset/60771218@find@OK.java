public static int find(int[] parent, int i) {
    if (parent[i] == i)
        return i;
    parent[i] = find(parent, parent[i]);
    return parent[i];
}