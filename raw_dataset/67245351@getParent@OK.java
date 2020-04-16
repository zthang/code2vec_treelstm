int getParent(int i) {
    int curr = i;
    while (parent[curr] != curr) curr = parent[curr];
    while (parent[i] != curr) {
        int next = parent[i];
        parent[i] = curr;
        i = next;
    }
    return curr;
}