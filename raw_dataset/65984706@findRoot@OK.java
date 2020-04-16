public int findRoot(int curr) {
    if (curr == parent[curr])
        return curr;
    return parent[curr] = findRoot(parent[curr]);
}