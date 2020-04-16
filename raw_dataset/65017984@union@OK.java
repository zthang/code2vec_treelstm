boolean union(int a, int b) {
    int pa = find(a);
    int pb = find(b);
    if (pa == pb)
        return false;
    if (rank[pa] <= rank[pb]) {
        rank[pb] += rank[pa];
        parent[pa] = pb;
    } else {
        parent[pb] = pa;
        rank[pa] += rank[pb];
    }
    nsets--;
    return true;
}