int root(int node) {
    if (table[node] == node) {
        return node;
    } else {
        return table[node] = root(table[node]);
    }
}