public void makeUnion(int u, int v) {
    int parent1 = getParent(u);
    int parent2 = getParent(v);
    if (parent1 == parent2) {
        return;
    }
    int size1 = size[parent1];
    int size2 = size[parent2];
    if (size1 > size2) {
        parent[parent2] = parent1;
        size[parent1] += size[parent2];
    } else {
        parent[parent1] = parent2;
        size[parent1] += size[parent2];
    }
}