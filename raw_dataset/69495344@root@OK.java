static int root(int at) {
    return at == parent[at] ? at : root(parent[at]);
}