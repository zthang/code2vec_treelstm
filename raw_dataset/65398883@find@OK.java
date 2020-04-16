static int find(int[] parent, int a) {
    if (a != parent[a])
        a = find(parent, parent[a]);
    return a;
}