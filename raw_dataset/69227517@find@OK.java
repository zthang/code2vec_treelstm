public static int find(int i) {
    if (i == parent[i])
        return i;
    return find(parent[i]);
}