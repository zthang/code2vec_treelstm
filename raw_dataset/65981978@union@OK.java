static void union(int i, int j) {
    i = find(i);
    j = find(j);
    if (i != j) {
        if (rank[i] > rank[j]) {
            parent[j] = i;
        } else if (rank[j] > rank[i])
            parent[i] = j;
        else {
            parent[i] = j;
            rank[j]++;
        }
    }
}