void union(int data1, int data2) {
    int parent1 = find(data1);
    int parent2 = find(data2);
    if (parent1 != parent2) {
        if (rank[parent1] >= rank[parent2]) {
            parent[parent2] = parent1;
            if (rank[parent1] == rank[parent2])
                rank[parent1]++;
        } else {
            parent[parent1] = parent2;
        }
    }
}