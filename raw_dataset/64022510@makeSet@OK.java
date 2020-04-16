public void makeSet(int[] parent) {
    // Make set- creating a new element with a parent pointer to itself.
    for (int i = 0; i < vertices; i++) {
        parent[i] = i;
    }
}