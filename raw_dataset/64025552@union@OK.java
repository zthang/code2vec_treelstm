static void union(int a, int b) {
    uf[parent(a)] = uf[parent(b)];
    cost[parent(a)] = cost[parent(b)];
}