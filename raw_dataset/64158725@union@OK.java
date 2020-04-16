private static void union(int firstParent, int secondParent) {
    if (rank[firstParent] >= rank[secondParent]) {
        parent[secondParent] = firstParent;
        ++rank[firstParent];
    } else {
        parent[firstParent] = secondParent;
        ++rank[secondParent];
    }
}