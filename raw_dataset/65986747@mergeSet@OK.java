public void mergeSet(int a, int b) {
    int pa = findParent(a);
    int pb = findParent(b);
    if (pa == pb)
        return;
    if (rank[pa] > rank[pb]) {
        parent[pb] = pa;
    } else if (rank[pa] < rank[pb]) {
        parent[pa] = pb;
    } else {
        parent[pb] = pa;
        rank[pa]++;
    }
}