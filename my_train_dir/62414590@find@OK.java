public int find(int x) {
    return (parent[x] == x) ? x : find(parent[x]);
}