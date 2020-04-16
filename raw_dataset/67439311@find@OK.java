public static int find(int x) {
    return parent[x] == x ? x : (parent[x] = find(parent[x]));
}