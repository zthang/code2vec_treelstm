public static long merge(int start, int end, int[] parent, int[] rank) {
    int repA = findParent(start, parent);
    int repB = findParent(end, parent);
    if (repA == repB) {
        return 0;
    }
    long difference = (rank[repA] + rank[repB]) * 1L * (rank[repA] + rank[repB] - 1) - rank[repA] * 1L * (rank[repA] - 1) - rank[repB] * 1L * (rank[repB] - 1);
    if (rank[repA] < rank[repB]) {
        parent[repA] = repB;
        rank[repB] += rank[repA];
    } else {
        parent[repB] = repA;
        rank[repA] += rank[repB];
    }
    return difference;
}