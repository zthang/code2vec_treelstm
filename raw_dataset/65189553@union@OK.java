boolean union(int a, int b) {
    int pa = find(a);
    int pb = find(b);
    if (pa == pb)
        return false;
    if (rank[pa] <= rank[pb]) {
        rank[pb] += rank[pa];
        parent[pa] = pb;
        max[pb] = Math.max(max[pa], max[pb]);
    } else {
        rank[pa] += rank[pb];
        parent[pb] = pa;
        max[pa] = Math.max(max[pa], max[pb]);
    }
    return true;
}